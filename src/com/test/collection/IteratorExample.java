package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorExample {
	public static void main(String[] args) {
		
		List<String> alphas = new ArrayList<String>(Arrays.asList("A","B","C"));
		
		Iterator<String> iterator = alphas.iterator();
		
		
		System.out.println(iterator.next()); //return A
		iterator.remove();  //deletes A
		iterator.next();  //iterator at B
		iterator.remove();  //removes B
		
		
		
		System.out.println(iterator.next()); //prints next element
		
		
		List<String> fruits = new ArrayList<String>(Arrays.asList("Apple","Banana","Oranges"));
		
		ListIterator<String> lstIterator = fruits.listIterator();
		
		while(lstIterator.hasNext()) {
			System.out.println(lstIterator.next());
			lstIterator.add("Pineapple");
		}
		
		//list iterator get copy of original list for  traversing
		//addition/removal will be effected for next traversal not the current traversal
		
		System.out.println();
		lstIterator.add("Grapes");
		while(lstIterator.hasPrevious()) {
			System.out.println(lstIterator.previous());
		}
		
		
		List<String>  names = new LinkedList<String>(Arrays.asList("Ramesh","Suresh","Venkatesh"));
		
		ListIterator<String> namesIterator = names.listIterator();
		
		while(namesIterator.hasNext()) {
			String name = namesIterator.next();
			System.out.println(name);
			
			if(name.equals("Suresh")) {
				namesIterator.set("Mahesh");  //modifies suresh to mahesh
				namesIterator.add("Kamesh");
			}
			
		}
		
		System.out.println("modifiedList "+names);
		
		
		
		List<String> list = new LinkedList<>();
	    
        list.add("A");
        list.add("C");
        list.add("D");

        Iterator<String> it = list.iterator();

        System.out.println(it.next());

//        list.add(1, "B"); //throws concurrent modification
        
        System.out.println(it.next());
        System.out.println(it.next());
//        System.out.println(it.next());  //NosuchElemetnException
        
        
        List<String> newlist = new ArrayList<String>(Arrays.asList("A","B"));
        ListIterator<String> listIter = newlist.listIterator();
        
        listIter.add("B"); //throws concurrent modification
        
        System.out.println(listIter.next());
	}
}
