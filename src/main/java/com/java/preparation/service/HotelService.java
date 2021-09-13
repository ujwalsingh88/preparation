package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("hotelService")
public class HotelService {

	private Logger logger = Logger.getLogger(HotelService.class);
	
	public void hotelRanking() throws CustomException{   
		int [] ids = new int[]{1,2,1,3,2,4,2,1,3,4};
		String [] reviews = new String [] {"This is good", "This is nice" , "Room small", "Too far","Very spacious", 
							"close to Station","Very dirty", "small clean" , "nothing", "nothing"};
		//1 --2P,2N=4   2--2P,1N=5       3--1N=-1     , 4--1P=3
		String [] positiveWords = new String [] {"good","nice","spacious","close","clean"};
		String [] negativeWords = new String [] {"small", "far", "dirty"};
		ranking(ids,reviews,positiveWords,negativeWords);
	}
	
	private int[] ranking (int [] ids, String[] reviews, String []positiveWords, String []negativeWords) {
		List <Integer> rankedHotelList=new ArrayList<Integer>();
		HashMap<Integer, List<String>> idReviewMap= new HashMap<Integer, List<String>>();
		HashMap<Integer, Integer> idScoreMap= new HashMap<Integer, Integer>();
		for (int i =0; i<ids.length; i++) {
			if(idReviewMap.containsKey(ids[i])) {
				idReviewMap.get(ids[i]).add(reviews[i].toLowerCase());
			}else {
				List <String> reviewsList=new ArrayList<String>();
				reviewsList.add(reviews[i].toLowerCase());
				idReviewMap.put(ids[i],reviewsList);
			}
		}
		
		for (Map.Entry<Integer, List<String>> entry : idReviewMap.entrySet()) {
			int score = 0;
		    Integer key = entry.getKey();
		    List<String> reviewValues = entry.getValue();
		    for(String reviewValue: reviewValues) {
		    	for(int j=0;j<positiveWords.length;j++) {
		    		if(reviewValue.contains(positiveWords[j].toLowerCase())) {
		    			score=score+3;
		    		}
		    	}
		    	for(int k=0;k<negativeWords.length;k++) {
		    		if(reviewValue.contains(negativeWords[k].toLowerCase())) {
		    			score=score-1;
		    		}
		    	}
		    }
		    idScoreMap.put(key,score);
		}
		
		List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(idScoreMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
		int [] rankedHotelArray = new int [list.size()];
		int position =0;
		for (Map.Entry<Integer, Integer> aa : list) {
			rankedHotelArray[position]= aa.getKey();
			rankedHotelList.add(aa.getKey());
			position++;
		}
		System.out.println(rankedHotelList);
		return rankedHotelArray;
		
	}
	
}





