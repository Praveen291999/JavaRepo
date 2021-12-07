package com.dnapass.training.java.day9.account;


public class Account implements Greetings {
	private int accountNumber;
	private double accountBalance;
	private static int AutomaticAccountNo = 0;

// getter and setter
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

// constructor
	public Account() {
		AutomaticAccountNo++;
		this.setAccountNumber(AutomaticAccountNo);
		this.setAccountBalance(0);
		this.showDetails();

	}

	public Account(int accountBalance) {
		AutomaticAccountNo++;
		this.setAccountNumber(AutomaticAccountNo);
		this.setAccountBalance(accountBalance);
		this.showDetails();
	}

	public Account(int accountNumber, double accountBalance) {
		this.setAccountNumber(accountNumber);
		this.setAccountBalance(accountBalance);
		this.showDetails();
	}

// Account class functions
	public void changeAccountNumber(int accountNumber) {
		this.setAccountNumber(accountNumber);
		System.out.println("Account Number Changed");
		this.showDetails();
	}

	public void showDetails() {
		System.out.println(
				"Account Number :" + this.getAccountNumber() + "\tAccount Balance :" + this.getAccountBalance());
	}

	public void deposit(double amount) {
		try {
			this.setAccountBalance(amount + this.getAccountBalance());
			System.out.println("Deposit Successfull from Account :" + this.getAccountNumber());
			this.showDetails();
			throw new InvalidFundException("amount too low for deposit");
		}
		catch(InvalidFundException e)
		{
			System.out.println(e);
		}
	}

	public void withdraw(double amount) {
		try
		{
			this.setAccountBalance(this.getAccountBalance() - amount);
			System.out.println("Withdraw Successfull from Account :" + this.getAccountNumber());
			this.showDetails();
			throw new InvalidFundException("amount too low for deposit");
		}catch(InvalidFundException e)
		{
			System.out.println(e);
		}
	}

	public void transfer(double amount, Account acc) {
		try {
			this.setAccountBalance(this.getAccountBalance() - amount);
			acc.setAccountBalance(acc.accountBalance + amount);
			System.out.println("Transfer Successfull to Account :" + acc.getAccountNumber());
			this.showDetails();
			acc.showDetails();
			throw new InvalidFundException("Balance low to transfer");
		}catch(InvalidFundException e)
		{
			System.out.println(e);
		}
		
	}

	public void Welcome() {
// TODO Auto-generated method stub
		System.out.println("Welcome...");

	}

	public void ThankYou() {
// TODO Auto-generated method stub
		System.out.println("thank you...");

	}
}
