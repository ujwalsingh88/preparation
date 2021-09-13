package com.java.preparation.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("overloadingService")
public class OverloadingService {
	
	private Logger logger = Logger.getLogger(OverloadingService.class);
	
	public int area(int side) throws CustomException{
		int area =side*side;
		System.out.println("Area is--" + area);
		return area;
	}
	
	public int area(int l, int b) throws CustomException{
		int area =l*b;
		System.out.println("Area is--" + area);
		return area;
	}
	
	public int area(String shape) throws CustomException{
		System.out.println("Area is--" + shape);
		return 0;
	}
	

}
