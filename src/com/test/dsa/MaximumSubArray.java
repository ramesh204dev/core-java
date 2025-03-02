package com.test.dsa;

public class MaximumSubArray {
	public static void main(String[] args) {
		int[] nums = {2,3,-8,7,-1,2,3};
		
	
		System.out.println(findMaxOfSubArrayKadneAlgo(nums));
		
		
	}
	
	private static int findMaxOfSubArrays(int[] nums) {
	 int maxSum = nums[0];
		
		for(int i=0;i<nums.length;i++) {
			int currSum =0;
			for(int j=i+1;j<nums.length;j++) {
				currSum = currSum+nums[j];
				maxSum = Math.max(maxSum, currSum);
			}
		}
		
		return maxSum;
	}
	
	
	private static int findMaxOfSubArrayKadneAlgo(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum =0;
		
		for(int i=0;i<nums.length;i++) {
			sum = sum + nums[i];
			maxSum = Math.max(maxSum, sum);
			
			if(sum<0)
				sum=0;
			
		}
		
		return maxSum;
		
	}
}
