package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketRepository repo;
    private final ObjectMapper objectMapper;

    // The RestTemplate dependency is removed as it is no longer used
    public MarketController(MarketRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/process")
    public String processOrder(@RequestBody OrderDTO order) {
        Marketorder mo = new Marketorder();
        mo.setOrderId(order.getId());
        mo.setExecutedPrice(74.95);
        mo.setStatus("CONFIRMED");
        repo.save(mo);

        try {
            File file = new File("market-" + mo.getOrderId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, mo);
        } catch (Exception e) {
            e.printStackTrace();
        }

      
        return "Order executed.";
    }
}