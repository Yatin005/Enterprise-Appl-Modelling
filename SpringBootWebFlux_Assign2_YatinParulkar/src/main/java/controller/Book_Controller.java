package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Book_Services;

@RestController
@RequestMapping("/api/books")
public class Book_Controller {
    @Autowired private Book_Services bookService;

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getBookById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@PathVariable long bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBook(@PathVariable long bookId) {
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/publisher/{publisherId}")
    public Flux<Book> getBooksByPublisher(@PathVariable long publisherId) {
        return bookService.getBooksByPublisher(publisherId);
    }

    

    @GetMapping("/borrowed-by/{membId}")
    public Flux<Book> getBooksBorrowedByMember(@PathVariable long membId) {
        return bookService.getBooksBorrowedByMember(membId);
    }
}