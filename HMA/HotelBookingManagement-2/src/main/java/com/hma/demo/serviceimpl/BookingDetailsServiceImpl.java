package com.hma.demo.serviceimpl;

import java.util.List;    
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.entity.Customer;
import com.hma.demo.entity.Hotel;
import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.DetailsNotFoundException;
import com.hma.demo.repository.BookingDetailsRepository;
import com.hma.demo.repository.HotelRepository;
import com.hma.demo.repository.RoomDetailsRepository;
import com.hma.demo.repository.UserRepository;
import com.hma.demo.service.BookingDetailsService;


@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService{

	@Autowired
	BookingDetailsRepository bookingrepo;
	
	@Autowired
	RoomDetailsRepository roomrepo;
		
	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) throws Exception {
		try {		
		bookingrepo.save(bookingdetails);
		return bookingdetails;
		}catch (Exception e) {
           throw new Exception("Details are mismatched");
		}
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails){
		if(bookingrepo.findById(bookingdetails.getBooking_id()).isPresent()) {
		    BookingDetails bookingDetails1 = bookingrepo.getById(bookingdetails.getBooking_id());
			bookingDetails1.setBooked_from(bookingdetails.getBooked_from());
			bookingDetails1.setBooked_to(bookingdetails.getBooked_to());
			bookingDetails1.setRoom_id(bookingdetails.getRoom_id());
			bookingDetails1.setNo_of_adults(bookingdetails.getNo_of_adults());
			bookingDetails1.setNo_of_children(bookingdetails.getNo_of_children());
			bookingDetails1.setUser(bookingdetails.getUser());
			bookingDetails1.setHotel(bookingdetails.getHotel());
			bookingrepo.save(bookingDetails1);
			return bookingDetails1; 
		   
		}
		else
			throw new DetailsNotFoundException("Booking details are not found");
	}

	@Override
	public String removeBookingDetails(int booking_id) {
		if(bookingrepo.findById(booking_id).isPresent()) {
		   BookingDetails bd= bookingrepo.getById(booking_id);
		   bookingrepo.deleteById(booking_id);
		   return "Booking details are deleted";
	   }else
		   throw new DetailsNotFoundException("Booking details are not found");
	}

	@Override
	public List<BookingDetails> showAllBookingDetails(){
		List<BookingDetails> list=bookingrepo.findAll();
		if(bookingrepo.findAll().isEmpty()) 
			throw new DetailsNotFoundException("Booking details are not found");
	    return list;
	}

	@Override
	public BookingDetails showBookingDetails(int booking_id){
		if(bookingrepo.findById(booking_id).isPresent()) {
		    BookingDetails bd= bookingrepo.getById(booking_id);
		    return bd;
		}
		else
			throw new DetailsNotFoundException("Booking details are not found");
	}

}