package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.PublisherRepository;

@Service
public class Publisher_Services {
    @Autowired private PublisherRepository publisherRepository;

    public Flux<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Mono<Publisher> getPublisherById(long pubId) {
        return publisherRepository.findByPubId(pubId);
    }

    public Mono<Publisher> createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Mono<Publisher> updatePublisher(long pubId, Publisher publisher) {
        return publisherRepository.findByPubId(pubId)
                .flatMap(existingPublisher -> {
                    existingPublisher.setName(publisher.getName());
                    existingPublisher.setAddress(publisher.getAddress());
                    return publisherRepository.save(existingPublisher);
                });
    }

    public Mono<Void> deletePublisher(long pubId) {
        return publisherRepository.deleteByPubId(pubId);
    }

    public Flux<Publisher> getPublishersByName(String name) {
        return publisherRepository.findByName(name);
    }

    public Flux<Publisher> searchPublishersByAddress(String address) {
        return publisherRepository.findByAddressContaining(address);
    }
}