package com.test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BlockingCallExplore {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<Integer> task1  = ()-> {
			System.out.println("Task is executing in callble "+Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(10);
			System.out.println(Thread.currentThread().getName()+" is in runnable state");
			return 20;
		};
		
		Future<Integer> result = executorService.submit(task1);
		/*
		 * A blocking call means that the program pauses execution and waits until the operation is complete before moving forward.
		 *  When using Future.get() with Callable,
		 *   the main thread blocks until the result is available.
		 */
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
