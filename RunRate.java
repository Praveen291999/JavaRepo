package com.dnapass.training.java.day7;

import java.util.Scanner;
import java.io.*;

public class RunRate {
	static void Divide(int a) {
		Scanner s = new Scanner(System.in);
		int div;

		try {
			System.out.println("Enter the total runs scored");
			int run = s.nextInt();
			System.out.println("Enter the total overs faced");
			int over = s.nextInt();
			div = run / over;
			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		Divide(a - 1);
	}

	public static void main(String[] args) {

		Divide(3);
	}
}