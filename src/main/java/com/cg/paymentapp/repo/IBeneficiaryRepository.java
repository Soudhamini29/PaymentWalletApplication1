package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;

public interface IBeneficiaryRepository extends JpaRepository<BeneficiaryDetails, Integer>{

	public List<BeneficiaryDetails> findByWallet(Wallet wallet);
	public  BeneficiaryDetails  findById(int bid);
	
}
