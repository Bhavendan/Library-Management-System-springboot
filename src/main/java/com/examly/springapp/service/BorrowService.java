package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;
import com.examly.springapp.model.Borrow;
import com.examly.springapp.model.Member;
import com.examly.springapp.repository.BookRepo;
import com.examly.springapp.repository.BorrowRepo;
import com.examly.springapp.repository.MemberRepo;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepo repo;
    @Autowired
    private BookRepo bookrepo;
    @Autowired 
    private MemberRepo memberrepo;

    public Borrow save(Borrow borrow) {
        Book b=bookrepo.findById(borrow.getBook().getBookId()).orElse(null);
       Member m=memberrepo.findById(borrow.getMember().getMemberId()).orElse(null);
       borrow.setBook(b);
       borrow.setMember(m);
        return repo.save(borrow);
        
    }

    public List<Borrow> findAll() {
        return repo.findAll();
    }

    public Borrow findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
