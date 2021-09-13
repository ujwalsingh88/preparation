package com.java.preparation.model;

public class ComparatorObject {

	private int id;
	private String name;
	public int rank;
	
	public ComparatorObject(int id, String name, int rank) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}
	
	
}
