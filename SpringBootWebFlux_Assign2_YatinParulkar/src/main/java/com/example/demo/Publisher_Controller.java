package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/publisher")
public class Publisher_Controller {

    @Autowired
    private Publisher_Services publisherService;

    @PostMapping("/publisher")
    public Mono<Publisher> addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }

    @GetMapping("/publisher")
    public Flux<Publisher> getPublishers() {
        return publisherService.getAllPublishers();
    }
}