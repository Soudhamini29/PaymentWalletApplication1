package com.cg.paymentapp.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query("from Transaction t where t.transactionType=?1")
	public  List<Transaction> findByType(String type);
	
	@Query("from Transaction t where  t.transactionDate between ?1 AND ?2")
	public List<Transaction> viewTransactionsByDate(String dFrom, String to);
	//public  Transaction findByDate(String transDate);
	
	/*@Query("from transaction t where t.wallet.getWalletId()=?1")
	public List<Transaction> viewAllTransactions(int walletId);*/
}