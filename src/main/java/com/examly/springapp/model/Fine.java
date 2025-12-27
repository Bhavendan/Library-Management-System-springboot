package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Fine {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fineId;
    Double amount;
    @OneToOne
    @JoinColumn(name="borrow_id")
    Borrow borrow;
    public Fine() {
    }
    public Fine(Double amount, Borrow borrow) {
        this.amount = amount;
        this.borrow = borrow;
    }
    public Long getFineId() {
        return fineId;
    }
    public void setFineId(Long fineId) {
        this.fineId = fineId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Borrow getBorrow() {
        return borrow;
    }
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
    
}
