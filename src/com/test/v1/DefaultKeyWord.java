package com.test.v1;


interface Animal {
    default void sound() {
        System.out.println("Animal makes a sound");
    }
}

interface Pet {
    default void sound() {
        System.out.println("Pet makes a sound");
    }
}

// Compilation error! Which sound() method should be used?
class Dog implements Animal, Pet {

//	@Override
//	public void sound() {
//		// TODO Auto-generated method stub
//		Animal.super.sound();
//	}

//	@Override
//	public void sound() {
//		// TODO Auto-generated method stub
//		Pet.super.sound();
//	}
	
	 // Must override to resolve conflict
    public void sound() {
        System.out.println("Dog barks!");
    }
   
}

public class DefaultKeyWord {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.sound(); // Outputs: Dog barks!
    }
}
