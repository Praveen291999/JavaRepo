package com.dnapass.training.java.day9.account;

public class SavingAccount extends Account {

	private double interestRate;

//getter and setter
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

//Constructor
	public SavingAccount(int accountNumber, double accountBalance, double interestRate) {
		super(accountNumber);
		if (interestRate == 0)
			interestRate = 1;

		this.setInterestRate(interestRate);
// super.showDetails();
		System.out.println("Interest rate :" + this.getInterestRate());
	}

//Saving account class function
	public void interestDeposit() {
		super.deposit(this.getInterestRate() * this.getAccountBalance() / 100);
	}
}