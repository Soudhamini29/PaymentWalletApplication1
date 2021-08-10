package com.cg.paymentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IBeneficiaryRepository;
import com.cg.paymentapp.repo.IUserRepository;
import com.cg.paymentapp.repo.IWalletRepository;

@Service
public class BeneficiaryServiceImpl implements IBeneficiaryService{
	@Autowired
	IBeneficiaryRepository beneRepo;
	
	@Autowired
	IWalletRepository walletRepo;

	@Autowired
	IUserRepository userRepo;

	@Override
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) {
		boolean b = beneRepo.existsById(bd.getBeneficiaryId());
		if (b)
			throw new InvalidInputException("Benificiary id " + bd.getBeneficiaryId() + " Already present");

		else {

			BeneficiaryDetails bend = new BeneficiaryDetails();
			bend.setBeneficiaryId(bd.getBeneficiaryId());
			bend.setMobileNumber(bd.getMobileNumber());
			bend.setName(bd.getName());
			Optional<Wallet> w1 = walletRepo.findById(bd.getWallet().getWalletId());
			if (!w1.isPresent())
				throw new InvalidInputException("Wallet with the id not found ");
			else {
			
			bend.setWallet(w1.get());
			beneRepo.save(bend);
			return bend;
			}
			//return beneRepo.findByWallet(w);
		}
		
	}

	@Override
	public BeneficiaryDetails updateBeneficiary(BeneficiaryDetails bd) {
		return addBeneficiary(bd);
	}

	@Override
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd) {
		if (!beneRepo.existsById(bd.getBeneficiaryId()))
			throw new InvalidInputException("Beneficiary with the id " + bd + " not present");
		else
		{
			BeneficiaryDetails b= beneRepo.findById(bd.getBeneficiaryId());
			beneRepo.deleteById(bd.getBeneficiaryId());
			return b;
		}
		
	}

	@Override
	public BeneficiaryDetails viewBeneficiary(BeneficiaryDetails bd) {
		if (!beneRepo.existsById(bd.getBeneficiaryId()))
			throw new InvalidInputException("Beneficiary with the id " + bd + " not present");
		else
			return beneRepo.findById(bd.getBeneficiaryId());	
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) {
		Wallet w=customer.getWallet();
		boolean b = walletRepo.existsById(w.getWalletId());

		if (!b)
		    throw new InvalidInputException("No Beneficiary found with the wallet id "+customer.getWallet().getWalletId());
		else {
			return beneRepo.findByWallet(w);
	}
		
	}
}

