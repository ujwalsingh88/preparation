package com.java.preparation.util;

import java.util.Comparator;
import com.java.preparation.model.ComparatorObject;

public class SortByName implements Comparator<ComparatorObject>{

	@Override
	public int compare(ComparatorObject o1, ComparatorObject o2) {
		// TODO Auto-generated method stub
		return (o1.getName().compareTo(o2.getName()));
	}

}
