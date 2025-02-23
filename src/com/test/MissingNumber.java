package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber missNum = new MissingNumber();
		int[] nums = {9,6,4,2,3,5,7,0,1};
		System.out.println("result ::"+missNum.missingNumber_solution2(nums));
		
		System.out.println(5^4);
	}
	
	private int findMissingNumber(int[] nums) {
		List<Integer> range = IntStream.rangeClosed(0, nums.length)
			    .boxed().collect(Collectors.toList());
		
		for(int i=0;i<nums.length;i++) {
			if(!range.contains(nums[i]))
				return nums[i];
		}
		return -1;
	}
	
	
	private int findMissingNumber_Array(int[] nums) {
		List<Integer> testList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		for(int i=0;i<nums.length ;i++) {
			if(!testList.contains(i))
				return i;
		}
		return -1;
	}
	
	
	/*
	 *  natural sum - array sum = missing number
	 */

	private int findMissingNumberSolution1(int[] nums) {
		int n = nums.length;
		int naturalSum = (n*(n+1))/2;
//		int arraySum = Arrays.stream(nums).sum();
		int arraySum = 0;
		for(int i=0;i<nums.length;i++) {
			arraySum +=nums[i];
		}
		return naturalSum-arraySum;
	}
	
	
	/*
	 * Initialize an XOR variable as 0.
	XOR all numbers from 0 to n (inclusive). This accumulates the XOR of the complete sequence.
	XOR all numbers in the given array. This cancels out the numbers that are present in the sequence.
	The result is the missing number, as all other numbers cancel each other out.
	 */
	
	 private int missingNumber_solution2(int[] nums) {
	        int n = nums.length;
	        int ans = 0;
	        for (int i = 1; i <= n; i++) {
	            ans = ans ^ i;
	            System.out.println("ans ^ "+i+" = "+ans);
	            
	        }
	        for (int i = 0; i < nums.length; i++) {
	            ans = ans ^ nums[i];
	            System.out.println("ans ^"+nums[i]+" = "+ans);
	        }
	        return ans;
	    }
}
