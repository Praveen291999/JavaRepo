package com.dnapass.training.java.day3;
import java.util.Scanner;
public class VowelOrConsonant
{

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a Character:");
		char ch=s.next().charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch== 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
		{
			System.out.println(ch +" is a Vowel");
		}
		else
		{
			System.out.println(ch +" is a Consonant");
		}
	}

}
