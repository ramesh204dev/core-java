package com.test.Thread;

import java.util.concurrent.TimeUnit;
/*
 * Thread.join() method causes current thread to wait state 
 * and target thread to completes executions.
 */
public class ThreadJoinExplore {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1  = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("Runnin the task defined "+i+ Thread.currentThread().getName());
				if(i==5)
					try {
						TimeUnit.SECONDS.sleep(3);
						System.out.println(Thread.currentThread().getName()+" is in running state");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		},"my-join-thread1");
		
		t1.start();
		
		
		t1.join();  //cause main thread (calling thread) to wait until t1 (target) completes it's execution
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("Runnin the task defined "+i+Thread.currentThread().getName());
				
				if(i==3)
					try {
						TimeUnit.SECONDS.sleep(5);
						System.out.println(Thread.currentThread().getName()+" is in running state");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		},"my-join-thread-2");
		
		t2.start();
		t2.join();
		
		System.out.println("Happy Learning !!!");
		
	}
}
