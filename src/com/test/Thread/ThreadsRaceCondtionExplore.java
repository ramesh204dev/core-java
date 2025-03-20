package com.test.Thread;

import java.util.HashMap;
import java.util.Map;

/*
 * Race Condition is a situation where 2 or more threads access the shared resources
 * and tries to read/write 
 * 
 * check and act
 * read write modify
 */

class SharedProductResource {
	
	private Map<String,Integer> products;
	
	public SharedProductResource() {
		products = new HashMap<String, Integer>();
		products.put("Book", 1);
		products.put("Pen", 5);
		products.put("Pencil", 4);
	}
	
	//to avoid inconsistent results since multiple threads tries access shared object
	// synchronized keyword to have  object level lock
	public synchronized String buyProduct(String name) {
		
		if(products.containsKey(name)) {
			Integer quantity = products.get(name);
			if(quantity!=0) {
				products.put(name, quantity-1);
				return "Order Processed for product "+name+" is out of delivery for :::"+Thread.currentThread().getName();
			}
				
		}
		
		return "Oops!!! Product "+name+" is out of stock for :::"+Thread.currentThread().getName();
	}
}

class BuyBook implements Runnable{
	private SharedProductResource sharedProductResource =null;
	
	public BuyBook(SharedProductResource sharedProductResource) {
		this.sharedProductResource =  sharedProductResource;
	}
	
	
	@Override
	public void run() {
		System.out.println("Buy Book --> "+sharedProductResource.buyProduct("Book"));
	}
	
}

class BuyPen implements Runnable{
	private SharedProductResource sharedProductResource =null;
	
	public BuyPen(SharedProductResource sharedProductResource) {
		this.sharedProductResource =  sharedProductResource;
	}
	
	
	@Override
	public void run() {
		System.out.println("Buy Pen --> "+sharedProductResource.buyProduct("Pen"));
	}
	
}

class VoterCounterMachine implements Runnable {
	private int counter;
	public int getCounter() { return counter;}
	public void setCounter(int counter) { this.counter=counter;}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" - Before incrementing counter :"+ getCounter());
		
		synchronized (this) {
			setCounter(getCounter()+1);  //critical section
		}
	
		
		System.out.println(Thread.currentThread().getName()+" - After incrementing counter :"+ getCounter());
	}
	
	
}
public class ThreadsRaceCondtionExplore {
	public static void main(String[] args) {
		SharedProductResource  sharedProductResource = new SharedProductResource();
		
		
		//check and act 
		//multiple threads check for condition ,based on condition thread tries to change the state
		Thread thread1 = new Thread(new BuyBook(sharedProductResource), "Studet1");
		Thread thread2 = new Thread(new BuyBook(sharedProductResource), "Student2");
		Thread thread3  = new Thread(new BuyPen(sharedProductResource), "Student3");
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		//read write modify
		//multiple thread reads shared variable and tries to modify
		
		Thread t1   = new Thread(new VoterCounterMachine(), "state1");
		Thread t2   = new Thread(new VoterCounterMachine(), "state2");
		Thread t3   = new Thread(new VoterCounterMachine(), "state3");
		Thread t4   = new Thread(new VoterCounterMachine(), "state4");
		Thread t5   = new Thread(new VoterCounterMachine(), "state5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
}
