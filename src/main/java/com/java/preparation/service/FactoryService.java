package com.java.preparation.service;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;
import com.java.preparation.model.Circle;
import com.java.preparation.model.FactoryShapeParent;
import com.java.preparation.model.Rectangle;



@Service("factoryService")
public class FactoryService {

	private Logger logger = Logger.getLogger(FactoryService.class);
	
	public void testShape(String shapeType) throws CustomException {
		FactoryShapeParent shape =null;
		if("cir".equalsIgnoreCase(shapeType)) {
			shape = (FactoryShapeParent) new Circle(5);
			
		}else if("rec".equalsIgnoreCase(shapeType)) {
			shape = (FactoryShapeParent) new Rectangle(3,4);
		}
		shape.calculateArea();
		shape.calculateCircumference();
	}
	
	
	
}
