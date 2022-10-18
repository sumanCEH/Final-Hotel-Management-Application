package com.hma.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Transaction;
import com.hma.demo.repository.TransactionRepository;
import com.hma.demo.service.TransactionService;



@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction addTransaction(Transaction transaction) throws Exception {
		try{transactionRepository.save(transaction);
		return transaction;
		}catch (Exception e) {
			throw new Exception("Details are mismatched");
		}
		
	}

}
