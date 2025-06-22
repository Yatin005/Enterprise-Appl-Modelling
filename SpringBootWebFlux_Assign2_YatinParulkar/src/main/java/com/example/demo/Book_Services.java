package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Book_Services {

    @Autowired
    private BookRepository repo;

    // Add a new book
    public Mono<Book> addBook(Book book) {
        return repo.save(book);
    }

    // Get all books
    public Flux<Book> getAllBooks() {
        return repo.findAll();
    }

    // Get book by ID
    public Mono<Book> getBookById(String id) {
        return repo.findById(id);
    }

    // Delete book by ID
    public Mono<Void> deleteBook(String id) {
        return repo.deleteById(id);
    }

}