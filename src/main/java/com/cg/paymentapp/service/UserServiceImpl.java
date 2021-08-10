package com.cg.paymentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserRepository userRepo;

	@Override
	public Customer validateLogin(String mobileNumber, String password) {
		
		Customer customer=userRepo.validateLogin(mobileNumber, password);
		if(customer!=null)
		   return customer;
		else
		   throw new InvalidInputException("Moblie Number or Password are incorrect");	
		
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return userRepo.save(customer);
	
	}
	

}
