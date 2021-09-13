package com.java.preparation.service;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;
import com.java.preparation.model.OverridingChild1;
import com.java.preparation.model.OverridingChild2;
import com.java.preparation.model.OverridingChild3;
import com.java.preparation.model.OverridingParent;

@Service("overridingService")
public class OverridingService {
	
	private Logger logger = Logger.getLogger(OverridingService.class);
	
	public void testOverriding() throws CustomException{
		try {
			OverridingParent p = new OverridingParent();
			p.draw();
			p = new OverridingChild1();
			p.draw();
			p = new OverridingChild2();
			p.draw();
			p = new OverridingChild3();
			p.draw();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e);
		}
		
	}

}
