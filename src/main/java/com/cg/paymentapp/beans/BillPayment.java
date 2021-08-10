package com.cg.paymentapp.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BillPayment {
	
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO ) 
	private int billId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	private BillType billtype;
	private double amount;
	
	private LocalDate paymentDate;
	
	
	public BillPayment() {
		super();
	}
	
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public BillType getBilltype() {
		return billtype;
	}
	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public BillPayment(int billId, Wallet wallet, BillType billtype, double amount, LocalDate paymentDate) {
		super();
		this.billId = billId;
		this.wallet = wallet;
		this.billtype = billtype;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	
	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", billtype=" + billtype + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}
	
	

}
