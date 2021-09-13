package com.java.preparation.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("sumFinderService")
public class SumFinderService {

	private Logger logger = Logger.getLogger(SumFinderService.class);
	
	public void findSumExists() throws CustomException{
		
		int [] intArray = new int[] {66,10,18,12,21,28,31,39,6,55,60,62};
		sumFinder(intArray);
	}

	private int sumFinder(int[] intArray) {
		int found=0;
		//List<Integer> nos = new ArrayList<Integer>();
		for(int i=2; i<intArray.length;i++) {
			
			for(int j= i+1;j<intArray.length;j++) {
				if(intArray[i]+intArray[j]==intArray[0]) {
					System.out.println(intArray[i] +"&"+intArray[j]+"=" +intArray[0]);
					found=1;
					break;
				}else {
					System.out.println(intArray[i] +"&"+intArray[j]+" not equals " +intArray[0]);
				}
			}
			if(found==1) {
				break;
			}
		}
		
		
		return found;
		
	}
}
