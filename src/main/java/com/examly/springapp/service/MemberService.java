 package com.examly.springapp.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;

@Service
 public class MemberService {
 MemberRepo mr;

 public MemberService(MemberRepo mr) {
    this.mr = mr;
 }
 public Member addMember(Member m){
    return mr.save(m);
 }
 public List<Member>getAllMembers (){
    return mr.findAll();
 }
 public Member getMemberById(long id){
    return mr.findById(id).orElse(null);
 }
 public Member updateMember(long id,Member m){
    Optional<Member>opt=mr.findById(id);
    if(opt.isPresent()){
        Member member=opt.get();
        member.setEmail(m.getEmail());
        member.setName(m.getName());
        member.setPhone(m.getPhone());
        return mr.save(member);
    }
    return null;
 }
 public List<Member>getMemberByPhone(String s){
    return mr.findByPhone(s);
 }
 public List<Member>getByEmail(String email){
   return mr.findByEmail(email);
 }
    
 }