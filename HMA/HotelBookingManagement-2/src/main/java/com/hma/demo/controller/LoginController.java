package com.hma.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Admin;
import com.hma.demo.service.AdminService;





@RestController
@RequestMapping("/Admin")
public class LoginController {

	@Autowired
	AdminService adminService;

    @GetMapping("/hello")
    public String message() {
    	return "hello world";
    }
	@PostMapping("/register")
	public ResponseEntity<?>register(@RequestBody Admin admin) {

		return new ResponseEntity<>(adminService.register(admin),HttpStatus.OK);

	}
	
	@PutMapping("/signin")
	public ResponseEntity<?>signIn(@RequestBody Admin admin) {
	
		return new ResponseEntity<>(adminService.signIn(admin.getAdmin_name(), admin.getPassword()),HttpStatus.OK);
	}

}