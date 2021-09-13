package com.java.preparation.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("futureTaskService")
public class FutureTaskService {

	public void testAdditionTime() throws CustomException{
		try {
			List <Integer> data = new ArrayList<Integer>();
			int normalSum = 0;
			int futureSum=0;
			for(int i=1; i<=10000000;i++) {
				data.add(i);
			}
			
			Date normalAdditionStartDate = new Date();
			for(Integer j :data) {
				normalSum=normalSum+j;
			}
			
			Date normalAdditionEndDate = new Date();
			System.out.println("Noraml sum="+normalSum + " & time taken" +(normalAdditionEndDate.getTime()-normalAdditionStartDate.getTime()));
			


			Date futureAdditionStartDate = new Date();
			CyclicBarrier barrier = new CyclicBarrier(11);
			List<Future<Integer>> futureList= new ArrayList<Future<Integer>>();
			ExecutorService exec = Executors.newFixedThreadPool(10);
			
			for(int k=0;k<10;k++) {
				
				MyCallable callable = new MyCallable((k*1000000)+1, (k+1)*1000000,data,barrier);
				//FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
				//exec.execute(futureTask);
				Future<Integer> futureTask = exec.submit(callable);
				futureList.add(futureTask);
				
			}
			barrier.await();
			for(Future<Integer> futureNos:futureList) {
				futureSum=futureSum+futureNos.get();
			}
			
			Date futureAdditionEndDate = new Date();
			System.out.println("Future sum="+futureSum + " & time taken" +(futureAdditionEndDate.getTime()-futureAdditionStartDate.getTime()));
			System.out.println("Completed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	}
}



class MyCallable implements Callable<Integer> {

	private int startLimit;
	private int endlimit;
	private List<Integer> intList;
	private CyclicBarrier barrier;
	private Integer partialSum=0;
	
	public MyCallable(int start, int end, List<Integer> data, CyclicBarrier barrier){
		this.startLimit=start;
		this.endlimit=end;
		this.intList=data;
		this.barrier = barrier; 
	}
	@Override
	public Integer call() throws CustomException {
		try {
			for(int i = startLimit; i<=endlimit; i++) {
				partialSum=partialSum+i;
			}
			barrier.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return partialSum;
	}

}