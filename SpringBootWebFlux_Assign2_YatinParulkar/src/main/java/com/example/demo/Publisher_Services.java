package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Publisher_Services {

    @Autowired
    private PublisherRepository repo;

    // Add a new publisher
    public Mono<Publisher> addPublisher(Publisher publisher) {
        return repo.save(publisher);
    }

    // Get all publishers
    public Flux<Publisher> getAllPublishers() {
        return repo.findAll();
    }

    // Get publisher by ID
    public Mono<Publisher> getPublisherById(String id) {
        return repo.findById(id);
    }

    // Delete publisher by ID
    public Mono<Void> deletePublisher(String id) {
        return repo.deleteById(id);
    }
}