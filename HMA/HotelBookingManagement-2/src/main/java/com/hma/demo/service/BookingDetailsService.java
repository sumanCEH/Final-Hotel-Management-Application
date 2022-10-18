package com.hma.demo.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.exception.DetailsNotFoundException;



@Service
public interface BookingDetailsService {

	public BookingDetails addBookingDetails(BookingDetails bookingdetails) throws Exception;
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails);
	public String removeBookingDetails(int booking_id);
	public List<BookingDetails> showAllBookingDetails();
	public BookingDetails showBookingDetails(int booking_id);
}