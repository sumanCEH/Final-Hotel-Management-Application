package com.hma.demo.serviceimpl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Customer;
import com.hma.demo.exception.DetailsNotFoundException;
import com.hma.demo.repository.UserRepository;
import com.hma.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepo;

	@Override
	public String addUser(Customer user) {
		userrepo.save(user);
		return "User details are added";
		
	}

	@Override
	public Customer updateUser(Customer u) {
		if(userrepo.findById(u.getUser_id()).isPresent()) {
         Customer user = userrepo.getById(u.getUser_id());
         user.setAddress(u.getAddress());
         user.setEmail(u.getEmail());
         user.setMobile(u.getMobile());
         user.setPassword(u.getPassword());
         user.setRole(u.getRole());
         user.setUser_name(u.getUser_name());
         userrepo.save(user);
         return user;
		}else
			throw new DetailsNotFoundException("User details are not found");
		}

	@Override
	public String removeUser(Integer user_id){
		
		if(userrepo.findById(user_id).isPresent()) {
		   userrepo.deleteById(user_id);
		   return "User details are deleted";
		}else {
			throw new DetailsNotFoundException("User details are not found");	
        }
	}


	@Override
	public List<Customer> ShowAllUser() {
		List<Customer> list=(List<Customer>) userrepo.findAll();
		if(list.isEmpty()) {
			throw new DetailsNotFoundException("User details are not found");
		}
        return list;
	}


	@Override
	public Customer ShowUser(Integer user_id)  {
		
		if(userrepo.findById(user_id).isPresent()) {
			Customer u = userrepo.findById(user_id).get();
			return u;	
		}
		else throw new DetailsNotFoundException("User details are not found");
		
	}

	
}
