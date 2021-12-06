package com.dnapass.training.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressionDemo {
	@FunctionalInterface
	interface CheckPeople {
		boolean test(People p);
	}

	public static void printPeopleOlderThan(List<People> roster, int age) {
		for (People p : roster) {
			if (p.getAge() >= age) {
				p.printPeople();
			}
		}
	}

	public static void printPeopleWithinAgeRange(List<People> roster, int low, int high) {
		for (People p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPeople();
			}
		}
	}

	public static void printPeople(List<People> roster, CheckPeople tester) {
		for (People p : roster) {
			if (tester.test(p)) {
				p.printPeople();
			}
		}
	}

	public static void printPeopleWithPredicate(List<People> roster, Predicate<People> tester) {
		for (People p : roster) {
			if (tester.test(p)) {
				p.printPeople();
			}
		}
	}

	public static void processPeople(List<People> roster, Predicate<People> tester, Consumer<People> block) {
		for (People p : roster) {
			if (tester.test(p)) {
				p.printPeople();
			}
		}
	}

	public static void processPeopleWithFunction(List<People> roster, Predicate<People> tester,
			Function<People, String> mapper, Consumer<People> block) {
		for (People p : roster) {
			if (tester.test(p)) {
				p.printPeople();
			}
		}
	}

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		List<People> roster = People.createRoster();

		for (People p : roster) {
			p.printPeople();
		}

//create method that search for people that match one characteristics
		System.out.println("People older than 20: ");
		printPeopleOlderThan(roster, 20);
		System.out.println();

//create more generalized search method
		System.out.println("People between the ages of 14 and 30: ");
		printPeopleWithinAgeRange(roster, 14, 30);
		System.out.println();

//specify search criteria code in a local Class
		System.out.println("People Who are eligible for selective Service: ");
		class CheckPeopleEligibleForSelectiveService implements CheckPeople {
			public boolean test(People p) {
				return p.getGender() == People.Sex.MALE && p.getAge() >= 10 && p.getAge() <= 25;
			}
		}

		printPeople(roster, new CheckPeopleEligibleForSelectiveService());
		System.out.println();

//specify search criteria code in a Anonymous class
		System.out.println();

		printPeople(roster, new CheckPeople() {
			public boolean test(People p) {
				return p.getGender() == People.Sex.MALE && p.getAge() <= 25;
			}
		});
		printPeople(roster, new CheckPeopleEligibleForSelectiveService());

		System.out.println();

//specify search criteria code in a lambda Expression
		System.out.println("People who are eligible for selective service " + "(lambda expression) : ");

		CheckPeople tester = (People p) -> p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
		printPeople(roster, tester);
		System.out.println();

//Using lambda Expression throughout your Application
		System.out
				.println("People who are eligible for selective Service:" + "(with predicate and consumer parameter):");
		Consumer<People> block = p -> p.printPeople();
		processPeople(roster, p -> p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, block);
		System.out.println();
//second example
		System.out
				.println("People who are eligible for selective Service:" + "(with predicate and consumer predicate):");
		Consumer<People> block1 = p -> p.printPeople();
		processPeople(roster, p -> p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, block1);
		System.out.println();

//use generics more extensively
		System.out
				.println("People who are eligible for selective Service:" + "(with predicate and consumer predicate):");
		processElements(roster, p -> p.getGender() == People.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(), email -> System.out.println(email));
		System.out.println();

	}

}