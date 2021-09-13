package com.java.preparation.service;

import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("semaphoreService")
public class SemaphoreService {

	private Logger logger = Logger.getLogger(SemaphoreService.class);
	
	public void testSemaphore() throws CustomException{
		Semaphore sem = new Semaphore(1);
		SemaphoreThread1 mt1 = new SemaphoreThread1(sem, "SemaphoreThread1");
		SemaphoreThread2 mt2 = new SemaphoreThread2(sem, "SemaphoreThread2");
          
        // stating threads A and B
        mt1.start();
        mt2.start();
        System.out.println("Completed");
	}
}

class Shared 
{
    static int count = 0;
}

class SemaphoreThread1 extends Thread
{
    Semaphore sem;
    String threadName;
    public SemaphoreThread1(Semaphore sem, String threadName) 
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }
    
    public void run() {
    	try {
    		System.out.println(threadName+ "trying to get lock.");
			sem.acquire();
			System.out.println(threadName+ "have got access of shared resource.");
			for(int i=0; i < 5; i++)
            {
                Shared.count++;
                System.out.println(threadName + " Shared Count: " + Shared.count);
      
                // Now, allowing a context switch -- if possible.
                // for thread B to execute
                Thread.sleep(10);
            }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sem.release();
    }
    
}

class SemaphoreThread2 extends Thread
{
    Semaphore sem;
    String threadName;
    public SemaphoreThread2(Semaphore sem, String threadName) 
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }
    
    public void run() {
    	try {
    		System.out.println(threadName+ "trying to get lock.");
			sem.acquire();
			System.out.println(threadName+ "have got access of shared resource.");
			for(int i=0; i < 5; i++)
            {
                Shared.count--;
                System.out.println(threadName + " Shared Count: " + Shared.count);
      
                // Now, allowing a context switch -- if possible.
                // for thread B to execute
                Thread.sleep(10);
            }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sem.release();
    }
    
}