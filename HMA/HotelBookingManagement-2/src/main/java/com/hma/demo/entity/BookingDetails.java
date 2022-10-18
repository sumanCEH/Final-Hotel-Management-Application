package com.hma.demo.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.catalina.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

 
@Entity
public class BookingDetails{

 @Id	
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int booking_id;
 private int room_id;
  
 @JsonFormat(pattern = "yyyy/MM/dd")
 private Date booked_from;
 
 @JsonFormat(pattern = "yyyy/MM/dd")
 private Date booked_to;
 private int no_of_adults;
 private int no_of_children;
 private double amount; 
 
 @OneToOne(targetEntity = Customer.class)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JoinColumn(name = "user_id",referencedColumnName = "user_id")
 private Customer user;
 
 @OneToOne(targetEntity = Hotel.class)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")
 private Hotel hotel;
 

public BookingDetails() {
	super();
	// TODO Auto-generated constructor stub
}

public BookingDetails(int booking_id, int room_id, Date booked_from, Date booked_to, int no_of_adults,
		int no_of_children, double amount, Customer user, Hotel hotel) {
	super();
	this.booking_id = booking_id;
	this.room_id = room_id;
	this.booked_from = booked_from;
	this.booked_to = booked_to;
	this.no_of_adults = no_of_adults;
	this.no_of_children = no_of_children;
	this.amount = amount;
	this.user = user;
	this.hotel = hotel;
}

public int getRoom_id() {
	return room_id;
}

public void setRoom_id(int room_id) {
	this.room_id = room_id;
}

public int getBooking_id() {
	return booking_id;
}

public void setBooking_id(int booking_id) {
	this.booking_id = booking_id;
}

public Date getBooked_from() {
	return booked_from;
}

public void setBooked_from(Date booked_from) {
	this.booked_from = booked_from;
}

public Date getBooked_to() {
	return booked_to;
}

public void setBooked_to(Date booked_to) {
	this.booked_to = booked_to;
}

public int getNo_of_adults() {
	return no_of_adults;
}

public void setNo_of_adults(int no_of_adults) {
	this.no_of_adults = no_of_adults;
}

public int getNo_of_children() {
	return no_of_children;
}

public void setNo_of_children(int no_of_children) {
	this.no_of_children = no_of_children;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public Customer getUser() {
	return user;
}

public void setUser(Customer user) {
	this.user = user;
}

public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}

}