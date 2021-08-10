package com.cg.paymentapp.beans;

public class LoginBean {
	
	String mobileNumber;
	String password;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginBean() {
		
		
	}
	public LoginBean(String mobileNumber, String password) {
		
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	

}
