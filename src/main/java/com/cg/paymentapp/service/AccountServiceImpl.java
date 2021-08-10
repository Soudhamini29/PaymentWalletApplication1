package com.cg.paymentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IAccountRepository;
import com.cg.paymentapp.repo.IUserRepository;
import com.cg.paymentapp.repo.IWalletRepository;

@Service 
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	IAccountRepository accountRepo;
	
	
	@Autowired
	IWalletRepository walletRepo;

	@Override
	public Wallet addAccount(BankAccount bacc) {
		Wallet w=bacc.getWallet();
		
		
	    if(!walletRepo.existsById(w.getWalletId()) && !accountRepo.existsById(bacc.getAccountNo())) {
	    	accountRepo.save(bacc);
	    	return w;
	    }else
	    throw new InvalidInputException("Wallet doesn't exsists or Account already exists");
	   	}

	@Override
	public Wallet removeAccount(BankAccount bacc) {
		boolean b=accountRepo.existsById(bacc.getAccountNo());
		if(!b)
			throw new InvalidInputException("Bank account with Accno "+bacc+"not present");
		else {
			BankAccount ba=accountRepo.findById(bacc.getAccountNo()).get();
			Wallet w=ba.getWallet();
			//ba.setWallet(null);
			accountRepo.delete(ba);
			return w;			
		}
	}

	@Override
	public Wallet viewAccount(BankAccount bacc) {
		boolean b=accountRepo.existsById(bacc.getAccountNo());
		if(!b)
			throw new InvalidInputException("Bank account with Accno "+bacc+" not present");
		else {
			BankAccount ba=accountRepo.findById(bacc.getAccountNo()).get();
			Wallet w=ba.getWallet();
			if(walletRepo.existsById(w.getWalletId()))
				return w;
			else
				throw new InvalidInputException("Wallet not exist");
		}
	}
	
	@Override
	public List<Integer> viewAllAccounts(int walletId) {
	return	accountRepo.viewAllAccounts(walletId);

	}
}
	/*@Override
	public List<Wallet> viewAllAccounts(Wallet wallet) {
		
		return accountRepo.findByWallets(wallet);
	}*/


