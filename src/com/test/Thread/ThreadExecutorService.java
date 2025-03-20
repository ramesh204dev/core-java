package com.test.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Executing Task in the thread "+Thread.currentThread().getName());
	}
	
}
/*
 * ExecutorService is a framework to mange multiple threads
 * it's thread pool service 
 * ExecutorService manages a pool of threads efficiently
 */
public class ThreadExecutorService {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3); //provide a pool of 3 threads
		
		for(int i=0;i<5;i++) {
			executorService.execute(new MyTask()); //submit the task to executor
		}
		
		executorService.shutdown(); 
	}
}
