package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import com.examly.springapp.repository.BookRepo;

@Service
public class BookService {
   
    BookRepo br;
    @Autowired
    BookCategoryRepo cr;
    public BookService(BookRepo br) {
        this.br = br;
    }

    public Book addBook(Book book) {

    Long categoryId = book.getBookCategory().getCategoryId();

    BookCategory category = cr.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

    book.setBookCategory(category);

    Book savedBook = br.save(book);

   
    return br.findById(savedBook.getBookId()).orElseThrow();
}

    public List<Book>getAllBooks(){
        return br.findAll();
    }
    public Book getBookById(long id){
        return br.findById(id).orElse(null);
    }
    public Book updateBook(long id,Book b){
      Optional<Book>opt=br.findById(id);
      if(opt.isPresent()){
        Book book=opt.get();
        book.setAuthor(b.getAuthor());
        book.setAvailable(b.getAvailable());
        book.setBookCategory(b.getBookCategory());
        book.setTitle(b.getTitle());
        return br.save(book);
      }
      return null;
    }
    public List<Book> getBooksByCategory(String s){
        return br.findByBookCategory_CategoryName(s);
    }
    public List<Book>getByTitle(String title){
        return br.findByTitle(title);
    }
}
