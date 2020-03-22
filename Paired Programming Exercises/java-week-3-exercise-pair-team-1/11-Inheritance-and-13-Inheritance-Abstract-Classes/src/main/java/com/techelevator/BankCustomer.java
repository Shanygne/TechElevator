package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	
	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean isVip() {
		BigDecimal accountsTotal = new BigDecimal("0.00");
		for (BankAccount account: accounts) {
			System.out.println(account.getBalance());
			accountsTotal = accountsTotal.add(account.getBalance());
			System.out.println(accountsTotal);
		}
		System.out.println(accountsTotal);
		return (accountsTotal.intValue() >= 25000);
	}
	
}
