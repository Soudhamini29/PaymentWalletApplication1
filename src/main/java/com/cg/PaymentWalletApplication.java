package com.cg;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IUserService;
import com.cg.paymentapp.service.UserServiceImpl;

@SpringBootApplication
public class PaymentWalletApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PaymentWalletApplication.class, args);
		/* ApplicationContext ctx= SpringApplication.run(PaymentWalletApplication.class, args);
		IUserService user=ctx.getBean("userServiceImpl",UserServiceImpl.class) ;  
	    Customer customer=new Customer();
	    customer.setMobileNo("9704169622");
	    customer.setPassword("12345");
	    customer.setName("Ram");
	    Wallet wallet = new Wallet();
	    wallet.setBalance(BigDecimal.valueOf(50000));
	    
	  user.registerCustomer(customer);*/
	}

}
