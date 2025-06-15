package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}