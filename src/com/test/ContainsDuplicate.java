package com.test;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String[] args) {
		ContainsDuplicate contDups = new ContainsDuplicate();
		int[] testArray = {5,9,1,6,13,18,11,9,2};
//		boolean result = contDups.isDuplicatesPresent_Hashset(testArray);
		boolean result = contDups.isDuplicatePresent_Hashset1(testArray);
		if(result)
			System.out.println("Duplicates are found");
		else
			System.out.println("Duplicates aren't found");
		
		
		  Integer x = 1987;
	      Integer y = 1987;
	      System.out.println(x == y ? "A" : "B");

	        x = 10;
	        y = 10;
	        System.out.println(x == y ? "A" : "B");
	}
	
	private boolean isDuplicatePresent_Array(int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==arr[i+1])
				return true;
		}
		return false;
	}
	
	/*
	 * set.add() returns boolean 
	 * false if it is already added
	 */
	private boolean isDuplicatesPresent_Hashset(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!set.add(arr[i]))
				return true;
		}
		return false;
	}
	
	private boolean isDuplicatePresent_Hashset1(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(set.contains(arr[i]))
				return true;
			set.add(arr[i]);
		}
		return false;
	}
	
	
}
