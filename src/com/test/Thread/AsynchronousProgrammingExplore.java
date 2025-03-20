package com.test.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsynchronousProgrammingExplore {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> response = executorService.submit( () -> {
			System.out.println(Thread.currentThread().getName()+" task is executing");
			TimeUnit.SECONDS.sleep(2);
			return "Welcome";
		});;
		
		try {
			System.out.println(response.get()); //blocks the main thread until task is compelted and try catch is compulsory
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName()+" execution is in progress ");
			try {
				TimeUnit.MICROSECONDS.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 32;
		}) ;
		
		future.thenAccept(res -> System.out.println("Result :: "+res));
		
		System.out.println("Main thread is free to execute other tasks defined .....");
		
		
		future.join();
	}
}
