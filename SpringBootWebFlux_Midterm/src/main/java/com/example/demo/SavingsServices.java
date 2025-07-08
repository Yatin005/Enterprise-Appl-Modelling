package com.example.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SavingsServices {
	@Autowired
    private Savingrepository repository;

    public Mono<Savings> create(Savings account) {
        return repository.save(account);
    }

    public Flux<Savings> getAll() {
        return repository.findAll();
    }
}
