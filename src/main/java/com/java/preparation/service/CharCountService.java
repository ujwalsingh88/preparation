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

@Service("charCountService")
public class CharCountService {

	private Logger logger = Logger.getLogger(CharCountService.class);
	
	public void characterCount() throws CustomException{
		
		String data= "This is the thty";
		findCount(data);
	}

	private List <String> findCount(String data) {
		data=data.toLowerCase();
		List sortedList=new ArrayList<String>();
		HashMap<String,Integer> charCountMap= new HashMap<String,Integer>();
		
		char [] charArray =data.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			String character=Character.toString(charArray[i]);
			if(charCountMap.containsKey(character)) {
				int count=charCountMap.get(character)+1;
				charCountMap.put(character, count);
			}else {
				charCountMap.put(character, 1);
			}
		}
		
		List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(charCountMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()>o1.getValue()?1:-1);
            }
        });
		
		String [] sortedArray = new String [list.size()];
		int position =0;
		for (Map.Entry<String, Integer> aa : list) {
			sortedArray[position]= aa.getKey();
			sortedList.add(aa.getKey());
			position++;
		}
		return sortedList;
		
	}
}
