package com.va.week10;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeeServiceController {

    @Autowired
    private FeeService feeService;

    @PostMapping
    public Fee createFee(@RequestBody Fee fee) {
        return feeService.createFee(fee);
    }

    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAllFees();
    }
}