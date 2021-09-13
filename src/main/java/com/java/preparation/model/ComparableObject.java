package com.java.preparation.model;

public class ComparableObject implements Comparable<ComparableObject>{

	private int id;
	private String name;
	public int rank;
	
	public ComparableObject(int id, String name, int rank) {
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

	@Override
	public int compareTo(ComparableObject o) {
		// TODO Auto-generated method stub
		return (this.id>o.getId()?-1:1);
	}
}
