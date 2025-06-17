package repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book, Long> {
	Flux<Book> findByAuthor(String author);

	Flux<Book> findByTitleContaining(String title);

	Flux<Book> findByAvailable(boolean available);

	Mono<Book> findByBookId(long bookId);

	Flux<Book> findByPublisherId(Long publisherId);

	Flux<Book> findByBorrowedBy(Long membId);

	Mono<Void> deleteByBookId(long bookId);

}
