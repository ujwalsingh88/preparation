package com.java.preparation.model;

public class Circle implements FactoryShapeParent {

	private int radius;
	
	
	public Circle(int radius) {
		super();
		this.radius=radius;
	}
	
	@Override
	public void calculateArea() {
		System.out.println("Area of cicle is --"+Math.PI*this.radius*this.radius);
	}

	@Override
	public void calculateCircumference() {
		System.out.println("Circum of cicle is --"+Math.PI*this.radius*2);
	}

}
