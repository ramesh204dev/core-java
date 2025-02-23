package com.test;

import java.util.Arrays;

public class HowManyNumberAreSmaller {
	public static void main(String[] args) {
		int[] nums = {8,1,2,2,3};
		System.out.println(Arrays.toString(findCountOfSmallerNums(nums)));
	}
	
	private static int[] findCountOfSmallerNums(int[] nums) {
		int[] result = new int[nums.length];
		int count =0;
		for(int i=0;i<nums.length;i++) {
			
			for(int j=0;j<nums.length;j++) {
				if(nums[j]<nums[i])
					count++;
			}
			result[i]=count;
			count=0;
		}
		return result;
	}
	
	    public static int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] count = new int[101];
	        int n = nums.length;
	        
	        for (int i = 0; i < n; i++) {
	            count[nums[i]]++;
	            
	        }
	       System.out.println( Arrays.toString(count));
	        
	        for (int i = 1; i <= 100; i++) {
	            count[i] += count[i - 1];
	        }
	        System.out.println( Arrays.toString(count));
	        
	        int[] result = new int[n];
	        
	        for (int i = 0; i < n; i++) {
	            if (nums[i] == 0) {
	                result[i] = 0;
	            } else {
	                result[i] = count[nums[i] - 1];
	            }
	        }
	        
	        return result;
	    }
	
	    private int[] smallerNumbersThanCurrent_v0(int[] nums) {
	        int[] ans = new int[nums.length];
	        int max = Arrays.stream(nums).max().getAsInt();       
	        int[] freq = new int[max + 1];      
	        Arrays.stream(nums).forEach(num -> freq[num]++);       
	        for (int i = 1; i < freq.length; i++) freq[i] += freq[i - 1];  
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == 0) {
	                ans[i] = 0; 
	            } else {
	                ans[i] = freq[nums[i] - 1]; 
	            }
	        }      
	        return ans;
	    }
	    
	    
}
