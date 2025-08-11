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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderRepository repo;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

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

           
        } catch (Exception e) {
           
        }

        String marketResponse;
        String marketUrl = "http://market-service/market/process";
        String feeUrl = "http://fee-service/fees/process";

        try {
            // First, call the MarketService
            marketResponse = restTemplate.postForObject(marketUrl, saved, String.class);
                 
            restTemplate.postForObject(feeUrl, saved, String.class);
           

        } catch (ResourceAccessException e) {
            
            return new ResponseEntity<>("Order placed, but a required service is unavailable.", HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
           
            return new ResponseEntity<>("Order placed, but an unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("Order placed. Market says: " + marketResponse);
    }
}