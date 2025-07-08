package com.example.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {
	 @Autowired
    private SavingsServices service;

    @PostMapping
    public Mono<Savings> create(@RequestBody Savings account) {
        return service.create(account);
    }

    @GetMapping
    public Flux<Savings> getAll() {
        return service.getAll();
    }
}
