package com.cg.paymentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IBillPaymentRepository;
import com.cg.paymentapp.repo.IWalletRepository;

@Service
public class BillPaymentServiceImpl implements IBillPaymentService{
	
	
	@Autowired
	IBillPaymentRepository billPayRepo;
	
	@Autowired
	IWalletRepository walletRepo;
	
	
	@Override
	public BillPayment addBillPayment(BillPayment payment) {	
		boolean b=walletRepo.existsById(payment.getWallet().getWalletId());
		if(!b) {
			throw new InvalidInputException("Wallet doesnot exist");
		}
		BillPayment bill=new BillPayment();
		bill.setBillId(payment.getBillId());
		bill.setBilltype(payment.getBilltype());
		bill.setAmount(payment.getAmount());
		bill.setPaymentDate(payment.getPaymentDate());
		bill.setWallet(walletRepo.findById(payment.getWallet().getWalletId()).get());
		return billPayRepo.save(bill);
	}

	@Override
	public BillPayment viewBillPayment(int paymentId) {
		
		boolean b=billPayRepo.existsById(paymentId);
		if(!b) {
		 throw new InvalidInputException("Bill Id doesnot exists");
		}
		else {
		   return billPayRepo.findById(paymentId).get();
		}
		
		
	}

}
