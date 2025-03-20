package com.test.Thread;

class MyClass implements Runnable{

	@Override
	public void run() {
		System.out.println("myclass thread started");
		
	}
	
}

//disadvantage is that it can't extend any other class 
class MyThread extends Thread{
	
	@Override
	public void run() {
		
		System.out.println("My Thread is running");
	}
	
	
	public void run(int a) {
		System.out.println("Overloading run method "+a);
	}
}

class MyScheuleThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Count :: "+i);
		}
		
	}
	
}
public class ThreadExplore {
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		Thread myThread1  = new Thread(myClass);
		myThread1.start();
//		myThread.start(); //IllegalThreadStateException Runtime Exception Non checked exception
		
		Thread myThread2 = new Thread(myClass);
		myThread2.start();
		
		
		MyThread myThread = new MyThread();
		myThread.run();
		
		
		MyScheuleThread myScheuleThread = new MyScheuleThread();
		Thread  myThread3 = new Thread(myScheuleThread);
//		myThread3.setPriority(Thread.MAX_PRIORITY);
		myThread3.run();
		
		
		System.out.println("HappyNewyear !!!"); //default priority given for main thread is 5 
		
		
		
		TestThread testThread = new TestThread("My-test-thread");
		testThread.start();
		
		TestThread testThread1 = new TestThread();
		testThread1.start(); //default name is given
		
		
		//try to change name of main thread
		//main thread is started by JVM we have to user setName() of Thread class
		
		
	
		
	}
}


class TestThread extends Thread {
	
	public TestThread() {
		super();
	}
	
	public TestThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" thread is running ");
	}
}
