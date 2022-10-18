package com.hma.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Payment;
import com.hma.demo.repository.PaymentRepository;
import com.hma.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) throws Exception{
		try{return paymentRepository.save(payment);
		}catch (Exception e) {
			throw new Exception("Details are mismatched");
		}
	}

}
