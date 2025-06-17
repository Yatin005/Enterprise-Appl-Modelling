package repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import model.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveMongoRepository<Member, Long> {
	Flux<Member> findByName(String name);

	Flux<Member> findByMembType(String membType);

	Mono<Member> findByMembId(long membId);

	Flux<Member> findByExpiryDateAfter(Date date);

	Flux<Member> findByExpiryDateBefore(Date date);

	Mono<Void> deleteByMembId(long membId);
}
