package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Transaction;
import com.hma.demo.service.TransactionService;



@RestController
@RequestMapping("/Transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) throws Exception{
		
		return new ResponseEntity<>(transactionService.addTransaction(transaction),HttpStatus.OK);
		
	}
	
	

}
