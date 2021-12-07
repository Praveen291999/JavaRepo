package com.dnapass.training.java.shape;

public class Square extends Shape {
	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int radius) {
		this.side = radius;
	}

	public Square(String name, int side) {
		super(name);
		this.setSide(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.pow(this.getSide(), 2);
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());		
	}
}