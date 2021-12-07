package com.dnapass.training.java.day5;    //replace all the 'd' occurrence characters with ‘h’ .

public class ReplaceString 
{
    
	   public static void main(String[] args)
	    {
	        String str = "dog is a animal";
	        String new_str = str.replace('d', 'h');
	        System.out.println("Original string: " + str);
	        System.out.println("New String: " + new_str);
	    }
	}