package com.java.preparation.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("blockingQueueService")
public class BlockingQueueService {
	
	public void testBlocking() throws CustomException{
		BlockingQueue<Integer> bqueue  = new ArrayBlockingQueue<Integer>(4);
		producer p1 = new producer(bqueue);
		consumer c1 = new consumer(bqueue);
		Thread pThread = new Thread(p1);
		Thread cThread = new Thread(c1);
		pThread.start();
		cThread.start();
		System.out.println("Blocking Queu Complete");
	}

}

class producer implements Runnable {

	BlockingQueue<Integer> blockingQueue;

	public producer(BlockingQueue<Integer> bQueue)
	{
		// accept an ArrayBlockingQueue object from
		// constructor
		this.blockingQueue = bQueue;
	}

	@Override public void run()
	{
		
		// Produce numbers in the range [1,4]
		// and put them in the buffer
		try {
		Thread.sleep(3000);
			for (int i = 1; i <= 10; i++) {
				
					blockingQueue.put(i);
					System.out.println("Produced=" + i + " & Size="+blockingQueue);
				
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//Java program to demonstrate consumer code

//Implement Runnable since object
//of this class will be executed by
//a separate thread
class consumer implements Runnable {

	BlockingQueue<Integer> blockingQueue;



	public consumer(BlockingQueue<Integer> bQueue)
	{
		// accept an ArrayBlockingQueue object from
		// constructor
		this.blockingQueue = bQueue;
	}

	@Override public void run()
	{

		
		for(int i=0; i<7; i++) {
			try {
				int taken=blockingQueue.take();
				System.out.println("Consumed="+taken + " &  size="+blockingQueue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

