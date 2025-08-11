package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fees")
public class FeeController {

    private final FeeRepository repo;
    private final ObjectMapper objectMapper;

    public FeeController(FeeRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }
    
    @GetMapping
    public List<Fee> getAllFees() {
        return repo.findAll();
    }

    @PostMapping("/process")
    public String processFee(@RequestBody OrderDTO order) {
        Fee fee = new Fee();
        fee.setFeeId(UUID.randomUUID().toString());
        fee.setFeeType(order.getOrderType().equals("BUY")); 
        fee.setFeeAmt(order.getOrderAmt() * 0.005);
        fee.setFeeSalesTax(fee.getFeeAmt() * 0.13);
        fee.setFeeDateTime(LocalDateTime.now());
        repo.save(fee);

        try {
            File file = new File("fee-" + fee.getId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, fee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "Fee processed.";
    }
}