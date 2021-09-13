package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("meandringArrayService")
public class MeandringArrayService {

	private Logger logger = Logger.getLogger(MeandringArrayService.class);
	
	public void sorting () throws CustomException{
		int[] intArray = new int[]{ 7,8,3,5,38,37 };
		meanderingSorting(intArray);
	}
	
	private int[] meanderingSorting(int[] inputArray) {
		List<Integer> unsorted = new ArrayList<Integer>();
		for(int number : inputArray) {
			unsorted.add(number);
		}
		int[] outputArray = new int[unsorted.size()];
		List<Integer> outputList = new ArrayList<Integer>();
		boolean findLargest = true;
        int loopCount = unsorted.size();
        for(int i=0;i<loopCount;i++){
            Integer finalNumber =unsorted.get(0);
            int index=0;
            if(findLargest){
                for (int k=0;k<unsorted.size();k++) {
                    if(unsorted.get(k)>finalNumber){
                      finalNumber=unsorted.get(k);  
                      index=k;
                    }
                }
            }else{
                for (int k=0;k<unsorted.size();k++) {
                    if(unsorted.get(k)<finalNumber){
                      finalNumber=unsorted.get(k); 
                      index=k; 
                    }
                }
            }
            outputArray[i]=finalNumber;
            outputList.add(finalNumber);
            unsorted.remove(index);
            finalNumber=0;
            index=0;
            findLargest=!findLargest;
        }
        System.out.println(outputArray);
        return outputArray;
		
	}
	
}
