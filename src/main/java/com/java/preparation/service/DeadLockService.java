package com.java.preparation.service;



import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("deadLockService")
public class DeadLockService {

	public void testDeadLock() throws CustomException{
		Thread1 first = new Thread1("ABC", "DEF", "PARTY-1"); 
		Thread2 second = new Thread2("ABC", "DEF", "PARTY-2"); 
		System.out.println("Starting Threads");
		first.start();
		second.start();
   		System.out.println("Completed");
	}
}

class Thread1 extends Thread {
	private String str1;
	private String str2;
	
	public Thread1(String s1, String s2, String name)	{ 
		super(name);
		this.str1 = s1; 
		this.str2 = s2; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			synchronized(str1){
				System.out.println(Thread.currentThread().getName() +" got lock of" +str1+" going to sleep");
				Thread.sleep(2000);
				synchronized(str2){
					System.out.println(Thread.currentThread().getName() +" got lock of" +str2);
				}
			}
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}

class Thread2 extends Thread {
	private String str1;
	private String str2;
	
	public Thread2(String s1, String s2, String name)	{ 
		super(name);
		this.str1 = s1; 
		this.str2 = s2; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			synchronized(str2){
				System.out.println(Thread.currentThread().getName() +" got lock of" +str2+" going to sleep");
				Thread.sleep(2000);
				synchronized(str1){
					System.out.println(Thread.currentThread().getName() +" got lock of" +str1);
				}
			}
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}
