package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.BillPayment;

public interface IBillPaymentService {
	
	public BillPayment addBillPayment(BillPayment payment);
	public BillPayment viewBillPayment(int paymentId);

}
