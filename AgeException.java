package com.dnapass.training.java.day7;
import java.util.Scanner;


public class AgeException {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player's name :");
		String name=sc.next();
		System.out.print("Enter player's age :");
		int age=sc.nextInt();
		invalidAgeRange(name,age);
	}
private static void invalidAgeRange(String name,int age) {
	try {
		if(age<18) {
			throw new CustomException("Age should be greater than 18.");
		}
		else {
			System.out.println(name + "\n"+age);
		}
	}
	catch(CustomException e){
		System.out.println(e);
	}
}
}

