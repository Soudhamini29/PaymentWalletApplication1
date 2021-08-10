package com.cg.paymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;
	private BigDecimal balance;
	
	public Wallet(){
		
	}
	
	public int getWalletId() {
		return walletId;
	}
	
	void setWalletId(int walletId) {
		this.walletId = walletId;
	}
   
	public Wallet(BigDecimal amount) {
		this.balance=amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
		public String toString() {
		return " balance= "+balance;
	}

}
