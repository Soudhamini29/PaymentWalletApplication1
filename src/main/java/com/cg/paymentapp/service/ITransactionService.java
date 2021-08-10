package com.cg.paymentapp.service;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

public interface ITransactionService {
	
	public Transaction addTransaction (Transaction tran);
	public List<Transaction> viewAllTransactions (int walletId);
	public List<Transaction> viewTransactionsByDate(String fromDate,String to);
	public List<Transaction> viewAllTransactions(String type);

}
