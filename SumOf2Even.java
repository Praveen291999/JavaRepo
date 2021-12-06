package com.dnapass.training.java.day3;
import java.util.Scanner;
public class SumOf2Even {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int evenNumCount=0,sum=0;
		
		do
		{
			System.out.println("Enter the number:");
			int num=s.nextInt();
			if(num%2==0)
			{
				evenNumCount++;
				sum=sum+num;
			}
			
		}while(evenNumCount<2);
		System.out.println("Sum of first 2 even numbers:"+sum);
	}

}
