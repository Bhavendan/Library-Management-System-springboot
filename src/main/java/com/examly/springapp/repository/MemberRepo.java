package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {
    
    public List<Member>findByPhone(String s);
    public List<Member>findByEmail(String s);
}
