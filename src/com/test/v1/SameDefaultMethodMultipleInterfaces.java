package com.test.v1;

interface A{
	default void makeSound() {
		System.out.println("Make Sound from A");
	};
}

interface B {
	default void makeSound() {
		System.out.println("Make Sound from B");
	}
}

class Cow implements A,B{

	@Override
	public void makeSound() {
//		A.super.makeSound();
		B.super.makeSound();
	}
	
}
public class SameDefaultMethodMultipleInterfaces {
	public static void main(String[] args) {
		Cow cow = new Cow();
		cow.makeSound();
	}
}
