package com.dnapass.training.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

import com.dnapass.training.java.transaction.DataLoader;
import com.dnapass.training.java.transaction.Transaction;

interface Something {
	public String doit(Integer i);
//public String doit1(Integer i);
}

interface HelloFunctionInterface {
	public String sayHello();
//public String doit(Integer i);
}

public class LambdaDemo {
	public static void main(String args[]) {
		HelloFunctionInterface msg = () -> {
			return "Hello";
		};
		System.out.println(msg.sayHello());

		LambdaDemo lambdaDemo = new LambdaDemo();
		lambdaDemo.demo();

	}

	private void demo() {
//without lambda
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Hello World!.. without lambda");
			}
		};
		r.run();
//with lambda
		Runnable r1 = () -> {
			System.out.println("hello World with lambda");
		};
		r1.run();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(1);
		numbers.add(0);
		numbers.forEach(n -> {
			System.out.print(n + " ");
		});
		System.out.print("\n");
		Consumer<Integer> method = m -> {
			System.out.print(m + " ");
		};
		numbers.forEach(method);
//implicit return
		Comparator<String> c1 = (String lhs, String rhs) -> lhs.compareTo(rhs);
		int result = c1.compare("Hello", "Hello");
		int result1 = c1.compare("Hello", "World");
		System.out.println("\n" + result + "\n" + result1);
// with return
		Comparator<String> c2 = (String lhs, String rhs) -> {
			return lhs.compareTo(rhs);
		};
		int result2 = c2.compare("Hello", "Hello");
		int result3 = c2.compare("Hello", "World");
		System.out.println(result2 + "\n" + result3);
//type inference type not need to be declared
		Comparator<String> c3 = (lhs, rhs) -> {
			return lhs.compareTo(rhs);
		};
		int result4 = c3.compare("Hello", "Hello");
		int result5 = c3.compare("Hello", "World");
		System.out.println(result4 + "\n" + result5);

		LambdaDemo lambdaDemo = new LambdaDemo();
		List<Transaction> transactions = DataLoader.newTransactions();

		Comparator<Transaction> c4 = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
// TODO Auto-generated method stub
				return o1.getId().compareTo(o2.getId());
			}
		};
		Comparator<Transaction> c5 = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
// TODO Auto-generated method stub
				return o1.getAmount().compareTo(o2.getAmount());
			}
		};

		Collections.sort(transactions, c4);
		transactions.forEach(n -> System.out.println(
				n.getId() + " " + n.getType() + " " + n.getAmount() + " " + n.getCity() + " " + n.getCurrency()));

//lambda
		Collections.sort(transactions, (lhs, rhs) -> lhs.getCity().compareTo(rhs.getCity()));
		transactions.forEach(n -> System.out.println(
				n.getId() + " " + n.getType() + " " + n.getAmount() + " " + n.getCity() + " " + n.getCurrency()));

		Collections.sort(transactions, comparing(Transaction::getId));
		transactions.forEach(n -> System.out.println(
				n.getId() + " " + n.getType() + " " + n.getAmount() + " " + n.getCity() + " " + n.getCurrency()));

//static method
		transactions.stream().map(t -> t.getAmount()).forEach(amt -> System.out.println(String.valueOf(amt)));
		transactions.stream().map(t -> t.getAmount()).forEach(String::valueOf);

		transactions.stream().sorted((a, b) -> c4.compare(a, b));
		transactions.forEach(n -> System.out.println(
				n.getId() + " " + n.getType() + " " + n.getAmount() + " " + n.getCity() + " " + n.getCurrency()));

		transactions.stream().sorted(c5::compare);
		transactions.forEach(n -> System.out.println(
				n.getId() + " " + n.getType() + " " + n.getAmount() + " " + n.getCity() + " " + n.getCurrency()));

		transactions.stream().map(t -> t.getAmount()).sorted((a, b) -> a.compareTo(b));
		transactions.stream().map(t -> t.getAmount()).sorted(Double::compareTo);

		Supplier<Transaction> t1 = Transaction::new;
		System.out.println(t1.get());
	}
}