package com.dnapass.training.java.day9.account;

public class TestAccount {

	public static void main(String[] args) {

//Account a3 = new Account(3,5000);
// a3.showDetails();
// a3.withdraw(19.998);
// a3.transfer(1000, a1);
// a1.transfer(100, a2);
// a1.changeAccountNumber(5);

		account();
		savingAccount();
		currentAccount();
		privilagedAccount();
	}

	private static void account() {
		System.out.println("\nACCOUNT\n");
		Account a1 = new Account();
		Account a2 = new Account(2000);
		a1.withdraw(100);
		a1.transfer(100, a2);

		a2.withdraw(1000.010);
		a2.transfer(100, a1);
		a1.deposit(1000);
	}

	private static void savingAccount() {
// SAVING ACCOUNT
		System.out.println("\nSAVING ACCOUNT\n");
		Account a4 = new SavingAccount(4, 4000, 2);
// a4.interestDeposit() won't work

		SavingAccount a5 = new SavingAccount(4, 8000, 2);
		a5.Welcome();
		a5.changeAccountNumber(5);
		a5.interestDeposit();
		a5.ThankYou();
	}

	private static void currentAccount() {
// CURRENT ACCOUNT
		System.out.println("\nCURRENT ACCOUNT\n");

		Account a6 = new CurrentAccount(6, 9000);
		CurrentAccount a7 = new CurrentAccount(7, 3000);
		CurrentAccount a8 = new CurrentAccount(8, 8500);
		a8.Welcome();
		a8.deposit(100);
		a8.transfer(1000, a7);
		a8.withdraw(2000);
//.showDetails();
		a8.ThankYou();
	}

	private static void privilagedAccount() {
// PRIVILAGED ACCOUNT
		System.out.println("\n\nPRIVILAGED ACCOUNT\n");

		Account a9 = new PrivilagedAccount(8, 10000);
		a9.changeAccountNumber(9);
		a9.withdraw(11000);

		PrivilagedAccount a10 = new PrivilagedAccount(10, 1800);
		a10.Welcome();
		a10.transfer(20000, a9);
		a10.ThankYou();
	}
}