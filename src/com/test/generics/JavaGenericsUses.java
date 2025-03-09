package com.test.generics;

import java.util.ArrayList;
import java.util.List;

import com.test.dsa.Node;
/*
 * 1) type safety
 * 2) code reusable --> same class,method,interface can be multiple ways
 * 3) eliminates type casting 
 * 4) printArray[T[] ) can take any array of type (int[], char[], ...)
 */

class Utils {
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
    }
}


public class JavaGenericsUses {
	
	public static void main(String[] args) {
		 List list  = new ArrayList<>();  //Without Generics (Old way, unsafe)
		 
		 list.add("Ramesh");
		 list.add(23445);
		 list.add(new Node(12));
		 
		 //no type safety 
		 
		 String s1 = (String) list.get(0); //explicit casting //lost the type safety
		 
		 
		 List<String> names  = new ArrayList<String>();  //With Generics (Safe way)
		 names.add("Suresh");
		 names.add("Mahesh");
		 
		 String name = names.get(0); //ensures type safety
		 
		
		 Utils.printArray(List.of(1,2,3).toArray());
		 
		 Utils.printArray(List.of("1A","2A","3A").toArray());
		 
	}
}
