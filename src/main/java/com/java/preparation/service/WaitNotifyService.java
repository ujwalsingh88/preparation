package com.java.preparation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("waitNotifyService")
public class WaitNotifyService {
	 public void testWaitNotify() throws CustomException{
		 	List <Integer> data = new ArrayList<Integer>();
		 	Producers producer = new Producers(data, 10, "Producer"); 
		 	Consumers consumer = new Consumers(data, 10, "Consumer");
			System.out.println("Starting Threads");
			producer.start();
			consumer.start();
	   		System.out.println("Completed");
	 }
}

class Producers extends Thread {
	private List<Integer> list;
	private int maxSize;
	
	public Producers(List <Integer> data, int size, String name)	{ 
		super(name);
		this.list = data; 
		this.maxSize = size; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			synchronized(list) {
			for(int i=0;i<23;i++) {
				while(list.size()==maxSize) {
					System.out.println(Thread.currentThread().getName() +" going on wait List Data=" + list);
					list.wait();
				}
				list.add(i);
				list.notifyAll();
				System.out.println(Thread.currentThread().getName() +" Added List Data=" + list);
			}
				
			}	
			
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}

class Consumers extends Thread {
	private List<Integer> list;
	private int maxSize;
	
	public Consumers(List <Integer> data, int size, String name)	{ 
		super(name);
		this.list = data; 
		this.maxSize = size; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			synchronized(list) {
			for(int i=0;i<15;i++) {
				while(list.isEmpty()) {
					System.out.println(Thread.currentThread().getName() +" going on wait List Data=" + list);
					list.wait();
				}
				list.remove(list.size()-1);
				list.notifyAll();
				System.out.println(Thread.currentThread().getName() +" Removed List Data=" + list);
			}
			}
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}