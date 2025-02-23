package com.test;

public class ResourcerAutoClose implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Resource closed ");
		
	}
	
	public void doSomething() {
		System.out.println("Resource is using .... ");
	}
	
}

