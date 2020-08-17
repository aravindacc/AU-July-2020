package com.au.hibernate.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity(name="account")
@Cacheable
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String type;
    @NotNull
    private Integer amount;
    @NotNull
    private Integer accountNumber;
    @ManyToOne
    @NotNull
    private User userid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public boolean withdraw(Integer amount)
    {
        if(this.amount >= amount && amount > 0)
        {
            this.amount -= amount;
            return true;
        }
        return false;
    }


    public boolean deposit(Integer amount)
    {
        if(amount > 0)
        {
            this.amount += amount;
            return true;
        }
        return false;
    }

    public String toString()
    {
        return this.getId()+"\t"+
                this.getAccountNumber()+"\t"+
                this.getAmount()+"\t"+
                this.getUserid().getId();

    }

}

