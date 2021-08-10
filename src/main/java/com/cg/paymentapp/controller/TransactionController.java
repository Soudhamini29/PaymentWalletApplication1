package com.cg.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.ITransactionService;

@RestController
public class TransactionController {
	@Autowired
	private ITransactionService tranService;
	
	@GetMapping("/viewAllTransactionsByWallet")
	public List<Transaction> viewAllTransactions(@RequestBody int walletId) {
		
		return tranService.viewAllTransactions(walletId);	
	}
	
	@GetMapping("/viewAllTransactionsByType/{type}")
	public List<Transaction> viewAllTransactions(@PathVariable String type) {
		
		return tranService.viewAllTransactions(type);	
	}
	
	@GetMapping("/viewTransactionsByDate/{from}/{to}")
	public List<Transaction> viewTransactionsByDate(@PathVariable  String from, @PathVariable String to){
		
		return tranService.viewTransactionsByDate(from, to);
	}
	
	@PutMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction tran) {
		return tranService.addTransaction(tran);
	}

}

