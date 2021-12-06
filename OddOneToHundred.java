package com.dnapass.training.java.day3;

public class OddOneToHundred
{
public static void main(String[] args) 
{
		int i=1;
		do
		{
			if(i%2!=0)
			{
				System.out.println("Odd Number:"+i);
			}
			i++;
		}while(i<=100);

	}

}
