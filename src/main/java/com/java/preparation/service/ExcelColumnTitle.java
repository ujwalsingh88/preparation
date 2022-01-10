package com.java.preparation.service;

import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("excelService")
public class ExcelColumnTitle {

	private static void printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();
        
        while (columnNumber > 0) {
            // Find remainder
            int rem = columnNumber % 26;
            System.out.println("REM:"+rem);
            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0) {
                columnName.append("Z");
                System.out.println("ColNameIf:"+columnName);
                columnNumber = (columnNumber / 26) - 1;
                System.out.println("ColNumberIf:"+columnNumber);
                
            }
            else // If remainder is non-zero
            {
            	System.out.println((rem - 1) + 'A');
            	System.out.println((char)((rem - 1) + 'A'));
                columnName.append((char)((rem - 1) + 'A'));
                System.out.println("ColNameElse:"+ columnName);
                columnNumber = columnNumber / 26;
                System.out.println("ColNumberElse:"+columnNumber);
            }
            
        }
        System.out.println(columnName.reverse());
    }
	
	public void excelColumn() throws CustomException
    {
        
        printString(705);
    }
}
