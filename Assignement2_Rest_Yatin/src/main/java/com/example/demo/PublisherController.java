package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PublisherController {
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@GetMapping("/publisher")
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }
	
	@GetMapping("/publisher/{id}")
	public Optional<Publisher> getPublisherById(@PathVariable long id) {
		return publisherRepository.findById(id);
	}
	
	@PostMapping("/publisher")
    public Publisher addPublisher(@Validated @RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}