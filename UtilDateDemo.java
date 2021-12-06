package com.dnapass.training.java.date;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class UtilDateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year =2021;
		int month=0;            //january
		int date=1;
		
		Calendar cal=Calendar.getInstance();   //default time zone		
		
		//get and diplay current date from calendar
		
		System.out.println("year:"+ cal.get(Calendar.YEAR));
		System.out.println("Month:"+ cal.get(Calendar.MONTH));
		System.out.println("Day:"+ cal.get(Calendar.DATE));
		System.out.println("Hour:"+ cal.get(Calendar.HOUR));
		System.out.println("Minute:"+ cal.get(Calendar.MINUTE));
		System.out.println();
		
		cal.clear();
		System.out.println();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DATE,date);
		System.out.println(cal.getTime());
		
		cal=Calendar.getInstance();
		System.out.println();
		System.out.println("Current date and time:"+cal.getTime());
		int actualMaxYear=cal.getActualMaximum(Calendar.YEAR);
		int actualMaxMonth=cal.getActualMaximum(Calendar.YEAR);
		int actualMaxWeek=cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
		int actualMaxDate=cal.getActualMaximum(Calendar.DATE);
		
		//max year
		System.out.println("Actual Max year:"+actualMaxYear);
		System.out.println("Actual Max month:"+actualMaxMonth);
		System.out.println("Actual Max Week of the year:"+actualMaxWeek);
		System.out.println("Actual Max date:"+actualMaxDate);
		System.out.println();
		
		System.out.println("Current date and time:"+cal.getTime());
		int actualMinYear=cal.getActualMinimum(Calendar.YEAR);
		int actualMinMonth=cal.getActualMinimum(Calendar.YEAR);
		int actualMinWeek=cal.getActualMinimum(Calendar.WEEK_OF_YEAR);
		int actualMinDate=cal.getActualMinimum(Calendar.DATE);
		//min year
		System.out.println("Actual Min year:"+actualMinYear);
		System.out.println("Actual Min month:"+actualMinMonth);
		System.out.println("Actual Min Week of the year:"+actualMinWeek);
		System.out.println("Actual Min date:"+actualMinDate);
		System.out.println();
		
		Calendar calNewYork = Calendar.getInstance();
		calNewYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println();
		System.out.println("Time in New York: " + calNewYork);
		System.out.println("Time in New York: " + calNewYork.get(Calendar. HOUR_OF_DAY) + ":"
		+ calNewYork.get(Calendar.MINUTE) + ":" + calNewYork.get (Calendar.SECOND));
		System.out.println();
		
		Calendar now = Calendar.getInstance();
		System.out.println();

		System.out.println("Current full date and time is :"+(now.get(Calendar.MONTH) + 1) + "-"
				+ now.get (Calendar.DATE) + "-" + now.get(Calendar.YEAR) +""+now.get(Calendar.HOUR_OF_DAY) + ":"
				+ now.get(Calendar.MINUTE) + ":" + now.get (Calendar. SECOND)+ "." + now.get(Calendar.MILLISECOND));
		System.out.println();
		
		// Gets a calendar using the default time zone and locale. 
		Calendar calendar= Calendar.getInstance();
		System.out.println();
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println();

		cal = Calendar.getInstance();
		// cal.setTime (date);
		System.out.println();
		//cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
		System.out.println(cal.getTime());
		System.out.println();
		
		int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println();
		System.out.println("Number of days of thr current month:"+days);
		
		// Localize in German
		DateFormatSymbols symbols= new DateFormatSymbols(new Locale("de"));
		// for the current Locale :
		// DateFormatSymbols symbols = new DateFormatSymbols();
		String[] dayNames= symbols.getWeekdays();
		for (String s :dayNames) {
			System.out.print(s + "\n");
			System.out.println();
		}

		// two weeks
		int noOfDays = 14;
		cal = Calendar.getInstance();
		java.util.Date cdate=cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, noOfDays);
		java.util.Date datel = cal.getTime();
		System.out.println("\nCurrent Date: " + cdate + "\n"); 
		System.out.println("Day after two weeks:" + datel + "\n");
		
		cal=Calendar.getInstance();
		cdate=cal.getTime();
		//get next year
		cal.add(Calendar.YEAR,1);
		java.util.Date nyear=cal.getTime();
		//get previous year
		
		cal.add(Calendar.YEAR,-1);
		java.util.Date pyear=cal.getTime();
		System.out.println("Current Date:"+cdate);
		System.out.println("Date after 1 year"+nyear);
		System.out.println("Date before 1 year"+pyear);
		
		//year to leap year or not

		year = 2016;
		System.out.println();

		if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) 
			System.out.println("Year"+ year +" is a leap year");

		else
			System.out.println("Year "+year + " is not a leap year");

		cal = new GregorianCalendar(); 
		
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		System.out.println("\n"+cal.getTime()+"\n");
		try {

		String originalString = "2016-07-14 09:00:02";
		java.util.Date date12 = new SimpleDateFormat("yyyy-MM-dd HH: mm:ss").parse(originalString); 
		String newstr = new SimpleDateFormat("MM/dd/yyyy, H:mm:ss").format(date12); 
		System.out.println("\n"+newstr+"\n");
		}
		catch(ParseException e) {
		//Handle exception here 
		e.printStackTrace();
		}

		//Unix seconds
		long unix_seconds= 1372339860;
		//convert seconds to milliseconds
		Date date12 =new Date(unix_seconds*1000L); 
		// format of the date
		SimpleDateFormat jdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_2"); jdf.setTimeZone (TimeZone.getTimeZone("GMT-4"));
		String java_date= jdf.format(date12);
		System.out.println("\n"+java_date+"\n");

	}

}
