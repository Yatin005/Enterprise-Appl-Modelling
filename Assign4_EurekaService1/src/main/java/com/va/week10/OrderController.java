package com.va.week10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.io.File;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final  Assign4EurekaServerApplication assign4EurekaServerApplication;

    private final OrderRepository repo;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public OrderController(OrderRepository repo, RestTemplate restTemplate, ObjectMapper objectMapper,  Assign4EurekaServerApplication  assign4EurekaServerApplication) {
        this.repo = repo;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.assign4EurekaServerApplication =  assign4EurekaServerApplication;
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@Valid @RequestBody Order order) {
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderAmt(order.getQuantity() * 100.0);
        Order saved = repo.save(order);

        try {
            File file = new File("order-" + saved.getId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, saved);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String marketUrl = "http://market-service/market/process";
        String marketResponse = restTemplate.postForObject(marketUrl, saved, String.class);

        return ResponseEntity.ok("Order placed. Market says: " + marketResponse);
    }
}