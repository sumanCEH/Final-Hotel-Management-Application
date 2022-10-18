package com.hma.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.hma.demo.entity.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
