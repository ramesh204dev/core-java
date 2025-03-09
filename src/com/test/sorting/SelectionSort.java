package com.test.sorting;

import java.util.Arrays;

//find the smallest element and replace with correct postion in sorted array
// 11 smallest , put it 0th index (swapping 0th element with index of smallest element 
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {64,25,12,22,11};
		
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			
			int small_index = i;
			
			for(int j=i+1;j<n;j++) {
				
				if(arr[j]<arr[small_index])
					small_index=j;
			}
			System.out.println(" "+i+Arrays.toString(arr));
			int temp = arr[i];
			arr[i] = arr[small_index];
			arr[small_index] = temp;
			
			System.out.println("swap"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
}
