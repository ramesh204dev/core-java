package com.test;

public class InheritanceJavaExample {
	public static void main(String[] args) {
		new Dove();
	}
}

class Bird {
	//Default Constructor
	public Bird(){System.out.println("1");}
	
	//Parameterized constructor
	public Bird(String name){
		this();
		System.out.println(name);
	}
}

class Dove extends Bird{
	public Dove(){
	super("3");
	System.out.println("Dove");
	}
	
}

