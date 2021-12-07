package com.dnapass.training.java.day8;  //append a txt to existing file

import java.io.*;

public class AppendExisting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 File file = new File("C:\\Users\\r-praveenkumar\\Sample.txt");

		 FileWriter fw=new FileWriter(file);
		 PrintWriter pw=new PrintWriter(fw);
		 pw.append("Wecome to India");
		 
		  // Creating an object of BufferedReader class
	     BufferedReader br = new BufferedReader(new FileReader(file));

	     // Declaring a string variable
	     String st;
	     while ((st = br.readLine()) != null)

	         // Print the string
	         System.out.println(st);
		 
		            
	}

}
