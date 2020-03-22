package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	
	private BigDecimal balance;
	private String accountNumber;
	
	public CheckingAccount() {
		super();
	}
// OVERRIDE METHOD	
// Withdraw - if the balance falls below $0.00, a $10.00 overdraft fee is also withdrawn from the account
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().subtract(amountToWithdraw).intValue() > -100) {
			super.setBalance(super.getBalance().subtract(amountToWithdraw));
			if(super.getBalance().intValue() < 0) {
				super.setBalance(super.getBalance().subtract(new BigDecimal("10")));
			}
			return balance;
		}
		return balance;
	}
}
