package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Fine;
import com.examly.springapp.service.FineService;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    @Autowired
    private FineService service;

    @PostMapping
    public ResponseEntity<Fine> addFine(@RequestBody Fine fine) {
        return new ResponseEntity<>(service.save(fine), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fine>> getAllFines() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
  public ResponseEntity<Fine> getFineById(@PathVariable Long id) {
    Fine fine = service.findById(id);
    if (fine == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(fine, HttpStatus.OK);
}

}
