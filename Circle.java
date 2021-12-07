package com.dnapass.training.java.shape;

import java.util.Scanner;

public class Circle extends Shape {

	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle(String name, int radius) {
		super(name);
		this.setRadius(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(this.getRadius(), 2);
	}
	@Override
	public void printArea() {
		System.out.format("Area of "+super.getName()+" is %.2f\n",this.calculateArea());
	}

}
