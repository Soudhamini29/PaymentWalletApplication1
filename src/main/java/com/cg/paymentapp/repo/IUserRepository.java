package com.cg.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.paymentapp.beans.Customer;

public interface IUserRepository extends JpaRepository<Customer, String> {
	
@Query("from Customer where mobileNo=?1 AND password=?2")
public Customer validateLogin(String mobileNumber,String password);

}