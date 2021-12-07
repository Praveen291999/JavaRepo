package com.dnapass.training.java.day9.account;

public class PrivilagedAccount extends Account implements Greetings {
	private double excessAmount = 0;

//getter and Setter
	public double getExcessAmount() {
		return excessAmount;
	}

	public void setExcessAmount(double excessAmount) {
		this.excessAmount = excessAmount;
	}

//constructor
	public PrivilagedAccount(int accountNumber, double accountBalance) {
		super(accountNumber, accountBalance);
	}

	{
		System.out.println(" account created....................");
	}

//privilaged account class function
	@Override
	public void withdraw(double amount) {
// TODO Auto-generated method stub
		if (this.getAccountBalance() < amount) {
			this.setExcessAmount(amount - this.getAccountBalance());
			super.deposit(this.getExcessAmount());
			super.withdraw(amount);
		} else {
			super.withdraw(amount);
		}
	}

	@Override
	public void transfer(double amount, Account acc) {
// TODO Auto-generated method stub
		if (this.getAccountBalance() < amount) {
			this.setExcessAmount(amount - this.getAccountBalance());
			super.deposit(this.getExcessAmount());
			super.transfer(amount, acc);
		} else {
			super.transfer(amount, acc);
		}
	}

	@Override
	public void Welcome() {
// TODO Auto-generated method stub
		super.Welcome();
		System.out.println("We are happy to help you.");
	}

	@Override
	public void ThankYou() {
// TODO Auto-generated method stub
		super.ThankYou();
		System.out.println("Privilaged account is created");
	}

}