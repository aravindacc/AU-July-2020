package com.hybernate.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity(name="bankAudit")
@Cacheable
public class Audit {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@ManyToOne
	private Account sender;
	@NotNull
	@ManyToOne
	private Account reciever;
	@NotNull
	private double amount;

	@NotNull
	private String status;
	
	
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getReciever() {
		return reciever;
	}
	public void setReciever(Account reciever) {
		this.reciever = reciever;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString()
	{
		return this.getId()+" "+
				this.getAmount()+" "+
				this.getStatus()+" "+
				this.getReciever()+" "+
				this.getSender();
	}
	
}
