package com.dnapass.training.java.day3;
import java.util.Scanner;

public class DisplayDays {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter a number from 1 to 7:");
	int day=s.nextInt();
	switch(day)
	{
	case 1:
		System.out.println("Today is sunday");
		break;
	case 2:
		System.out.println("Today is Monday");
		break;
	case 3:
		System.out.println("Today is Tuesday");
		break;
	case 4:
		System.out.println("Today is Wednesday");
		break;
	case 5:
		System.out.println("Today is Thursday");
		break;
	case 6:
		System.out.println("Today is Friday");
		break;
	case 7:
		System.out.println("Today is Saturday");
		break;
	default:
		System.out.println("Enter a Valid number");
	}
	
	}

}
