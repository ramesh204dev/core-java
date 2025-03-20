package com.test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyRunThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Executing the task defined in run method "+Thread.currentThread().getName());	
	}
	
}

class MyCallThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("Executing the task defined in call method "+Thread.currentThread().getName());	
		return 14;
	}
	
}
public class RunnableVsCallable {
	public static void main(String[] args) {
		
		Thread t1  = new Thread(new MyRunThread());
		t1.start();
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> result = executorService.submit(new MyCallThread());
		
		
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
	
	}
}
