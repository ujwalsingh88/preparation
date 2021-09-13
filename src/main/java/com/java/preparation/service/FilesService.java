package com.java.preparation.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("fileService")
public class FilesService {

	private Logger logger = Logger.getLogger(FilesService.class);
	
	public void readAndWriteFile() throws CustomException {
		List<String> fileData= new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Work\\JavaInterviewPreparation\\preparation\\src\\main\\tempFiles\\input\\Input.txt"));
			
			    
			    String line = br.readLine();

			    while (line != null) {
			        fileData.add(line);
			        line = br.readLine();
			    }
			
			    br.close();
			    
			    FileWriter writer = new FileWriter("C:\\Work\\JavaInterviewPreparation\\preparation\\src\\main\\tempFiles\\output\\Output.txt"); 
			    for(String str: fileData) {
			      writer.write(str + System.lineSeparator());
			    }
			    writer.close();
		} catch (Exception e) {
			throw new CustomException(e);
		} 
		
	}
}
