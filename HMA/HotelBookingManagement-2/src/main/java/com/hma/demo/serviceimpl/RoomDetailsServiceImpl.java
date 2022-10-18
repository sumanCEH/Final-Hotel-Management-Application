
package com.hma.demo.serviceimpl;

 
import java.text.SimpleDateFormat; 
import java.time.LocalDate;

import java.util.Iterator;
import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hma.demo.entity.BookingDetails;
import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.DetailsNotFoundException;
import com.hma.demo.repository.BookingDetailsRepository;
import com.hma.demo.repository.RoomDetailsRepository;
import com.hma.demo.service.RoomDetailsService;



@Service
public class RoomDetailsServiceImpl implements RoomDetailsService{
	@Autowired
	RoomDetailsRepository rrepo;

	@Autowired
	BookingDetailsRepository brepo;
		
	public String addRoomDetails(RoomDetails room) throws Exception{
		try{rrepo.save(room);
		return "Room Added successfully";
		}catch (Exception e) {
			throw new Exception("Details are mismatched");
		}
		
	}
	public String updateRoomDetails(RoomDetails room){
	  if(rrepo.findById(room.getRoom_id()).isPresent()) {
         RoomDetails roomdetails = rrepo.getById(room.getRoom_id());
         roomdetails.setRoom_no(room.getRoom_no());
         roomdetails.setIs_available(room.getIs_available());
         roomdetails.setRate_per_day(room.getRate_per_day());
         roomdetails.setHotel(room.getHotel());
         rrepo.save(roomdetails);
		return "Room Details updated";
		}
	  else
		  throw new DetailsNotFoundException("Room details are not found");
	}
	public String removeRoomDetails(Integer rid){
		if(rrepo.findById(rid).isPresent()) {
			RoomDetails r= rrepo.getById(rid);
			rrepo.deleteById(rid);
			return "Room details are deleted";
		}
		else
			throw new DetailsNotFoundException("Room details are not found"); 
	}
	public List<RoomDetails> showAllRoomDetails(){
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM"); 
	   LocalDate today = LocalDate.now();
	   	   
	   List<RoomDetails> list =rrepo.findAll();	   
	   if(list.isEmpty())
		   throw new DetailsNotFoundException("Room details are not found");
	   
	   List<BookingDetails> list1 =brepo.findAll();
	   Iterator<BookingDetails> it=list1.iterator();
	   for(BookingDetails bd : list1) {
		   String[] s =it.next().getBooked_to().toString().split(" ");
		   LocalDate bookedto = LocalDate.parse(s[0]);
		   if(today.compareTo(bookedto)>0) {
		       RoomDetails r= rrepo.getById(bd.getRoom_id());
			   r.setIs_available(true);
		       rrepo.save(r); }
	   }
	   return rrepo.findAll();
	
	}
	
	public  RoomDetails showRoomDetails(Integer id){
		if(rrepo.findById(id).isPresent()) {
			RoomDetails r= rrepo.getById(id);
			return r;
	   }
		else
			 throw new DetailsNotFoundException("Room details are not found");
}
}
