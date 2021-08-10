package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;

public interface IBeneficiaryService {
	
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails updateBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails viewBeneficiary(BeneficiaryDetails bd);
	
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);

}
