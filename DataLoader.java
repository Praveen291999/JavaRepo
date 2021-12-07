package com.dnapass.training.java.transaction;

import java.util.*;

import com.dnapass.training.java.stream.Person;
public class DataLoader {
	
	public static List<Transaction> newTransactions() {
		List<Transaction> Transactions = new ArrayList<Transaction>();
		Transactions.add(new Transaction(123,ProductType.FUEL,33.33,"LONDON","GBP"));
		Transactions.add(new Transaction(124,ProductType.ELECTRIC,100.0,"BANGALORE","INR"));
		Transactions.add(new Transaction(125,ProductType.GROCERIES,50.5,"CHENNAI","INR"));
		Transactions.add(new Transaction(127, ProductType.ELECTRIC, 159.44, "UK", "GBP"));
		Transactions.add(new Transaction(126, ProductType.GROCERIES, 100.33, "USA", "DOLLARS"));
		Transactions.add(new Transaction(130, ProductType.FRUITS, 489.98, "DELHI", "INR"));
		return Transactions;
		
	}

	public static List<Person> newPersons() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Person("ted","neward",42),new Person("charlotte","neward",39)
				,new Person("michal","neward",19),new Person("mathew","newton",13),new Person("naal","ford",45),
				new Person("candy","ford",39),new Person("jeff","brown",43),new Person("betsy","brown",39));

	
	}
}
