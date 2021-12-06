package com.dnapass.training.lambda;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class People {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthdate;
	Sex gender;
	String emailAddress;

	People(String nameArg, LocalDate birthdayArg, Sex genderArg, String emailAddressArg) {
		this.name = nameArg;
		this.birthdate = birthdayArg;
		this.gender = genderArg;
		this.emailAddress = emailAddressArg;
	}

	public int getAge() {
		return birthdate.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static int compareByAge(People a, People b) {
		return a.birthdate.compareTo(b.birthdate);
	}

	public static List<People> createRoster() {
		List<People> roster = new ArrayList<>();
		roster.add(new People("fred", IsoChronology.INSTANCE.date(1980, 6, 20), People.Sex.MALE, "fred@example.com"));
		roster.add(new People("jane", IsoChronology.INSTANCE.date(1990, 7, 15), People.Sex.FEMALE, "jane@example.com"));
		roster.add(
				new People("george", IsoChronology.INSTANCE.date(1901, 8, 13), People.Sex.MALE, "george@example.com"));
		roster.add(new People("bob", IsoChronology.INSTANCE.date(2000, 9, 12), People.Sex.MALE, "bob@example.com"));

		return roster;
	}

	public String printPeople() {
		return "People [ name = " + name + " bithdate = " + birthdate + " gender = " + gender + " emailAddress = "
				+ emailAddress + "]";
	}
}