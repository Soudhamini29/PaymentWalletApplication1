package com.cg.paymentapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.IBillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	IBillPaymentService billPay;
	
	@GetMapping("/hello")
	public LocalDate hello() {
		return LocalDate.now();
	}
	
	@PostMapping("/addBillPayment")
	public BillPayment addBillPayment(@RequestBody BillPayment payment) {
		
		System.out.println(payment);
			BillPayment bp= billPay.addBillPayment(payment);
			
			return bp;
		}
	

	@GetMapping("viewbill/{paymentid}")
	public BillPayment viewBillPayment(@PathVariable int paymentId) {
		
			return  billPay.viewBillPayment(paymentId);
		
	}

}
