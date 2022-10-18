package com.hma.demo.repository;

import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hma.demo.entity.Admin;

public interface AdminRepository extends CrudRepository< Admin, Integer> {
	
	@Query(" from Admin a where a.admin_name=:admin_name and a.password=:password")
	public Admin getCredentials(@Param(value = "admin_name") String admin_name,
			@Param(value = "password") String password);

}
