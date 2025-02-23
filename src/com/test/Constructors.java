package com.test;

public class Constructors {
    public static void main(String[] args) {
        new Dog();
    }
}
class Animal {
    public Animal() { System.out.println("1"); }
    public Animal(String s) {
        this();
        System.out.println("2");
    }
}
class Dog extends Animal {
    public Dog() {
        super("3"); //this call superClass Parametrised Constructor 
        System.out.println("4");
    }
}
