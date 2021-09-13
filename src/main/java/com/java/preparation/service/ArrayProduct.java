package com.java.preparation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("arrayProduct")
public class ArrayProduct {
	
	private Logger logger = Logger.getLogger(ArrayProduct.class);
	
	public void arrayProduct() throws CustomException{
		int [] input = {1,2,3,4};
		productExceptSelf(input);
	}
	
	public int[] productExceptSelf(int[] nums) {
        int [] outputArray= new int[nums.length];
		for (int i=0; i<nums.length; i++)
        {
           int sum =1;
           for(int j=0; j<nums.length ; j++){
               if(i!=j){
                   sum=sum*nums[j];
               }
           }
            outputArray[i]=sum;
        }        
        return outputArray;
    }
}
