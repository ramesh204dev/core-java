package com.test.sorting;

import java.util.Arrays;

/*
 * dividing the given array to smaller sub arrays
 * sort those sub arrays 
 * merge them to frame the sorted array as result
 */

/*
 * divide takes O(logn)
 * merge takes o(n)
 * 
 * total time complexity O(n * log(n) ) 
 */
public class MergeSort {
	
	private static void merge(int[] arr,int si,int mid,int ei) {
		
		int[] merged = new int[ei-si+1];
		
		int idx1 = si;
		int idx2 = mid+1;
		int x=0; 
		
		while(idx1<=mid && idx2<=ei) {
			if(arr[idx1]<=arr[idx2])
				merged[x++] = arr[idx1++];
			else
				merged[x++]=arr[idx2++];
		}
		
		while(idx1<=mid)
			merged[x++] = arr[idx1++];
		
		while(idx2<=ei)
			merged[x++] = arr[idx2++];
		
		
		//sorted elements are pushed to original array
		for(int i=0,j=si;i<merged.length;i++,j++) {
			arr[j] = merged[i];
		}
		
	}
	
	private static void divide(int[] arr, int si, int ei) {
		if(si>=ei)
			return;
		int mid = si+ (ei-si)/2 ;
		
		divide(arr,si,mid); //1st half which further splits
		divide(arr,mid+1,ei); //2nd half which further splits
		
		merge(arr,si,mid,ei); //sort them and merge those sub arrays
	}
	
	public static void main(String[] args) {
		int[] nums = {2,-4,9,1,8,7,3,5};
		divide(nums,0,nums.length-1);
		
		System.out.println(Arrays.toString(nums));
	}
}
