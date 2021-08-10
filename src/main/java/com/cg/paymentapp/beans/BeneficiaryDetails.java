package com.cg.paymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	@Entity
	public class BeneficiaryDetails {
		
		@Id
		@GeneratedValue(strategy =GenerationType.AUTO ) 
		private int beneficiaryId;
		private String name;
		private String mobileNumber;
		
		@ManyToOne(cascade = CascadeType.ALL)
		Wallet wallet;
		
			
		public BeneficiaryDetails() {
			super();
		}
		
		public int getBeneficiaryId() {
			return beneficiaryId;
		}
		
		public void setBeneficiaryId(int benificiaryId) {
			this.beneficiaryId = benificiaryId;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		
		
		public Wallet getWallet() {
			return wallet;
		}

		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}

		public BeneficiaryDetails(int beneficiaryId, String name, String mobileNumber, Wallet wallet) {
			super();
			this.beneficiaryId = beneficiaryId;
			this.name = name;
			this.mobileNumber = mobileNumber;
			this.wallet = wallet;
		}
		

	}

