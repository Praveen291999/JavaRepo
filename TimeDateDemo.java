package com.dnapass.training.java.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Formatter;
import java.util.Locale;
public class TimeDateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate l_date = LocalDate.now(); 
		System.out.println("Current date: " +l_date);
		
		LocalTime l_time= LocalTime.now();
		System.out.println("Current time:" + l_time);

		YearMonth ym =YearMonth.of (2016, 9);

		String firstDay = ym. atDay (1).getDayOfWeek ().name(); 
		String lastDay = ym. atEndOfMonth().getDayOfWeek (). name();

		System.out.println();

		System.out.println(firstDay);
		System.out.println(lastDay);

		System.out.println();

		LocalTime time = LocalTime.now();
		System.out.println();

		// in hour, minutes, seconds, nano seconds
		System.out.println("Local time now: " + time);

		time = LocalTime.now();

		// adding four hours
		LocalTime newTime = time.plusHours (4);
		System.out.println();
		System.out.println("Time after 4 hours :"+ newTime);
		LocalDate today = LocalDate.now();

		LocalDate userday = LocalDate.of(2015, Month.MAY, 15);
		Period diff = Period.between(userday, today);
		System.out.println("\nDifference between "+ userday +" and "+ today + diff.getYears ()
		+" Year(s) and "+ diff.getMonths () +" Month()s\n");
		
		Instant timestamp = Instant.now();
		System.out.println("\nCurrent Timestamp:" + timestamp+"\n");

		today = LocalDate.now();
		System.out.println("\nCurrent Date: "+today);
		LocalDate plusDays = today.plusDays (10);
		System.out.println("10 days after today will be "+plusDays+"\n");
		System.out.println("10 days before today will be "+plusDays.plusDays (-20));
		
		
		today = LocalDate.now();
		LocalDate lastDayOfYear= today.with(TemporalAdjusters.lastDayOfYear());
		Period period = today.until(lastDayOfYear);
		System.out.println();
		System.out.println("Months remaining in the year: "+period.getMonths());

		//Current year
		Year yr = Year.now();
		//given year
		//Year yr = Year.of (2001);
		System.out.println("\nCurrent Year:" + yr);
		
		boolean isLeap = yr.isLeap(); // false 
		System.out.println("Is current year leap year?" + isLeap);
		int length = yr.length(); // 365 
		System.out.println("Length of the year:" + length+" days\n");

		// information about the month
		LocalDate ldt = LocalDate.of (2016, Month.FEBRUARY, 10); 
		Month mn = ldt.getMonth(); // FEBRUARY
		int mnIntValue = mn.getValue(); // 2 
		int minLength = mn.minLength(); // 28
		int maxLength = mn.maxLength(); // 29
		Month firstMonthOfQuarter = mn. firstMonthOfQuarter (); // JANUARY System.out.println("\nInteger value of the current month: " + mnIntValue);
		System.out.println("Length of the month: " + minLength);
		System.out.println("Maximum length of the month: " + maxLength);
		System.out.println("First month of the Quarter: "+firstMonthOfQuarter+"\n");
		
		time = LocalTime.of(12, 24, 32); 
		int hour = time.getHour();
		int minute = time.getMinute();
		int second= time.getSecond();
		System.out.println("\nCurrent Local time: " + time);
		System.out.println("Hour:" + hour);
		System.out.println("Minute:" + minute); 
		System.out.println("Second: "+second+"\n");
		
		// Before 7 houres and 30 minutes 
		LocalDateTime dateTime = LocalDateTime.now().minusHours (7).minusMinutes (30);
		System.out.println("\nCurrent Date and Time: "+ LocalDateTime.now()); 
		System.out.println("Before 7 hours and 30 minutes: " + dateTime+"\n");
		
		String string = "May 1, 2016";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(string, formatter);
		System.out.println();
		System.out.println(date);
		System.out.println();

		LocalDate pdate = LocalDate.of(2012, 01, 01); 
		LocalDate now = LocalDate.now();

		diff = Period.between(pdate, now);

		System.out.printf("\nDifference is %d years, %d months and %d days old\n\n", 
				diff.getYears(), diff.getMonths(), diff.getDays ());

		dateTime= LocalDateTime.of(2016, 9, 16, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.now();
		int diffInNano = java.time. Duration.between(dateTime, dateTime2).getNano();
		long diffInSeconds = java.time.Duration.between (dateTime, dateTime2).getSeconds();
		long diffInMilli = java.time.Duration.between (dateTime, dateTime2).toMillis();
		long diffInMinutes = java.time.Duration.between (dateTime, dateTime2).toMinutes();
		long diffinHours = java.time.Duration.between(dateTime, dateTime2).toHours();
		System.out.printf("\nDifference is %d Hours, %d Minutes, %d Milli, %d Seconds and %d Nano\n\n",
				diffinHours, diffInMinutes, diffInMilli, diffInSeconds, diffInNano );


		// date of birth 
		pdate = LocalDate.of(1989, 04, 11);

		// current date
		now = LocalDate.now();

		// difference between current date and date of birth
		diff = Period.between (pdate, now);
		System.out.printf("\nI am %d years, %d months and %d days old.\n\n", diff.getYears(), diff.getMonths (), diff.getDays ());

		LocalDate dt = LocalDate.now();
		System.out.println("\nNext Friday: "+dt.with (TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		System.out.println("Previous Friday: "+dt.with(TemporalAdjusters.previous (DayOfWeek. FRIDAY))+"\n");
	}

}
