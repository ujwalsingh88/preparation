package com.java.preparation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("deltaService")
public class DeltaService {

	private Logger logger = Logger.getLogger(DeltaService.class);
	
	public void deltaList() throws CustomException{
		
		List<Integer> data = new ArrayList<Integer>();
		
		data.add(25626);
		data.add(25757);
		data.add(24367);
		data.add(24267);
		data.add(16);
		data.add(100);
		data.add(2);
		data.add(7277);
		
		pintDeltaData(data);
	}

	private String pintDeltaData(List<Integer> data) {
		
		List<Integer> outputList = new ArrayList<Integer>();
		String output= data.get(0).toString();
		outputList.add(data.get(0));
		
		int escapeToken=-128;
		for(int i=0; i<data.size()-1;i++) {
			int diff= data.get(i+1)-data.get(i);
			if(diff>127 || diff<-127) {
				output= output+ " "+escapeToken;
				outputList.add(escapeToken);
			}
			output=output+" "+diff;
			outputList.add(diff);
		}
		System.out.println(output);
		return output;
	}
	
	
}
