package com.test.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {23,1,10,5,2};
		
		//time complexity is O(N*N)
		insertionSort(arr);
	}
	
	
	//take unsorted element and place it correct position in sorted array
	private static void insertionSort(int[] arr) {
		
		int n = arr.length;
		
		//assuming 0th index element as sorted array
		for(int i=1;i<n;i++) {
			
			int key = arr[i];
			int j=i-1;
			
			//if key smaller than element of sorted array
			//Move elements of arr[0..i-1], that are
            //greater than key, to one position ahead
            // of their current position 
			while(j>=0&& arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			//placing the element at correct postion
			arr[j+1]=key;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
