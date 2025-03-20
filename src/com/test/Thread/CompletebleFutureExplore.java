package com.test.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/*
 * supplyAsync() starts an asynchronous task.
	thenApply() processes the result.
	thenAccept() consumes the final result.
	Main thread is not blocked while the task execute
 */
public class CompletebleFutureExplore {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture.supplyAsync(()->{
			System.out.println("Fetching data ...");
			return "Data reterived from API";
		})
		.thenApply(res ->{
			System.out.println("transforming the data");
			return res.toUpperCase();
			})
		.thenAccept(res -> System.out.println(res));
		
		
		System.out.println("Main thread is free to takeup other taks ..") ; //all above methods of compelteableFutre are non blocking in natures
		
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		//exceptionally for handling errors gracefully
		
		CompletableFuture<Object> stockPrice = CompletableFuture.supplyAsync(()->{
			System.out.println("Fetching the stock price");
			throw new RuntimeException("API issue");
		}
				).exceptionally(ex->{
					System.out.println("Exception occurred "+ex.getMessage());
					return 0.0;
				});
		
		
		System.out.println("Main thered is free to do other tasks .....");
		
		  // Get the result (blocking only for output demonstration)
        System.out.println("Stock Price: $" + stockPrice.join());
        
        
        
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            System.out.println("B");
        });
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            System.out.println("A");
        });
        
        cf1.get(); //blocking call
        System.out.println("Main thread is waitng ....");
        cf2.get();

	}
}
