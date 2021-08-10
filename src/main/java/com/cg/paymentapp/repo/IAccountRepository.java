package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;

public interface IAccountRepository extends JpaRepository<BankAccount,Integer>{
	
	//public BankAccount findById(int bid);
	public BankAccount findByWallet(Wallet wallet);
	@Query("select b.accountNo,b.ifscCode,b.bankName,b.balance from BankAccount b,Wallet w where w.walletId=b.wallet.walletId and w.walletId=?1")
	public List<Integer> viewAllAccounts(int walletId);

}
