package com.java.preparation.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("countDownLatchService")
public class CountDownLatchService {
	private Logger logger = Logger.getLogger(CountDownLatchService.class);
	
	public void testCountDownLatch() throws CustomException{
		CountDownLatch countDownLatch = new CountDownLatch(4); 
		Latching first = new Latching(1000, countDownLatch, "Latch-1"); 
		Latching second = new Latching(2000, countDownLatch, "Latch-2"); 
		Latching third = new Latching(3000, countDownLatch, "Latch-3"); 
		Latching fourth = new Latching(4000, countDownLatch, "Latch-4");

		 first.start();
	     second.start();
	     third.start();
	     fourth.start();
	     
	     System.out.println(Thread.currentThread().getName() + " has finished"+ countDownLatch.getCount());
	     
	    
	  
	    //barrier.reset();
	     
	     
	     
	     Latching fifth = new Latching(1000, countDownLatch, "Latch-5"); 

		 fifth.start();
	}
}

class Latching extends Thread {
	private int duration;
	private CountDownLatch latch;
	
	public Latching(int duration, CountDownLatch latch, String name)	{ 
		super(name);
		this.duration = duration; 
		this.latch = latch; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " is calling going to sleep for "+duration);
			Thread.sleep(duration); 
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			latch.await();
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " has completed"); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}