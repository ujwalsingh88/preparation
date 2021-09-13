package com.java.preparation.model;

public class Rectangle implements FactoryShapeParent {

	private int length;
	private int breadth;
	
	
	
	public Rectangle(int length, int breadth) {
		super();
		this.breadth=breadth;
		this.length=length;
	}
	
	@Override
	public void calculateArea() {
		System.out.println("Area of Rectangle is --"+this.length*this.breadth);
	}

	@Override
	public void calculateCircumference() {
		System.out.println("Area of cicle is --"+2*(this.length+this.breadth));
	}

}
