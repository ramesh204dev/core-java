package com.test.exercise;

public class LargestMountainArray {
	
	public static void main(String[] args) {
		int[] nums = {2,1,4,7,3,2,5};
		 int[] arr = {2, 1, 4, 7, 3, 2, 5, 1, 6, 3, 2, 1};
		System.out.println(findLargetMountainSubArray(arr));
	}
	
	private static int findLargestMountainArray(int[] nums) {
		int largest =0;
		int left=0;
		int right = nums.length-1;
		int mid = (left+right)/2;
		
		for(int i=1;i<mid;i++) {
			if(nums[i-1]<nums[i]) {
				continue;
			}else {
				left++;
			}
		}
		

		for(int i=1;i<mid;i++) {
			if(nums[mid+i]<nums[mid]) {
				continue;
			}else {
				right--;
			}
		}
		
		largest = right-left+1;
		
		return largest;
	}
	
	
	//final solution
	private static int findLargetMountainSubArray(int[] arr) {
		int mountainLength =0;
		
		if(arr.length<3) //minimum length should be 3 
			return 0;
		
		for(int i=1;i<arr.length-1;i++) {
			
			if(arr[i]>arr[i-1]&& arr[i]>arr[i+1]) { //finding the peak
				int left =i;
				int right=i;
				
				//left sequence increasing sequence
				while(left>0 && arr[left]>arr[left-1]) {
					left--;
				}
				
				//right sequence decreasing sequence
				while(right<arr.length-1&& arr[right]>arr[right+1]) {
					right++;
				}
				
				mountainLength = Math.max(mountainLength, right-left+1);
			}
			
		
		}
		
		
		return mountainLength;
	}
	
}


