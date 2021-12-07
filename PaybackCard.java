package com.dnapass.training.java.day6.CardSamples;

public class PaybackCard extends Card{
	
	int pointsEarned;
	double totalAmount;
	 
	 //getter and setter
	public int getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	  
	//constructor
	 public PaybackCard(String holderName, String cardNumber, String expiryDate,int pointsEarned, double totalAmount) {
			super(holderName, cardNumber, expiryDate);
			// TODO Auto-generated constructor stub
			this.setPointsEarned(pointsEarned);
			this.setTotalAmount(totalAmount);
		}
	 public void printDetails() {
			System.out.println(super.getHolderName()+"'s paybackcard Details:\n");
			super.printDetails();
			System.out.println("Points Earned "+this.getPointsEarned()+"\nTotal Amount "+this.getTotalAmount());
		}
}