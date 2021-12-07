package com.dnapass.training.java.shape;
public abstract class Shape {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public Shape(String name) {
		super();
		this.name = name;
	}

	public abstract double calculateArea();
	public abstract void printArea();
}