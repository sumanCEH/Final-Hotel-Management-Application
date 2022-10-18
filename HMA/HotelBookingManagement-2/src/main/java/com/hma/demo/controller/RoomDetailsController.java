package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.RoomDetails;
import com.hma.demo.serviceimpl.RoomDetailsServiceImpl;



@RestController
@RequestMapping("/Room")
public class RoomDetailsController {
	
	@Autowired 
	RoomDetailsServiceImpl rservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addroom(@RequestBody RoomDetails room) throws Exception{
		return new ResponseEntity<>(rservice.addRoomDetails(room),HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateroom(@RequestBody RoomDetails room){
		return new ResponseEntity<>(rservice.updateRoomDetails(room),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteroom(@PathVariable Integer id) {
		return new ResponseEntity<>(rservice.removeRoomDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		return new ResponseEntity<>(rservice.showAllRoomDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getroom(@PathVariable Integer id) {
		return new ResponseEntity<>(rservice.showRoomDetails(id),HttpStatus.OK);
	}

}
