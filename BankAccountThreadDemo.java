package com.dnapass.training.java.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountThreadDemo {
	public static void main(String[] args) {
		BankAccount account=new BankAccount();
		final double AMOUNT=100;
		final int REPITITIONS=10;
DepositRunnable d=new DepositRunnable(account,AMOUNT,REPITITIONS);
WithdrawRunnable w=new WithdrawRunnable(account,AMOUNT,REPITITIONS);

Thread t1=new Thread(d);
Thread t2=new Thread(w);

t1.start();
t2.start();
}
}

class DepositRunnable implements Runnable{
	private static final int DELAY=1;
	private BankAccount account;
	private double amount;
	private int count;
	public DepositRunnable(BankAccount anAccount, double anAmount, int aCount) {
		account =anAccount;
		amount = anAmount;
		count = aCount;
}
public void run() {
try {
	for(int i=1;i<=count;i++) {
		account.deposit(amount);
		Thread.sleep(DELAY);
}
}catch (InterruptedException exception) {
}

}
}
class WithdrawRunnable implements Runnable {
	private static final int DELAY=1;
	private BankAccount account;
	private double amount;
	private int count;
public WithdrawRunnable(BankAccount anAccount, double anAmount, int aCount) {
	account = anAccount;
	amount = anAmount;
	count = aCount;
}
public void run() {
try {
	for(int i=1;i<=count;i++) {
		account.withdraw(amount);
		Thread.sleep(DELAY);
}
}catch (InterruptedException exception) {
}
}
}

class BankAccount {
	private double balance;
public BankAccount() {
	balance=0;
}
public void deposit(double amount) {
	System.out.println("Depositing "+amount);
	double newBalance=balance+amount;
	System.out.println("new balance is"+newBalance);
	balance=newBalance;
}
public double getBalance() {
	return balance;
}
public void withdraw(double amount) {
	System.out.println("withdrawing"+amount);
	double newBalance=balance-amount;
	System.out.println("new balance is:"+newBalance);
	balance=newBalance;

}
public double getBalance1() {
return balance;
}
}
class BankAccount1 {
	private double balance;
	private Lock balanceChangeLock;

public BankAccount1() {
balance=0;
balanceChangeLock=new ReentrantLock();
}
public void deposit(double amount) {
	balanceChangeLock.lock();
try {
	System.out.println("Depositing"+amount);
	double newBalance=balance+amount;
	System.out.println("new balance is"+newBalance);
	balance=newBalance;
}finally {
	balanceChangeLock.unlock();
}
}
}
class BankAccount2 {
	private double balance;
	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	public BankAccount2() {
		balance=0;
		balanceChangeLock=new ReentrantLock();
		sufficientFundsCondition=balanceChangeLock.newCondition();
}
public void deposit(double amount) {
balanceChangeLock.lock();
try {
	System.out.println("Depositing"+amount);
	double newBalance=balance+amount;
	System.out.println(",new balance is"+newBalance);
	balance=newBalance;
	sufficientFundsCondition.signalAll();
}finally {
	balanceChangeLock.unlock();
}

}
public void withdraw(double amount) {
balanceChangeLock.lock();
try {
	while(balance<amount)
		sufficientFundsCondition.await();
	System.out.println("withdrawing"+amount);
	double newBalance=balance-amount;
	System.out.println(",new balance is"+newBalance);
	balance=newBalance;
}catch (InterruptedException e) {
	e.printStackTrace();
}finally {
	balanceChangeLock.unlock();
}
}
}