package com.dnapass.training.java.day5;      //Pangram Program
import java.util.Scanner;

//The quick Brown fox jumps over a Lazy Dog

public class PangramProgram 
{
	public static void main(String args[]){

		//Scanner is a class which read input from keyboard
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Your String:");

		//to read string end of line
		String str=sc.nextLine();

		// replaceALL()-->replaces all spaces between strings
		//toLowerCase()->method which converts all characters to lower case
		str=str.replaceAll("","").toLowerCase();

		// empty string
		String s="";

		// checking characters (a-z or A-Z)
		for(char i='a';i<='z';i++){

			//indexOf(char i)--> This method returns '-1' substring not found, if the position of substrings 'i' in 'str'
			if(str.indexOf(i)!=-1){

				s=s+i;// empty string+character
			}
		}
		// s.length()-->this method returns number or character of a string
		if(s.length()==26){
			System.out.println("Pangram");
		}
		else{
			System.out.println(" Not Pangram");
		}
	}
}