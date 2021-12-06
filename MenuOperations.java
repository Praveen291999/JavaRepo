package com.dnapass.training.java.day3;
import java.util.Scanner;
public class MenuOperations {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the 1st number:");
		int num1=s.nextInt();
		System.out.println("Enter the 2st number:");
		int num2=s.nextInt();
		System.out.println("Enter Your Choice:\n1.Add\n2.Sub\n3.mul\n4.Div");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println(num1+num2);
			break;
		case 2:
			System.out.println(num1-num2);
			break;
		case 3:
			System.out.println(num1*num2);
			break;
		case 4:
			System.out.println(num1/num2);
			break;
		default:
			System.out.println("Enter a valid Number");
			
		}
		
		
	}

}
