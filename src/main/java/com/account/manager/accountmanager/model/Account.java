package com.account.manager.accountmanager.model;

/**
 * Created by Chukwudere Adindu.
 */

public class Account {

	private String accountName;
	private String phone;
	private String accountNumber;

	public Account() {
	}

	public Account(String accountName, String phone) {
		this.accountName = accountName;
		this.phone = phone;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountName='" + accountName + '\'' +
				", phone='" + phone + '\'' +
				", accountNumber='" + accountNumber + '\'' +
				'}';
	}
}
