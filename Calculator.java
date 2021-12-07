package com.dnapass.training.java.day6;

import java.util.Scanner;

public class Calculator implements AdvancedArithmetic{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value: ");
		int value = sc.nextInt();
	
			System.out.println(divisor_sum(value));

}

	public static int divisor_sum(int value) {
		
		int sum=0;
		for(int i=1;i<value+1;i++) {
			if(value%i==0)
				sum+=i;
		}
		return sum;
	}
	
	
}