package com.dnapass.training.java.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LongWordInFile {

	public static void main(String[] args) throws FileNotFoundException {
		LongWordInFile obj=new LongWordInFile();
		obj.findLongestWord();
		
		
	}
	
	public String findLongestWord() throws FileNotFoundException {
		String longestWord="";
		String current;
		Scanner s=new Scanner(new File("C:\\Users\\r-praveenkumar\\Sample.txt"));
		
		while(s.hasNext())
		{
			current=s.next();
			if(current.length()>longestWord.length())
			{
				longestWord=current;
			}
		}
		System.out.println("The Longest Word:"+longestWord);
		return longestWord;
		
		
	}

}
