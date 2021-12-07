package com.dnapass.training.java.day6.CardSamples;

public class MembershipCard extends Card{

	int rating;

	//getter and setter
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	//Constructor
	public MembershipCard(String holderName, String cardNumber, String expiryDate,int rating) {
		super(holderName, cardNumber, expiryDate);
		this.setRating(rating);
	}
	public void printDetails() {
		System.out.println(super.getHolderName()+"'s Membershipcard Details:\n");
		super.printDetails();
		System.out.println("Rating "+this.getRating());
	}
}