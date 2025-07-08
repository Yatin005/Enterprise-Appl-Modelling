package com.example.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checking")
@RequiredArgsConstructor
public class CheckingController {
	@Autowired
    private CheckingService service;

	@PostMapping
	public Mono<CheckingAccount> create(@RequestBody CheckingAccount account) {
	    System.out.println("Received accountHolder: " + account.getAccountHolder());
	    System.out.println("Received balance: " + account.getBalance());
	    
	    return service.create(account);
	}

    @GetMapping
    public Flux<CheckingAccount> getAll() {
        return service.getAll();
    }
}
