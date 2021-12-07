package com.dnapass.training.java.files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import com.dnapass.training.java.day9.account.Account;

//import com.dnapass.training.java.Exceptions.Account;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		BankData data = new BankData();
		try {
			data.open("bank.dat");
			boolean done = false;
			while (!done) {
				System.out.println("Account number");
				int accountNumber = in.nextInt();
				System.out.println("amount to deposit");
				double amount = in.nextDouble();
				int position = data.find(accountNumber);
				Account account;
				if (position >= 0) {
					account = data.read(position);
					account.deposit(amount);
					System.out.println("new balance=" + account.getAccountBalance());
				} else {
					account = new Account(accountNumber, amount);
					position = data.size();
					System.out.println("add account");
				}
				data.write(position, account);
				System.out.println("Done?(Y/N)");
				String input = in.next();
				if (input.equalsIgnoreCase("Y"))
					done = true;
			}
		} finally {
			data.close();
		}

	}

}

class BankData {
	public BankData() {
		file = null;
	}

	public void open(String filename) throws IOException {
		if (file != null)
			file.close();
		file = new RandomAccessFile(filename, "rw");
	}

	public int size() throws IOException {
		return (int) (file.length() / RECORD_SIZE);
	}

	public void close() throws IOException {
		if (file != null)
			file.close();
		file = null;
	}

	public Account read(int n) throws IOException {
		file.seek(n * RECORD_SIZE);
		int accountNumber = file.readInt();
		double balance = file.readDouble();
		return new Account(accountNumber, balance);
	}

	public int find(int accountNumber) throws IOException {
		for (int i = 0; i < size(); i++) {
			file.seek(i * RECORD_SIZE);
			int a = file.readInt();
			if (a == accountNumber)
				return i;
		}
		return -1;
	}

	public void write(int n, Account account) throws IOException {
		file.seek(n * RECORD_SIZE);
		file.writeInt(account.getAccountNumber());
		file.writeDouble(account.getAccountBalance());
	}

	private RandomAccessFile file;
	public static final int INT_SIZE = 4;
	public static final int DOUBLE_SIZE = 8;
	public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;
}
