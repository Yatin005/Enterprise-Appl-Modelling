package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.BookRepository;

@Service
public class Book_Services {
    @Autowired private BookRepository bookRepository;

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> getBookById(long bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public Mono<Book> createBook(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Book> updateBook(long bookId, Book book) {
        return bookRepository.findByBookId(bookId)
                .flatMap(existingBook -> {
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setTitle(book.getTitle());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setAvailable(book.isAvailable());
                    return bookRepository.save(existingBook);
                });
    }

    public Mono<Void> deleteBook(long bookId) {
        return bookRepository.deleteByBookId(bookId);
    }

    public Flux<Book> getBooksByPublisher(long publisherId) {
        return bookRepository.findByPublisherId(publisherId);
    }

   

    public Flux<Book> getBooksBorrowedByMember(long membId) {
        return bookRepository.findByBorrowedBy(membId);
    }
}