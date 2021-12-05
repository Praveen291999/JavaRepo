package com.dnapass.training.java.day1;
import java.util.Scanner;

public class Averageofnumbers {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

	    double num1,num2,num3,sum;
	   
	    System.out.print("Enter three numbers: ");
	    num1 = scan.nextDouble();
	    num2 = scan.nextDouble();
	    num3 = scan.nextDouble();

	  
	    sum = (num1 + num2 + num3)/3;
	    

	    
	    System.out.println("Average: " + sum );
	  }
	
	}


