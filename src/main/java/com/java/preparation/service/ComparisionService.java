package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.java.preparation.model.ComparatorObject;
import com.java.preparation.util.SortById;
import com.java.preparation.util.SortByName;
import com.java.preparation.exception.CustomException;
import com.java.preparation.model.ComparableObject;

@Service("comparisionService")
public class ComparisionService {

	private Logger logger = Logger.getLogger(ComparisionService.class);
	
	public void Comparable1() throws CustomException {
		try {
			List <ComparableObject> list= new ArrayList<ComparableObject>();
			list.add(new ComparableObject(5, "ABC", 7));
			list.add(new ComparableObject(1, "EFG", 7));
			list.add(new ComparableObject(3, "Def", 7));
			Collections.sort(list);
			for(ComparableObject o: list) {
				System.out.println(o.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomException(e);
		}
		
		
	}
	
	public void Comparator1() throws CustomException {
		try {
			List <ComparatorObject> list= new ArrayList<ComparatorObject>();
			list.add(new ComparatorObject(5, "ABC", 7));
			list.add(new ComparatorObject(1, "EFG", 7));
			list.add(new ComparatorObject(3, "Def", 7));
			Collections.sort(list, new SortById());
			for(ComparatorObject o: list) {
				System.out.println(o.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomException(e);
		}
		
		
	}
	public void Comparator2() throws CustomException {
		try {
			List <ComparatorObject> list= new ArrayList<ComparatorObject>();
			list.add(new ComparatorObject(5, "FHGJ", 7));
			list.add(new ComparatorObject(1, "EFG", 7));
			list.add(new ComparatorObject(3, "ABC", 7));
			Collections.sort(list,new SortByName());
			for(ComparatorObject o: list) {
				System.out.println(o.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomException(e);
		}
		
		
	}
}
