package com.cg.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IAccountService;

@RestController
public class AccountController {
	
@Autowired
public IAccountService accountService;



@PostMapping("/addAccount")
public Wallet  addAccount( @RequestBody BankAccount bacc) {
	return accountService.addAccount(bacc);
}

@DeleteMapping("/removeAccount")
public Wallet removeAccount(@RequestBody BankAccount bacc) {
	
	return accountService.removeAccount(bacc);
}

@GetMapping("/viewAccount")
public Wallet viewAccount(@RequestBody BankAccount bacc) {
	
	return accountService.viewAccount(bacc);
}
@GetMapping("/viewAllAccounts/{walletId}")
public List<Integer> viewAllAccounts(@PathVariable int walletId){
	return accountService.viewAllAccounts(walletId);
}
}
