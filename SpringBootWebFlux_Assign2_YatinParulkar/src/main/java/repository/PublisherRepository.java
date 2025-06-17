package repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import model.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PublisherRepository extends ReactiveMongoRepository<Publisher, Long> {
	Flux<Publisher> findByName(String name);

	Mono<Publisher> findByPubId(long pubId);

	Flux<Publisher> findByAddressContaining(String address);

	Mono<Void> deleteByPubId(long pubId);

}
