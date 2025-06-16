package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    private long bookId; 
    
    private String author;
    
    private String title; 
    
    private Double price; 
    
    private boolean available;  
    
    public Book() {};

    public Book(long bookId, String author, String title, Double price, boolean available) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.price = price;
        this.available = available;
    }

    // Getters and setters 
    public long getBookId() {
        return bookId;
    }
    public void setBookId(long id) {
        this.bookId = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String value) {
        this.author = value;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String value) {
        this.title = value;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean value) {
        this.available = value;
    }
}