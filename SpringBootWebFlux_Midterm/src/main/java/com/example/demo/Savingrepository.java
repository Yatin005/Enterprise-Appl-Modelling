package com.example.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Savingrepository extends ReactiveMongoRepository<Savings, String> {
}
