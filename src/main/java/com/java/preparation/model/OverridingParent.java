package com.java.preparation.model;

import java.io.FileNotFoundException;

public class OverridingParent {

	public String  draw() throws FileNotFoundException{
		System.out.println("This is Parent");
		return "Parent";
	}
	
}
