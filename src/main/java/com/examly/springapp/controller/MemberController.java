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

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    MemberService ms;

    public MemberController(MemberService ms) {
        this.ms = ms;
    }
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member m){
        return new ResponseEntity<>(ms.addMember(m),HttpStatus.CREATED);
    }
    @GetMapping
    public List<Member>getAllMembers(){
        return ms.getAllMembers();
    }
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable long id){
        return ms.getMemberById(id);
    }
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable long id,@RequestBody Member m){
        return ms.updateMember(id,m);
    }
    @GetMapping("/phone/{phoneNo}")
    public ResponseEntity<?>getMemberByPhone(@PathVariable String phoneNo){
       List<Member>m=ms.getMemberByPhone(phoneNo);
        if(m.isEmpty())return new ResponseEntity<>("No member found with phone: "+phoneNo,HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Member>>getByEmail(@PathVariable String email){
        return new ResponseEntity<>(ms.getByEmail(email),HttpStatus.OK);
    }
    
}
