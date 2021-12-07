package com.dnapass.training.java.day5;
import java.util.Scanner;

public class FindSpecificValue 
{
	  public static void main(String[] args) 
	  {
		Scanner s=new Scanner(System.in);
		int[] num = {4, 9, 3, 7, 5};
		System.out.println("Enter the value to find:");
		int toFind=s.nextInt();
	    boolean found = false;

	    for (int n : num) {
	      if (n == toFind) {
	        found = true;
	        break;
	      }
	    }
	    
	    if(found)
	      System.out.println(toFind + " is found.");
	    else
	      System.out.println(toFind + " is not found.");
	  }
	}