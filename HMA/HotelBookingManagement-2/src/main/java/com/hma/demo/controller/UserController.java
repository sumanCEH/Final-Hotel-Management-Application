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

import com.hma.demo.entity.Customer;
import com.hma.demo.service.UserService;



@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> listUser(){		
		return new ResponseEntity<>(userService.ShowAllUser(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> adduser(@RequestBody Customer user) throws Exception{		
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateuser(@RequestBody Customer user) {		
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{user_id}")
	public  ResponseEntity<?> showUser(@PathVariable("user_id") Integer user_id) {
		return new ResponseEntity<>(userService.ShowUser(user_id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletebyid/{user_id}")
	public ResponseEntity<?> remove(@PathVariable("user_id") Integer user_id ){
		return new ResponseEntity<>(userService.removeUser(user_id), HttpStatus.OK);
	}
	
}
