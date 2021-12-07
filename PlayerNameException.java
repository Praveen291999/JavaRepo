package com.dnapass.training.java.day7; //Player name nad player age exception

import java.util.Scanner;
import java.io.*;

class CustomException extends Exception {
	public CustomException(String s) {
		super(s);
	}
}

public class PlayerNameException {
	static void Divide(int a) throws CustomException {
		Scanner s = new Scanner(System.in);
		int div;
		System.out.println("Enter Player name:");
		String name = s.nextLine();
		System.out.println("Enter enter player age:");
		int age = s.nextInt();
		if (a > 1) {
			if (age < 19) {
				throw new CustomException("InValidAgeRangeExeception");
			} else {
				System.out.println(name);
				System.out.println(age);
			}
		} else {

			System.exit(0);
		}

		Divide(a - 1);

	}

	public static void main(String[] args) {
		try {
			Divide(3);
		} catch (CustomException e) {
			System.out.println("customException " + e);
		}

	}
}
