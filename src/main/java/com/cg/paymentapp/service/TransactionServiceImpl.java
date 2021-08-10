package com.cg.paymentapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.ITransactionRepository;
import com.cg.paymentapp.repo.IWalletRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{
	@Autowired 
	private ITransactionRepository transRepo;
	
	@Autowired
	private IWalletRepository walletRepo;
	

	@Override
	public Transaction addTransaction(Transaction tran) {
		
		boolean b=walletRepo.existsById(tran.getWallet().getWalletId());
		if(!b) {
			throw new InvalidInputException("Transaction Id doesnot Exist");
		}
		Transaction tr=new Transaction();
		tr.setTransactionId(tran.getTransactionId());
		tr.setTransactionType(tran.getTransactionType());
		tr.setAmount(tran.getAmount());
		tr.setTransactionDate(tran.getTransactionDate());
		tr.setDescription(tran.getDescription());
		tr.setWallet(walletRepo.findById(tran.getWallet().getWalletId()).get());
		return transRepo.save(tr);
		
	}

	@Override
	public List<Transaction> viewAllTransactions(int walletId) {
		boolean b=walletRepo.existsById(walletId);
		if(!b) {
			throw new InvalidInputException("WalletID Doesnot Exist");
		} 
		else 
		   return transRepo.findAll();
		}
	 	

	@Override
	public List<Transaction> viewTransactionsByDate(String fromDate, String to) { 
		 
		return transRepo.viewTransactionsByDate(fromDate, to);
		
	}

	@Override
	public List<Transaction> viewAllTransactions(String type) {
	
	return transRepo.findByType(type);

}
}