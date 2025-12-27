package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.service.BorrowService;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService service;

    @PostMapping
    public ResponseEntity<Borrow> addBorrow(@RequestBody Borrow borrow) {
        return new ResponseEntity<>(service.save(borrow), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        return ResponseEntity.ok(service.findAll());
    }

   @GetMapping("/{id}")
   public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
    Borrow borrow = service.findById(id);
    if (borrow == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(borrow, HttpStatus.OK);
}

}
