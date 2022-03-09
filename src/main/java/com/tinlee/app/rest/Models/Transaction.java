package com.tinlee.app.rest.Models;

import javax.persistence.*;

@Entity
public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;
    @Column
    private Double amount;
    @OneToOne
    @JoinColumn(name = "user_id")

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
