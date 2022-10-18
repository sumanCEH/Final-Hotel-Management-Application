package com.hma.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Payment {

@Id
private int payment_id;

@ManyToOne(targetEntity = BookingDetails.class,cascade = CascadeType.ALL)
@JoinColumn(name = "booking_id",referencedColumnName = "booking_id")
private BookingDetails bookingdetails;

@OneToOne(targetEntity = Transaction.class,cascade = CascadeType.ALL)
@JoinColumn(name = "transaction_id",referencedColumnName = "transaction_id")
private Transaction transaction;

public int getPayment_id() {
	return payment_id;
}

public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}

public BookingDetails getBookingdetails() {
	return bookingdetails;
}

public void setBookingdetails(BookingDetails bookingdetails) {
	this.bookingdetails = bookingdetails;
}

public Transaction getTransaction() {
	return transaction;
}

public void setTransaction(Transaction transaction) {
	this.transaction = transaction;
}

public Payment() {
	super();
	// TODO Auto-generated constructor stub
}

public Payment(int payment_id, BookingDetails bookingdetails, Transaction transaction) {
	super();
	this.payment_id = payment_id;
	this.bookingdetails = bookingdetails;
	this.transaction = transaction;
}

}
