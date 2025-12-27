package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.examly.springapp.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    public List<Book>findByBookCategory_CategoryName(String name);
    public List<Book>findByTitle(String s);
}
