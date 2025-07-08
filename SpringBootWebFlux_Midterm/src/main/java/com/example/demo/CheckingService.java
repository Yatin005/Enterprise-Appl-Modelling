package com.example.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CheckingService {
	 @Autowired
	 private CheckingRepository repository ;

    public Mono<CheckingAccount> create(CheckingAccount account) {
        return repository.save(account);
    }

    public Flux<CheckingAccount> getAll() {
        return repository.findAll();
    }
}
