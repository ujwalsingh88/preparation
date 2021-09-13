package com.java.preparation.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("cyclicBarrierService")
public class CyclicBarrierService {
	private Logger logger = Logger.getLogger(CyclicBarrierService.class);
	
	public void testCyclicbarrier() throws CustomException{
		try {
			CyclicBarrier barrier = new CyclicBarrier(5); 
			Party first = new Party(10000, barrier, "PARTY-1"); 
			Party second = new Party(2000, barrier, "PARTY-2"); 
			Party third = new Party(3000, barrier, "PARTY-3"); 
			Party fourth = new Party(4000, barrier, "PARTY-4");
			
			 first.start();
			 second.start();
			 third.start();
			 fourth.start();
			 barrier.await();
			 
			 
			
  
		
			 
			 
			 Party fifth = new Party(1000, barrier, "PARTY-5"); 
			 Party sixth = new Party(2000, barrier, "PARTY-6"); 
			 Party seventh = new Party(3000, barrier, "PARTY-7"); 
			 Party eightth = new Party(4000, barrier, "PARTY-8");
			 

			 fifth.start();
			 sixth.start();
			 seventh.start();
			 eightth.start();
			 barrier.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;
	
	public Party(int duration, CyclicBarrier barrier, String name)	{ 
		super(name);
		this.duration = duration; 
		this.barrier = barrier; 
	}
	
	@Override 
	public void run() 
	{ 
		try { 
			System.out.println(Thread.currentThread().getName() + " is calling going to sleep for "+duration);
			Thread.sleep(duration); 
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " has completed"); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}


