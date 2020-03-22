package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
// ATTRIBUTES
	private String accountNumber;
	private BigDecimal balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
		
// CONSTRUCTOR
	public BankAccount() {
		balance = new BigDecimal("0.00");
		accountNumber = "1234";
	}	
		
// METHODS
// Adds amountToDeposit to the current balance and returns the new balance of the bank account
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		this.balance = balance.add(amountToDeposit);
		return balance;
	}	
// Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		this.balance = balance.subtract(amountToWithdraw);
		return balance;
	}
// 	Withdraws transferAmount from this account and deposits it into destinationAccount
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		withdraw(transferAmount); // taking transfer amount and sending it to destination account
		destinationAccount.deposit(transferAmount);
	}
}
