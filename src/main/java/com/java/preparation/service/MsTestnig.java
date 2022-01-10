package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("msTestnig")
public class MsTestnig {

	
	private Logger logger = Logger.getLogger(MsTestnig.class);
	
	public void startMstesting() throws CustomException{
		System.out.println("Started Testing");
		System.out.println("Completed Testing");
	}


}
