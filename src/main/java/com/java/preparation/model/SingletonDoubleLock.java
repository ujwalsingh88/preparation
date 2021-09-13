package com.java.preparation.model;

public class SingletonDoubleLock {

	
	private static volatile SingletonDoubleLock sdlObj=null;
	
	private SingletonDoubleLock() {
		super();
	}
	
	public static SingletonDoubleLock getInstance() {
		if (sdlObj == null) {
            synchronized (SingletonDoubleLock .class) {
                if (sdlObj == null) {
                	sdlObj = new SingletonDoubleLock();
                }
            }
        }
        return sdlObj;
	}
	
}
