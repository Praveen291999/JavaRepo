package com.dnapass.training.java.day8;
                                              //write and read txt from file
import java.io.*;

public class ReadWritePlainTxt {

 public static void main(String[] args) throws Exception
 {
	 File file = new File("file1.txt");
	 FileWriter fw=new FileWriter(file);
	 PrintWriter pw=new PrintWriter(fw);
	 
	 pw.append("Welcome to java Programming");
	 pw.append(" Welcome to python Programming");
	 pw.close();
	 
	  // Creating an object of BufferedReader class
     BufferedReader br = new BufferedReader(new FileReader(file));

     // Declaring a string variable
     String st;
     while ((st = br.readLine()) != null)

         // Print the string
         System.out.println(st);
 	}
}