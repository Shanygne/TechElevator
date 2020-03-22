package com.techelevator;

import java.math.BigDecimal;

public class BankTeller {

	public static void main(String[] args) {
		BigDecimal testAmount = new BigDecimal("100000");
		BigDecimal testAmount1 = new BigDecimal("150");
		BankAccount checkingAccount = new CheckingAccount();
		checkingAccount.deposit(testAmount);
		BankAccount savingsAccount = new SavingsAccount();
		BankCustomer jayGatsby = new BankCustomer();
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingsAccount);
		checkingAccount.deposit(testAmount);
		System.out.println(jayGatsby.isVip());
	}

}
