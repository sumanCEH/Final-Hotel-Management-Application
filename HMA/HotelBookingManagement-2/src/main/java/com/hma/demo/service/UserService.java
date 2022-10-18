package com.hma.demo.service;

import java.util.List;  

import org.springframework.stereotype.Service;

import com.hma.demo.entity.Customer;




@Service
public interface UserService {

	public String addUser(Customer user );
	public String removeUser(Integer user_id);
	public List<Customer> ShowAllUser();
	public Customer ShowUser(Integer user_id);
	public Customer updateUser(Customer user);


}
