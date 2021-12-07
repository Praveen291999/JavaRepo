package com.dnapass.training.java.shape;

public class Rectangle extends Shape {
	private int length;
	private int breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public Rectangle(String name, int length, int breadth) {
		super(name);
		this.setBreadth(breadth);
		this.setLength(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return this.getLength() * this.getBreadth();
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());
	}
}