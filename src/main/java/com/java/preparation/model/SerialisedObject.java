package com.java.preparation.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.java.preparation.exception.CustomException;

public class SerialisedObject  implements Serializable {
 
    //default serialVersion id
    private static final long serialVersionUID = 1L;
 
    private String first_name;
    private String last_name;
    private int age;
    private static int phoneNo=123;
    private transient String email;
    
 
    public SerialisedObject(String fname, String lname, int age,  String eml){
        this.first_name = fname;
        this.last_name  = lname;
        this.age        = age;
        this.email =eml;
    }
 
    
 
    public static int getPhoneNo() {
		return phoneNo;
	}



	public String getEmail() {
		return email;
	}



	public String getFirstName() {
        return this.first_name;
    }
 
   
 
    public String getLastName() {
        return this.last_name;
    }
 
    
    public int getAge() {
        return this.age;
    }
 
    private void writeObject(ObjectOutputStream stream) throws CustomException {
        try {
			stream.defaultWriteObject();
			stream.writeObject(phoneNo);
			stream.writeObject(email);
		} catch (IOException e) {
			throw new CustomException(e);
		}
    }

    
    private void readObject(ObjectInputStream stream) throws CustomException {
        try {
			stream.defaultReadObject();
			phoneNo=(int) stream.readObject();
			email = (String) stream.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CustomException(e);
		} 

    }
    
    @Override
    public String toString() {
        return new StringBuffer(" First Name: ").append(this.first_name).append(" , Last Name : ").append(this.last_name)
        		.append(" , Age : ").append(this.age).append(" , Phn : ").append(this.phoneNo).
        		append(" , Eml : ").append(this.email).toString();
    }
 
}