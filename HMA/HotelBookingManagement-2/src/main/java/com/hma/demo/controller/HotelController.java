package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Hotel;
import com.hma.demo.service.hotelservice;



@RestController
@RequestMapping("/Hotel")
public class HotelController {
	@Autowired
	private hotelservice hs;
	
	@GetMapping("/getall")
	public ResponseEntity<?> getHotels(){
		return new ResponseEntity<>(hs.getHotels(),HttpStatus.OK);
	}
	 
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> gethotel(@PathVariable int id)
	{
		return new ResponseEntity<>(hs.gethotel(id),HttpStatus.OK);
	}

	
	@PostMapping("/addhotel")
	public ResponseEntity<?> addhotel(@RequestBody Hotel htl) throws Exception
	{
		return new ResponseEntity<>(hs.addhotel(htl),HttpStatus.OK);
	}
	
	
	@PutMapping("/updatehotel")
	public ResponseEntity<?> updatehotel(@RequestBody Hotel ht) {
		return new ResponseEntity<>(hs.updatehotel(ht),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deletehotel(@PathVariable int id){
	    return new ResponseEntity<>(hs.deletehotel(id),HttpStatus.OK);
	}
}
