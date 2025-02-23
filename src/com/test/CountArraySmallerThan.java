package com.test;

import java.util.Arrays;

public class CountArraySmallerThan {
	public static void main(String[] args) {
		int[] nums = {8,2,1,2,6,7};
		System.out.println(Arrays.toString(findCountArraySmallerThanItSelf(nums)));
	}
	
	private static int[] findCountArraySmallerThanItSelf(int[] nums) {
		int[] result  = new int[nums.length];
		int[] count = new int[101];
		
		for(int num:nums) {
			count[num]++;
		}
		for(int j=1;j<count.length;j++) {
			count[j]+=count[j-1];
		}
		
		for(int i=0;i<nums.length;i++) {
			result[i]=count[nums[i]-1];
		}
		return result;
	}
}
