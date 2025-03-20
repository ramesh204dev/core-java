package com.test.Thread;

import java.util.concurrent.TimeUnit;

/*
 * Thread.yield() causes the currently executing thread object to pause it's executing 
 * and allowing other waiting thread to execute 
 * it's static native method . underlying platform should supports for preemptive scheduling else 
 * t.yeild() will be ignored
 */
public class ThreadYieldExplore {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "mythread-0");
		t1.start();
		
		Thread t2 = new Thread(new MyRunnable(), "mythread-1");
		t2.start();
		
		
		Thread t3  = new Thread(new MyRunnableThread(), "my-sleeping-thread");
		t3.start();
	}
	
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("MyRunnable class is executing by thread "+thread.getName());
		
		for(int i=0;i<20;i++) {
			System.out.println("Processing task "+i+ "by thread "+thread.getName());
			
			if(i==7)
				Thread.yield();
			
		}
		
	}
	
}


class MyRunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is executing");
		
		for(int i=0;i<10;i++) {
			long start = System.currentTimeMillis();
			System.out.println("Processing task "+i+ "by the thread "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(3000);
//				TimeUnit.SECONDS.sleep(2); //timeunit is util class for readable format of pausing/sleeping the thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Total sleep time for the thread "+Thread.currentThread().getName()+" ::"+(System.currentTimeMillis()-start));
		}
		
		
	}
	
}
