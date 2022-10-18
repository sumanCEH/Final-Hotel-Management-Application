package com.hma.demo.entity;


import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.OneToOne;
  

@Entity
public class Transaction {
    @Id
	private int transaction_id;
	private double amount;
	
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transaction_id, double amount) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
	}
		
}
