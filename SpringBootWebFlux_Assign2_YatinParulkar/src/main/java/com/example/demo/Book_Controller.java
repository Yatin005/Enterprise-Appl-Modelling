package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class Book_Controller {

    @Autowired
    private Book_Services bookService;

    // BOOK
    @PostMapping("/book")
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/book")
    public Flux<Book> getBooks() {
        return bookService.getAllBooks();
    }
}