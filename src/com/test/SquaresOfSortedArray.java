package com.test;

import java.util.Arrays;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {-4,-1,0,2,5,7};
		int n =arr.length;
		int left =0,right = n-1;
		int[] result = new int[n];
		
		for(int k=n-1;k>=0;k--) {
			
			if(Math.abs(arr[left]) > Math.abs(arr[right])) {
				result[k] = arr[left] * arr[left];
				left++;
			}else {
				result[k] = arr[right] * arr[right];
				right--;
			}
			
		}
		
		
//		System.out.println(Arrays.toString(sortedSquares(arr)));
		
		
		System.out.println(Arrays.toString(result));
		
	}
	
	
	public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;        
    }

}
