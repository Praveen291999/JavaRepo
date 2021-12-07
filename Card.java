package com.dnapass.training.java.day6.CardSamples;

public abstract class Card {
	String holderName;
	String cardNumber;
	String expiryDate;
	
	//getters and setters
	public String getHolderName() 
	{
		return holderName;
	}
	public void setHolderName(String holderName) 
	{
		this.holderName = holderName;
	}
	public String getCardNumber() 
	{
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() 
	{
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	//constructor
	public Card(String holderName, String cardNumber, String expiryDate) {
		this.setHolderName(holderName);
		this.setCardNumber(cardNumber);
		this.setExpiryDate(expiryDate);
	}
	public void printDetails() {
		System.out.println("Card Number "+this.getCardNumber());
	}
	
}