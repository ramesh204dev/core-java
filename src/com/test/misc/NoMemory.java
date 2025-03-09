package com.test.misc;

import java.util.ArrayList;
import java.util.List;

/*
 * Direct Recursion
 * Indirect Recursion
 * Tail recursion  (recursion is last call in the function , nothing more to evaluate)
 * Non Tail recursion (recursion is not the last code in execution, some more is left to evaluate)
 */
public class NoMemory {
	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		System.out.println(sum(integerList));
		System.out.println(sumInt(integerList));
		
		System.out.println(sumIntTailRecursive(integerList));
	}
	
	private static int sum(List<Integer> list) {
		if(list.isEmpty())
			return 0;
		return list.get(0)+sum(list.subList(1, list.size()));
	}
	
	
	private static int sumInt(List<Integer> list) {
		return sumIntHelper(list,0);
	}
	
	private static int sumIntHelper(List<Integer> list,int index) {
		if(index>=list.size())
			return 0;
		return list.get(index)+ sumIntHelper(list,index+1);
	}
	
	private static int sumIntTailRecursive(List<Integer> list) {
		return sumIntHelperTR(list,0,0);
	}
	
	
	private static int sumIntHelperTR(List<Integer>list,int index,int sum) {
		if(index>=list.size())
			return sum;
		return sumIntHelperTR(list, index+1, sum+list.get(index));
	}
}
