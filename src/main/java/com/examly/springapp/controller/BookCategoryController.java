package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;

@RestController
@RequestMapping("/api")
public class BookCategoryController {
BookCategoryService bcs;

public BookCategoryController(BookCategoryService bcs) {
  this.bcs = bcs;
}
@PostMapping("/book-categories")
public ResponseEntity<BookCategory> createBookCategory(@RequestBody BookCategory bookcategory){
  try{
  BookCategory bc=bcs.createBookCategory(bookcategory);
  return new ResponseEntity<>(bc,HttpStatus.CREATED);
  }
  catch(Exception e){
   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
 
}
@GetMapping("/book-categories")
public ResponseEntity<List<BookCategory>>getAllBookCategory(){

  List<BookCategory>bc=bcs.getAllBookCategory();
  if(!bc.isEmpty()){
  return new ResponseEntity<>(bc,HttpStatus.OK);

}

  return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
@GetMapping("/book-categories/{id}")
public ResponseEntity<?> getBookCategoryById(@PathVariable long id){
  
    Optional<BookCategory>bc=bcs.getBookCategoryById(id);
    if(bc.isPresent()){
    return new ResponseEntity<>(bc.get(),HttpStatus.OK);
    }
    return new ResponseEntity<>("Book category not found",HttpStatus.NOT_FOUND);
  
}

@PutMapping("/book-categories/{id}")
public ResponseEntity<BookCategory> updateBookCategory(@PathVariable long id,@RequestBody BookCategory bookCategory){
       BookCategory bc=bcs.updateBookCategory(id,bookCategory);
       return new ResponseEntity<>(bc,HttpStatus.OK);

}

@GetMapping("/book-categories/page/{pageNo}/{pageSize}")
public Page<BookCategory>paginated(@PathVariable int pageNo,@PathVariable int pageSize){
 return bcs.paginated(pageNo,pageSize);
 
}

@DeleteMapping("/book-categories/{id}")
public ResponseEntity<Void>deleteBookCategory(@PathVariable long id){
    if(bcs.deleteBookCategory(id))return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
