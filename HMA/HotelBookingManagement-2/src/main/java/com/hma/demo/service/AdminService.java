package com.hma.demo.service;



import com.hma.demo.entity.Admin;

public interface AdminService {

	public String signIn(String adminName, String adminPassword);
	public String register(Admin admin) ;
	
}
