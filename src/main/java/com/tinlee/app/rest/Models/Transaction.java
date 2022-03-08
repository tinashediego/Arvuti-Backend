package com.tinlee.app.rest.Models;

import javax.persistence.*;

@Entity
public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double amount;


    @Column

    @ManyToOne(fetch = FetchType.EAGER, optional = false)



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
