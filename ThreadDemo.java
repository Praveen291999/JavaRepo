package com.dnapass.training.java.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		(new Thread(new HelloRunnable())).start();
		(new HelloThread()).start();
		String importantInfo[] = { "Mares eats oats", "Does eats oats", "little lamb eat ivy" };
		for (int i = 0; i < importantInfo.length; i++) {
			Thread.sleep(4000);
			System.out.println(importantInfo[i]);
		}
		for (int i = 0; i < importantInfo.length; i++) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println(importantInfo[i]);
		}
		for (int i = 0; i < importantInfo.length; i++) {
			heavyCrunch(importantInfo[i]);
			if (Thread.interrupted()) {
				return;
			}
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
	}

	public static void heavyCrunch(String string) {
	}
}

class HelloRunnable implements Runnable {
	public void run() {
		System.out.println("Hello from a thread");
	}
}

class HelloThread extends Thread {
	public void run() {
		System.out.println("Hello from a thread");
	}
}

class counter {
	private int c = 0;

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int value() {
		return c;
	}
}

class Synchronizedcounter {
	private int c = 0;
	private String lastName;
	private List<String> nameList = new ArrayList();

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

	public void addName(String name) {
		synchronized (this) {
			lastName = name;
			c++;
		}
		nameList.add(name);
	}
}

class MsLunch {
	private long c1 = 0;
	private long c2 = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void inc1() {
		synchronized (lock1) {
			c1++;
		}
	}

	public void inc2() {
		synchronized (lock2) {
			c2++;
		}
	}
}
