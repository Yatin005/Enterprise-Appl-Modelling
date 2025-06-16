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
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBookById(@PathVariable long id) {
		return bookRepository.findById(id);
	}
	
	@PostMapping("/book")
    public Book addBook(@Validated @RequestBody Book book) {
        return bookRepository.save(book);
    }
}