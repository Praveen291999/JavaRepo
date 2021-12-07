package com.dnapass.training.java.day6.CardSamples;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Select the card\n1.payback card\n2.membership card\n");
		Scanner sc = new Scanner(System.in);
		int choose=sc.nextInt();
		String[] str=new String[4];
		switch(choose) {
		case 1: payBackCard();
				break;
		case 2:memberShipCard();
				break;
		default:System.out.println("enter correct choice!..");
		}
	}
private static void payBackCard() {
	int points,amount;
	System.out.println("Enter the Card Details:");
	Scanner sc = new Scanner(System.in);
	String[] str = sc.nextLine().split("\\|");
	System.out.println(str[0]);
	System.out.println("Enter points in Card :");
 	points=sc.nextInt();
 	System.out.println("Enter amount :");
 	amount= sc.nextInt();
 	PaybackCard p1=new PaybackCard(str[0],str[1],str[2],points,amount);
 	p1.printDetails();
}
private static void memberShipCard() {
	int rating;
	System.out.println("Enter the Card Details:");
	Scanner sc = new Scanner(System.in);
	String[] str = sc.nextLine().split("\\|");
	//System.out.println(str[0]);
	System.out.println("Enter the rating :");
 	rating=sc.nextInt();
 	
 	MembershipCard m1=new MembershipCard(str[0],str[1],str[2],rating);
 	m1.printDetails();
}
}