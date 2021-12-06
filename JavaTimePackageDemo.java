package com.dnapass.training.java.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;



public class JavaTimePackageDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%s%n", DayOfWeek.MONDAY.plus (3));
		DayOfWeek dow = DayOfWeek.MONDAY;
		Locale locale = Locale.getDefault();
		System.out.println(dow.getDisplayName (TextStyle. FULL, locale));
		System.out.println(dow.getDisplayName (TextStyle.NARROW, locale)); System.out.println(dow.getDisplayName (TextStyle.SHORT, locale));
		
		
		System.out.printf("%d%n", Month.FEBRUARY. maxLength());
		
		Month month = Month.AUGUST;
		locale= Locale.getDefault();
		System.out.println(month.getDisplayName (TextStyle. FULL, locale));
		System.out.println(month.getDisplayName (TextStyle. NARROW, locale));
		System.out.println(month.getDisplayName (TextStyle. SHORT, locale));

		LocalDate date= LocalDate.of (2000, Month.NOVEMBER, 20);
		LocalDate nextwed = date.with (TemporalAdjusters.next(DayOfWeek. WEDNESDAY));

		DayOfWeek dotw= LocalDate.of(2012,Month.JULY, 9).getDayOfWeek();

		// The following example uses a TemporalAdjuster to retrieve the first wednesday
		// after a specific date.

		date= LocalDate.of(2000, Month.NOVEMBER, 20);
		TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek. WEDNESDAY);
		nextwed = date.with(adj);
		
		System.out.printf("For the date of %s, the next Wednesday is %s.%n", date, nextwed);

		YearMonth date4 = YearMonth.now();
		System.out.printf("%s: %d%n", date4, date4.lengthOfMonth());
		
		YearMonth date2 = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

		YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());

		// Is February 29 is valid for the year 2018?

		MonthDay date5 = MonthDay.of (Month. FEBRUARY, 29);
		boolean validLeapYear =date5.isValidYear (2010);

		validLeapYear = Year.of(2012).isLeap();
		LocalTime thisSec;

		for (int i = 0; i <10; i++)
		{
			thisSec = LocalTime.now();

		// implementation of display code is left to the reader System.out.printf("%d:%d: %d", thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());

		}

		System.out.printf("now: %s %n", LocalDateTime.now());

		System.out.printf("Apr 15, 1994 @ 11:30am: %s%n", LocalDateTime.of (1994, Month.APRIL, 15, 11, 30));

		System.out.printf("now (from Instant): %s%n", LocalDateTime.ofInstant (Instant.now(), ZoneId.systemDefault()));

		System.out.printf("6 months from now: %s%n", LocalDateTime.now().plusMonths (6));
		
		System.out.printf("Apr 15, 1994 @ 11:30am: %s%n", LocalDateTime.of (1994, Month.APRIL, 15, 11, 30));

		System.out.printf("now (from Instant): %s%n", LocalDateTime. ofInstant (Instant.now(), ZoneId. systemDefault()));

		System.out.printf("6 months from now: %s%n", LocalDateTime.now().plusMonths (6));

		System.out.printf("6 months ago: %s%n", LocalDateTime.now().minusMonths (6));
		
		Set<String> allZones = ZoneId.getAvailableZoneIds(); 
		
		LocalDateTime dt = LocalDateTime.now();
		// Create a List using the set of zones and sort it.
		List<String> zonelist = new ArrayList<String>(allZones);
		Collections.sort(zonelist);
		
		for (String s: zonelist) 
		{
			ZoneId zone = ZoneId.of(s);
			ZonedDateTime zdt = dt.atZone (zone); 
			ZoneOffset offset=zdt.getOffset();
			int secondsOfHour = offset.getTotalSeconds() % (60*60);
			String out = String.format("55  s%n", zone, offset);
			
			// write only time zones that do not have a whole hour offset

			// to standard out.

			if (secondsOfHour != 0) {
				System.out.printf(out);
			}
		}
		

	}

}
