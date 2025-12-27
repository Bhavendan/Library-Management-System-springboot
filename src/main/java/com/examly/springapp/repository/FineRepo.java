package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Fine;

@Repository
public interface FineRepo extends JpaRepository<Fine,Long>{
    
}
