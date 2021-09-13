package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("anagramService")
public class AnagramService {

	
	private Logger logger = Logger.getLogger(AnagramService.class);
	
	public void checkAnagram() throws CustomException{
		List <String> data = new ArrayList<String>();
		data.add("pear");
		data.add("amleth");
		data.add("dormitory");
		data.add("tinsel");
		data.add("dirty room");
		data.add("hamlet");
		data.add("listen");
		data.add("silnet");
		
		anagramFind(data);
		
	}

	private List <String> anagramFind(List<String> data) {
		List <String> outputData = new ArrayList<String>();
		List <String> consideredWords=new ArrayList<String>();
		for(int i=0; i<data.size();i++) {
			if(!consideredWords.contains(data.get(i).toLowerCase())) {
				List<String> outputAnagram =new ArrayList<String>();
				outputAnagram.add(data.get(i).toLowerCase());
				String source= data.get(i).toLowerCase();
				char[] sourceCharacters = source.toCharArray();
				for(int j=i+1;j<data.size();j++) {
					String destination = data.get(j).toLowerCase();
					StringBuilder modifiedWord =  new StringBuilder(data.get(j).toLowerCase());
					
					
					for(int k=0; k<sourceCharacters.length;k++) {
						
						if(!Character.isWhitespace(sourceCharacters[k])) {
							char[] destinationCharacters = modifiedWord.toString().toCharArray();
							for(int l=0; l<destinationCharacters.length;l++) {
								if(Character.compare(sourceCharacters[k], destinationCharacters[l])==0) {
									
									int index=modifiedWord.toString().indexOf(destinationCharacters[l]);
									System.out.println(source+"@@"+destination+"@@"+modifiedWord+"@@"+l+"@@"+index);
									modifiedWord.deleteCharAt(index);
								}
							}
						}
						
					}
					
					if("".equalsIgnoreCase(modifiedWord.toString().trim())) {
						outputAnagram.add(destination);
						consideredWords.add(destination);
					}
					
				}
				Collections.sort(outputAnagram);
				String finalAnagram="";
				for(String out:outputAnagram) {
					 finalAnagram=finalAnagram+","+out;
				}
				finalAnagram=finalAnagram.substring(1);
				outputData.add(finalAnagram);
			}
		}
		
		System.out.println(outputData);
		Collections.sort(outputData);
		System.out.println(outputData);
		return outputData;
	}
}
