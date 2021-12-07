package com.dnapass.training.java.day7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss ");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
	}
}

//System.out.println(java.time.LocalDateTime.now());  without formatting