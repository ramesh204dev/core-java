package com.test.sorting;

import java.util.Arrays;

//swapping adject places to achieve sorted array
// increasing order

public class BubbleSort {
	
	
	//inside for loop has n-i-1 because 
	//1st iteration puts highest value at (n-1)th postion 
	//at the end of 1st iteration we are able to find highest element in the given array
	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			boolean swapped =false;
			for(int j=0;j<n-i-1;j++) {
				
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
			}
				System.out.println("inside "+j+Arrays.toString(arr));
			}
			
			if(!swapped)
				break;
			
			System.out.println("outside "+i+Arrays.toString(arr));
		}
//			System.out.println(Arrays.toString(arr));
			
	
}
	//time complexity is O(n*n) 
	//sorting in Ascending order
	private static void bubbleSortOptimised(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			boolean swapped = false;
			for(int j=0;j<n-i-1;j++) {
				
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			//if no more swapping of elements, break the runnning loop
			if(!swapped)
				break;
			
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void bubbleSortDescOptimised(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			boolean swapped = false;
			for(int j=0;j<n-i-1;j++) {
				
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			//if no more swapping of elements, break the runnning loop
			if(!swapped)
				break;
			
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arr = {-2,5,4,-7,3};
		bubbleSort(arr);
		
		bubbleSortOptimised(arr);
		
		bubbleSortDescOptimised(arr);
		
	}
	}
