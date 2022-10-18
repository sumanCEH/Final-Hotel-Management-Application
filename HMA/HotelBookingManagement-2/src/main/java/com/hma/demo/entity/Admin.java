package com.hma.demo.entity;

import javax.persistence.Entity; 
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Builder;


@Entity
public class Admin {
	@Id
    private int admin_id;
    private String admin_name;
    private String password;


	public Admin() {
		super();
	}
	
	
	public Admin(int admin_id, String admin_name, String password) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.password = password;
	}
	
	
	public int getAdmin_id() {
		return admin_id;
	}
	
	
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	
	public String getAdmin_name() {
		return admin_name;
	}
	
	
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", password=" + password + "]";
	}



}
