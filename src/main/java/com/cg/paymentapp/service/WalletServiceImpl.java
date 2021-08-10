package com.cg.paymentapp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IAccountRepository;
import com.cg.paymentapp.repo.IUserRepository;
import com.cg.paymentapp.repo.IWalletRepository;

@Service
public class WalletServiceImpl implements IWalletService{
	
	@Autowired
	IWalletRepository walletRepo;
	
	@Autowired
	IUserRepository userRepo;

	@Autowired
	IAccountRepository accountRepo;

	@Override
	public Customer createWallet(String name, String mobileNo, BigDecimal amount) {

		Optional<Customer> customer = userRepo.findById(mobileNo);
	
		if (!customer.isPresent()) {
			throw new InvalidInputException("No customer found for the mobile no :"+mobileNo);		
		}
		else if (customer.get().getWallet() == null) {
			Wallet w = new Wallet();
			w.setBalance(amount);
			walletRepo.save(w);
			customer.get().setWallet(w);
			userRepo.save(customer.get());
			return customer.get();
		} 
		else {
			throw new InvalidInputException("Wallet is already Present for the mobileno");
		}

	}

	@Override
	public Customer showBalance(String mobileno) {
	/*	boolean b = userRepo.existsById(mobileno);
		if (!b) {
			System.out.println("Customer doesnot exist"+b);
			throw new InvalidInputException("mobileno does not exists");
		} else {
			Customer c = userRepo.getById(mobileno);
			//Wallet w = c.getWallet();
			//return w.getBalance();
			return c;		
		}*/
		return userRepo.findById(mobileno).orElseThrow(()-> new InvalidInputException("Mobile number doesnot exist"));
	}


	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		boolean s = userRepo.existsById(sourceMobileNo);
		boolean t = userRepo.existsById(targetMobileNo);

		double damount = amount.doubleValue();

		if (s && t)
			
		{
			Customer csrc = userRepo.findById(sourceMobileNo).get();
			Customer cdes = userRepo.findById(targetMobileNo).get();
			BankAccount src = accountRepo.findByWallet(csrc.getWallet());
			BankAccount dest = accountRepo.findByWallet(cdes.getWallet());

			if (src != null && dest != null){
				
				if (src.getBalance() < damount) 
					throw new InsufficientBalanceException("Insufficient balance in source account");
				else {
					dest.setBalance(dest.getBalance() + damount);
					src.setBalance(src.getBalance() - damount);
					accountRepo.save(src);
					accountRepo.save(dest);
					return cdes;
				    }
				}
		  else {
				throw new InvalidInputException("Bank Account not Available");

			   }

		   }
		else {
		     throw new InvalidInputException("Enter the correct mobile no details");
		    }
	
	}
	
	
	
	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		boolean s = userRepo.existsById(mobileNo);
		if (!s) {
			throw new InvalidInputException("Enter Correct Mobile Number");
		} else {
			Customer c = userRepo.findById(mobileNo).get();
			Wallet w = c.getWallet();
			BigDecimal bal = w.getBalance();
			if (bal.doubleValue() < amount.doubleValue()) {
				throw new InsufficientBalanceException("Insufficient balance");
			} else {
				w.setBalance(w.getBalance().subtract(amount));
				walletRepo.save(w);
				return c;
			}
		}
	}
	

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		boolean b = userRepo.findById(mobileNo).isPresent();

		if (!b)
			throw new InvalidInputException("Enter correct mobile number");
		else {
			Customer c=userRepo.findById(mobileNo).get();
			Wallet wallet = c.getWallet();
			wallet.setBalance(amount.add(wallet.getBalance()));
			walletRepo.save(wallet);
			return c;
		}

	}
	
	@Override
	public List<Customer> getList() {
		return userRepo.findAll();
	}

	
	@Override
	public Customer updateAccount(Customer customer) {
		Optional<Customer> cb = userRepo.findById(customer.getMobileNo());
		if (!cb.isPresent())
			throw new InvalidInputException("Enter the Correct Customer mobileNumber");
		else {
			Customer c=cb.get();
			c.setName(customer.getName());
			c.setPassword(customer.getPassword());
          	userRepo.save(c);
			return c;
		}
	}

	
	
	@Override
	public Wallet addMoney(Wallet wallet, double amount) {
		boolean b = walletRepo.findById(wallet.getWalletId()).isPresent();

		if (!b)
			throw new InvalidInputException(" Enter the correct wallet id");
		else {
			//Wallet w = walletRepo.findById(wallet.getWalletId()).get();
			BigDecimal amt = new BigDecimal(amount);
			wallet.setBalance(amt.add(wallet.getBalance()));
			walletRepo.save(wallet);
			return wallet;
		}

	}
	

}
