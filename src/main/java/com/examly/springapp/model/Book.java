package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookId;
    String title;
    String author;
    Boolean available;
    @ManyToOne
    BookCategory bookCategory;
    public Book() {
    }
    public Book(String title, String author, Boolean available, BookCategory bookCategory) {
        this.title = title;
        this.author = author;
        this.available = available;
        this.bookCategory = bookCategory;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public BookCategory getBookCategory() {
        return bookCategory;
    }
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
    
}
