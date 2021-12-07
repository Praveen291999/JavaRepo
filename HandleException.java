package com.dnapass.training.java.day7;

import java.util.Scanner;
import java.io.*;

public class HandleException {
	static void Divide(int a) {
		Scanner s = new Scanner(System.in);
		int div;
		int value1 = s.nextInt();
		if (a > 0) {
			try {
				int value2 = s.nextInt();
				div = value1 / value2;
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e);
			} catch (ArithmeticException e) {
				System.out.println(e);
			}
		}
	}
}