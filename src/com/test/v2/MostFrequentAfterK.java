package com.test.v2;

import java.util.Arrays;

public class MostFrequentAfterK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1,2,4};
		int[] nums = {1,4,8,13};
		System.out.println(maxFrequency(nums, 5));
	}
	
	
	private static int maxFrequency(int[] nums,int k) {
		Arrays.sort(nums);
		
		int left=0;
		int sum =0;
		int maxFrequency=0;
		
		for(int right=0;right<nums.length;right++) {
			
			sum+=nums[right];
			
			if( nums[right]* (right-left+1)- sum >k) {
				sum-=nums[left];
				left++;
			}
			
			maxFrequency = Math.max(maxFrequency, right-left+1);
				
		}
		
		return maxFrequency;
	}

}
