package com.java.preparation.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;
import com.java.preparation.model.SingletonDoubleLock;
import com.java.preparation.model.SingletonEnum;

@Service("singletonService")
public class SingletonService {
	private Logger logger = Logger.getLogger(SingletonService.class);
	
	public void testSingletonDoubleLockInstance() throws CustomException{
		SingletonDoubleLock sObj1= SingletonDoubleLock.getInstance();
		SingletonDoubleLock sObj2= SingletonDoubleLock.getInstance();
		if(sObj1==sObj2) {
			System.out.println("Both Object are same");
		}
		else {
			System.out.println("Both objects are differnt");
		}
	}
	
	public void testSingletonEnumInstance() throws CustomException{
		SingletonEnum sObj1= SingletonEnum.INSTANCE;
		SingletonEnum sObj2= SingletonEnum.INSTANCE;
		if(sObj1==sObj2) {
			System.out.println("Both Object are same");
		}
		else {
			System.out.println("Both objects are differnt");
		}
	}
}
