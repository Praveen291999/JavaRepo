package com.dnapass.training.java.day5;            //sum and average of array elements
import java.util.Scanner;
                                                
public class SumOfArrayElem {

	public static void main(String[] args) 
	{
		int sum=0;
		double average;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of elements in array:");
		int n=s.nextInt();
		int a[]=new int[n];    //array 
		System.out.println("Enter the elements:");
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
			sum=sum+a[i];
		}
		System.out.println("Sum:"+sum);
		average=(float)sum/n;
		System.out.println("Average:"+average);
		

	}

}
