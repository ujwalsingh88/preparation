package com.java.preparation.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.java.preparation.exception.CustomException;

@Service("exceptionService")
public class ExceptionService {

	private Logger logger = Logger.getLogger(ExceptionService.class);
	
	public void testExceptionMetod1() throws CustomException {
		try {
			logger.info("In exception method1");
			int a =3/0;
		}catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	public void testExceptionMetod2() throws CustomException {
		try {
			logger.info("In exception method2");
			int a =3/0;
		}catch(Exception e) {
			throw new CustomException(e);
		}
	}
	
	public void testExceptionMetod3() throws CustomException {
		try {
			logger.info("In exception method3");
			int a =3/0;
		}catch(Exception e) {
			throw new CustomException("error in method3",e);
		}
	}
}
