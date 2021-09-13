package com.java.preparation.model;

public class OverridingChild2 extends OverridingParent{

	@Override
	public String  draw(){
		System.out.println("This is Child2");
		return "Child2";
	}
}
