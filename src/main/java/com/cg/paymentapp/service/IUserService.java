package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.Customer;

public interface IUserService {
	
	public Customer validateLogin(String mobileNumber,String password);
	
	public Customer registerCustomer(Customer customer);
}
