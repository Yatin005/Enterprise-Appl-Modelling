package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;
import jakarta.validation.Valid;

import java.io.File;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // 1. Use a static logger for better logging practices
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderRepository repo;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    // 2. Removed unused 'OrderServicesApplication' dependency from the constructor
    public OrderController(OrderRepository repo, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.repo = repo;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@Valid @RequestBody Order order) {
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderAmt(order.getQuantity() * 100.0);
        Order saved = repo.save(order);

        try {
            File file = new File("order-" + saved.getId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, saved);
            // 3. Replaced e.printStackTrace() with a proper logging call
            logger.info("Saved order {} to file.", saved.getId());
        } catch (Exception e) {
            logger.error("Error writing order {} to file.", saved.getId(), e);
        }

        String marketResponse;
        String marketUrl = "http://market-service/market/process";
        try {
            // 4. Added robust error handling for RestTemplate calls
            marketResponse = restTemplate.postForObject(marketUrl, saved, String.class);
        } catch (ResourceAccessException e) {
            // This exception often indicates a 'no instance available' error
            logger.error("Failed to connect to market-service at {}: {}", marketUrl, e.getMessage());
            return new ResponseEntity<>("Order placed, but MarketService is unavailable.", HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            logger.error("An unexpected error occurred while calling market-service.", e);
            return new ResponseEntity<>("Order placed, but an unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("Order placed. Market says: " + marketResponse);
    }
}