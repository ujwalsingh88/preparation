package com.java.preparation.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;
import com.java.preparation.model.SerialisedObject;

@Service("serialisationService")
public class SerialisationService {

	private Logger logger = Logger.getLogger(SerialisationService.class);
	
	public void writeToFile() throws CustomException {
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("C:\\Work\\JavaInterviewPreparation\\preparation\\src\\main\\tempFiles\\output\\Serialize.txt");
            oos = new ObjectOutputStream(fos);
            SerialisedObject sTest = new SerialisedObject("Ujwal", "Singh", 35, "gmail");
            oos.writeObject(sTest);
        } catch(Exception e) {
        	throw new CustomException(e);
            
        }finally {
        	try {
				oos.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new CustomException(e);
			}
           
        }
	}
	
	public void readFromFile() throws CustomException {
		FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("C:\\Work\\JavaInterviewPreparation\\preparation\\src\\main\\tempFiles\\output\\Serialize.txt");
            ois = new ObjectInputStream(fis);
            SerialisedObject sTest =  (SerialisedObject) ois.readObject();
            System.out.println(sTest.toString());
        } catch(Exception e) {
        	throw new CustomException(e);
            
        }finally {
        	try {
				ois.close();
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new CustomException(e);
			}
           
        }
	}
	
}
