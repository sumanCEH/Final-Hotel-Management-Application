package com.hma.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.hma.demo.entity.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
