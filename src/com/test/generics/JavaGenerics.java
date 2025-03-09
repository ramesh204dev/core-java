package com.test.generics;

import java.util.List;

/*
 * Java Generics help to create classes,interfaces,methods with type parameter
 * type safety and code reusability
 */
public class JavaGenerics {
	public static void main(String[] args) {
		Box<String> box1 = new Box();
		box1.setValue("TestRam");
		
		Box<List<Integer>> box2 = new Box();
		box2.setValue(List.of(1,2,3));
		
		box2.print(List.of(1,2,4).toArray());
		
		Pair<String,Integer> pair1 = new Pair("Suresh", 24);
	}
}


class Box<T>{
	private T value;
	
	public void setValue(T value) {this.value=value;}
	
	public T getValue() { return value;}
	
	public static <T> void print(T[] arr) {
		for(T t:arr) {
			System.out.print(t+ " " );
		}
		System.out.println();
	}
}

/*
 *  < T extends Integer>  T should be subclass Integer
 *  <T super Integer> T should be parent of Integer
 *  
 *  < ? extends Number>  wildcard upper bound
 *  <? super Integer>  wildcard lower bound
 */



interface Container<T>{
	
	void add(T t);
	T get();
}

class Stroage<T> implements Container<T>{

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class Pair<K,V> {
	
	private K key;
	private V value;
	
	Pair(K key,V value){
		this.key=key;
		this.value=value;
	}
	
	public K getKey() {return key;}
	
	public V getValue() { return value;}
}