package com.examly.springapp.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Borrow {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long borrowId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    Book book;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    Member member;
    Date borrowDate;
    Date returnDate;
    public Borrow() {
    }
    public Borrow(Book book, Member member, Date borrowDate, Date returnDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    public Long getBorrowId() {
        return borrowId;
    }
    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
}
