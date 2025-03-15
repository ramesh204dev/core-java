package com.test;

import java.util.Arrays;

//https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
class Personc implements Comparable<Personc>{
	String name;
	int age;
	
	Personc(String name,int age){
		this.name = name;
		this.age=age;
	}
	
	//natural ordering defined inside the class
	@Override
	public int compareTo(Personc o) {
		
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		
		return name+"("+age+")";
	}
	
}


class Persond implements Comparable<Persond>{
	String name;
	int age;
	
	Persond(String name,int age){
		this.name = name;
		this.age=age;
	}
	
	//natural ordering defined inside the class
	@Override
	public int compareTo(Persond o) {
		
		return this.age- o.age;	}
	
	@Override
	public String toString() {
		
		return name+"("+age+")";
	}
	
}

public class ComparatorExplore {

	public static void main(String[] args) {
		Personc[] persons = {new Personc("Ramesh",20),
		new Personc("Laxman",31),
		new Personc("Bob",15)};
		
		Arrays.sort(persons);
		
		System.out.println(Arrays.toString(persons));
		
		
		
		Persond[] personsd = {new Persond("Ramesh",24),
				new Persond("Laxman",12),
				new Persond("Bob",51)};
				
				Arrays.sort(personsd);
				
				System.out.println(Arrays.toString(personsd));
				
		
		
	}

}
