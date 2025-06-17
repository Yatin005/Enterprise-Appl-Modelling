package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import model.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Publisher_Services;

@RestController
@RequestMapping("/api/publishers")
public class Publisher_Controller {
    @Autowired private Publisher_Services publisherService;

    @GetMapping
    public Flux<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{pubId}")
    public Mono<Publisher> getPublisherById(@PathVariable long pubId) {
        return publisherService.getPublisherById(pubId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @PutMapping("/{pubId}")
    public Mono<Publisher> updatePublisher(@PathVariable long pubId, @RequestBody Publisher publisher) {
        return publisherService.updatePublisher(pubId, publisher);
    }

    @DeleteMapping("/{pubId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePublisher(@PathVariable long pubId) {
        return publisherService.deletePublisher(pubId);
    }

    @GetMapping("/name/{name}")
    public Flux<Publisher> getPublishersByName(@PathVariable String name) {
        return publisherService.getPublishersByName(name);
    }

    @GetMapping("/search/address")
    public Flux<Publisher> searchPublishersByAddress(@RequestParam String address) {
        return publisherService.searchPublishersByAddress(address);
    }
}