package com.examly.springapp.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    BookService bs;
    public BookController(BookService bs){
        this.bs=bs;
    }
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book b){
                return new ResponseEntity<>(bs.addBook(b),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Book>>getAllBooks(){
       List<Book>list= bs.getAllBooks();
       if(list.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book>getBookById(@PathVariable long id){
        Book book= bs.getBookById(id);
        if(book==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book>updateBook(@PathVariable long id,@RequestBody Book b){
        return new ResponseEntity<>( bs.updateBook(id,b),HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<?>getBooksByCategory(@PathVariable String category){
         List<Book>list=bs.getBooksByCategory(category);
      return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<?>getByTitle(@PathVariable String title){
        List<Book>list=bs.getByTitle(title);
        if(list.isEmpty())return new ResponseEntity<>("No book found with title: "+title,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bs.getByTitle(title),HttpStatus.OK);
    }
   
}
