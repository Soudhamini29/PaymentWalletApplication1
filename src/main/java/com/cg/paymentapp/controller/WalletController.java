package com.cg.paymentapp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IWalletService;

@RestController
	public class WalletController {

		@Autowired
		IWalletService walletService;

		@PostMapping("/createWallet/{name}/{mobileno}/{amount}")
		public Customer createWallet(@PathVariable("name") String name, @PathVariable("mobileno") String mobileno,@PathVariable("amount") BigDecimal amount) {	

			Customer c = walletService.createWallet(name, mobileno, amount);
            return c;
			}


		@GetMapping("/showBalance/{mobileno}")
		public Customer showBalance(@PathVariable String mobileno) {

			Customer c = walletService.showBalance(mobileno);
	        
			return c;

		}

		@GetMapping("/customers")
		public List<Customer> getListOfCustomer() {

			List<Customer> cl = walletService.getList();

			return cl;
			}

		@PutMapping("/updateAccount")
		public Customer updateAccount(@RequestBody Customer customer) {
			Customer c = walletService.updateAccount(customer);
			return c;
		}

		@PutMapping("/addMoney/{wallet}/{amount}")
		public Wallet addMoney(@PathVariable Wallet wallet,@PathVariable double amount) {

			Wallet w = walletService.addMoney(wallet, amount);
			return w;
		}
		
		@PutMapping("/bankFundtransfer/{srcMobileNo}/{destMobileNo}/{amount}")
		public Customer fundTransfer(@PathVariable String srcMobileNo,@PathVariable String destMobileNo,@PathVariable BigDecimal amount) {
			return walletService.fundTransfer(srcMobileNo, destMobileNo, amount);
			
		}
		
		@PutMapping("/withdrawAmount/{mobileNo}/{amount}")
		public Customer withdrawAmount(@PathVariable String mobileNo, @PathVariable BigDecimal amount) {
			return walletService.withdrawAmount(mobileNo, amount);
		}

	}

