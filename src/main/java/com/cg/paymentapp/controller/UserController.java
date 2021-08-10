package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.LoginBean;
import com.cg.paymentapp.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/registerCustomer")
	public Customer registerCustomer(@RequestBody Customer customer ) {
		
		/*Customer c=userService.registerCustomer(customer);
		System.out.println(c.getPassword());*/
		return userService.registerCustomer(customer);
	}
	
	@PostMapping("/validateUser")
	public Customer validateUser(@RequestBody LoginBean loginBean) {
		
		return userService.validateLogin(loginBean.getMobileNumber(), loginBean.getPassword());
	}

}
