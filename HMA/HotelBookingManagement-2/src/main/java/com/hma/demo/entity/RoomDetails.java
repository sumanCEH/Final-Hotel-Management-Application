package com.hma.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class RoomDetails {
	
	@Id
	private Integer room_id;
	private String room_no;
	private Double rate_per_day;
	private Boolean is_available;
	
	@ManyToOne(targetEntity = Hotel.class)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")
	private Hotel hotel;

	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDetails(Integer room_id, String room_no, Double rate_per_day, Boolean is_available, Hotel hotel) {
		super();
		this.room_id = room_id;
		this.room_no = room_no;
		this.rate_per_day = rate_per_day;
		this.is_available = is_available;
		this.hotel = hotel;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public Double getRate_per_day() {
		return rate_per_day;
	}

	public void setRate_per_day(Double rate_per_day) {
		this.rate_per_day = rate_per_day;
	}

	public Boolean getIs_available() {
		return is_available;
	}

	public void setIs_available(Boolean is_available) {
		this.is_available = is_available;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
