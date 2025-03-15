package com.test.v1;

public class MainMethodOverLoading {
	
	//jvm calls String[] methods 
	public static void main(String[] args) {
		System.out.println("1st Main method");
		main(new int[] {2});
	}
	
	
	//we can overload the main method
	public static void main(int[] args) {
		System.out.println("2nd main method"+ args[0]);
	}
}
