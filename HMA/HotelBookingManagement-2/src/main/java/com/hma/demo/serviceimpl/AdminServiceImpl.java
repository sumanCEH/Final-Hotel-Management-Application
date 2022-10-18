package com.hma.demo.serviceimpl;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Admin;
import com.hma.demo.repository.AdminRepository;
import com.hma.demo.service.AdminService;

@Service
@Transactional

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	

	@Override
	public String register(Admin admin) {
	    adminRepository.save(admin);
	    return "Register successfully";
	}

	@Override
	public String signIn(String adminName, String adminPassword) {
		
		Admin adminDb = adminRepository.getCredentials(adminName, adminPassword);
		
		if (adminDb != null) {
			if(adminDb.getAdmin_name().equals(adminName) == true && adminDb.getPassword().equals(adminPassword) == true) {
				return "Login successfully";
			}
			else {
				return "Unauthorised access";
			}
		}
		return "Invalid credentials";
	}

}
