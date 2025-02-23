package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int sum = 9;
		SumOfTwoNumbers sumNumbers = new SumOfTwoNumbers();
		System.out.println(Arrays.toString(sumNumbers.findIndexesSum(nums, sum)));
		
		System.out.println(Arrays.toString(sumNumbers.findIndexSumUsingHashMap(nums, sum)));
		int[] nums1= {2,7,11,15};
		int target = 18;
		System.out.println(Arrays.toString(sumNumbers.findIndexOfGivenSumInSortedArray(nums1, target)));
	}
	
	private int[] findIndexesSum(int[] nums,int sum) {
		
		for(int i=0;i<nums.length;i++) {
			int secondIndex = Math.abs(nums[i]-sum);
			System.out.println(i);
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]==secondIndex)
				{
					return new int[] {i,j};
					
				}
			}
		}
		return new int[] {};
	}
	
	/*
	 * HashMap requires O(n) space
	 * time complexity O(n) 
	 */
	
	
	private int[] findIndexSumUsingHashMap(int[] nums,int sum) {
		Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++) {
			
			int secondIndex = Math.abs(nums[i]-sum);
			if(numsMap.containsKey(secondIndex)) {
				return new int[] {i,numsMap.get(secondIndex)};
			}
			numsMap.put(nums[i], i);
		}
		return new int[] {};
		
	}
	
	
	/*
	 * Time Complexity: O(n)
		Space Complexity: O(1)
		given array is sorted
	 */
	private int[] findIndexOfGivenSumInSortedArray(int[] nums,int target) {
		int left=0;
		int right=nums.length-1;
		
		for(int i=left;i<nums.length;i++) {
			int sum = nums[left]+nums[right];
			if(target==sum)
				return new int[] {left,right};
			else if(target>sum)
				left++;
			else
				right--;
		}
		
		return new int[] {};
	}
}
