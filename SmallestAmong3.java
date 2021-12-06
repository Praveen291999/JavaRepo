package com.dnapass.training.java.day3;

import java.util.Scanner;

public class SmallestAmong3 {

		 public static void main(String[] args)
		    {
		        Scanner in = new Scanner(System.in);
		        System.out.print("Enter the 1st number: ");
		        int x = in.nextInt();
		        System.out.print("Enter the 2nd number: ");
		        int y = in.nextInt();
		        System.out.print("Input the 3rd number: ");
		        int z = in.nextInt();
		        System.out.print("The smallest value is " + smallest(x,y,z)+"\n" );
		    }

		   public static int smallest(int x, int y, int z)
		    {
		        return Math.min(Math.min(x, y), z);
		    }
		}