package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.model.Fine;
import com.examly.springapp.repository.BorrowRepo;
import com.examly.springapp.repository.FineRepo;

@Service
public class FineService {

    @Autowired
    private FineRepo repo;
    @Autowired
    private BorrowRepo br;

    public Fine save(Fine fine) {
        Borrow b=br.findById(fine.getBorrow().getBorrowId()).orElse(null);
        fine.setBorrow(b);
        return repo.save(fine);
    }

    public List<Fine> findAll() {
        return repo.findAll();
    }

    public Fine findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
