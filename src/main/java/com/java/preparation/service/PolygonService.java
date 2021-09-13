package com.java.preparation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("polygonService")
public class PolygonService {

	private Logger logger = Logger.getLogger(PolygonService.class);
	
	public void findShapeCount() throws CustomException{
		List <String> data = new ArrayList<String>();
		data.add("36 30 36 30");
		data.add("15 15 15 15");
		data.add("46 96 90 100");
		data.add("86 86 86 86");
		data.add("100 200 -100 200");
		data.add("-100 200 -100 200");
		findPolygonCount(data);
		
	}

	private String findPolygonCount(List<String> data) {
		String output = "";
		int squareCount=0;
		int rectangleCount=0;
		int polygonCount=0;
		
		for(String sides:data) {
			String[] allSides= sides.split(" ");
			int a = Integer.parseInt(allSides[0]);
			int b = Integer.parseInt(allSides[1]);
			int c = Integer.parseInt(allSides[2]);
			int d = Integer.parseInt(allSides[3]);
			
			if((a==b && b==c && c==d) && a>0) {
				squareCount++;
			}else if((a==c && b==d) && (a>0 &&c>0)) {
				rectangleCount++;
			}else {
				polygonCount++;
			}
			
		}
		
		output = squareCount +" "+rectangleCount+" "+polygonCount;
		System.out.println(output);
		return output;
		
	}
}
