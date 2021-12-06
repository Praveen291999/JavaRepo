package com.dnapass.training.java.date;

import java.util.Calendar;

public class SnippetRunner {

	public static void main(String[] args) {

		//int year =2021;
		//int month=0;       //january   	
		//int date=1;
		
		Calendar cal=Calendar.getInstance();   //   default time zone		
		
		//get and diplay current date from calendar
		
		System.out.println();
		System.out.println("year:"+ cal.get(Calendar.YEAR));
		System.out.println("Month:"+ cal.get(Calendar.MONTH));
		System.out.println("Day:"+ cal.get(Calendar.DATE));
		System.out.println("Hour:"+ cal.get(Calendar.HOUR));
		System.out.println("Minute:"+ cal.get(Calendar.MINUTE));
		
	}
		

}
