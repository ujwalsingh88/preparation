package com.java.preparation.util;

import java.util.Comparator;

import com.java.preparation.model.ComparatorObject;

public class SortById implements Comparator<ComparatorObject>{

	@Override
	public int compare(ComparatorObject o1, ComparatorObject o2) {
		// TODO Auto-generated method stub
		return (o1.getId()>o2.getId()?-1:1);
	}

}
