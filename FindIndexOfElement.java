package com.dnapass.training.java.day5;
import java.util.Scanner;

public class FindIndexOfElement {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int i;
	    int a[]= {3,6,7,9,2,5};
	    System.out.println("Enter the element to search:");
	    int F=s.nextInt();
	    for(i=0;i<a.length;i++)
	    {
	    	if(a[i]==F)
	    	{
	    		System.out.println("Element found at index:"+(i+1));
	    		break;
	    	}
	    }
	    if(i==a.length)
	    {
	    	System.out.println("Element not found");
	    	
	    }
	    
	    
	}

}
