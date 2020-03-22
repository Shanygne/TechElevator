package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	private BigDecimal balance;
	private String accountNumber;
	
	public SavingsAccount() {
		super();
}
// If current balance is less than $150.00 when a withdrawal is made, an additional $2.00 service fee charge is withdrawn from account
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().compareTo(amountToWithdraw) == 1) {
			if(super.getBalance().compareTo(new BigDecimal("150")) == -1) {
				super.setBalance(super.getBalance().subtract(new BigDecimal("2")));
			}
			super.setBalance(super.getBalance().subtract(amountToWithdraw));
			return super.getBalance();
		}
		return super.getBalance();
	}
}
