package com.hybernate.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity(name="bankAccount")
@Cacheable
public class Account {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private long accountNumber;
	@NotNull
	private double amount;
	@NotNull
	@ManyToOne
	private User userid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	
	public boolean withdraw(double amount)
	{
		if(this.amount >= amount && amount > 0)
		{
			this.amount -= amount;
			return true;
		}
		return false;
	}
	
	
	public boolean deposit(double amount)
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
