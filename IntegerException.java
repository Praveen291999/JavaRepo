package com.dnapass.training.java.day7;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class IntegerException{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		try {
			int int1=sc.nextInt();
			int int2=sc.nextInt();
			System.out.println(int1/int2);
		}
		catch(InputMismatchException e ){
			System.out.println(" type miss match");
		}
		catch(ArithmeticException e) {
			System.out.println(" Cannot divide by zero");	
		}
	}

}
