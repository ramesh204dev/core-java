package com.test.v1;

public class BinarySearchAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,9,11,15,19,21,27};
		int key = 21;
		
		System.out.println(binarySearchAlgoImpl(arr, key));
	}
	
	/*
	 * Binary Search is an efficient algorithm for finding an element in a sorted array.
	 *  It works by repeatedly dividing the search space in half until the target element is found or the search space is empty
	 * Find the middle element of the array.
	If the middle element is the target, return its index.
	If the middle element is greater than the target, search in the left half.
	If the middle element is less than the target, search in the right half.
	Repeat until the element is found or the search space becomes empty.
	 */
	private static int binarySearchAlgoImpl(int[] arr,int key) {
		int start = 0;
		int end = arr.length-1;
		int mid =0;
		
		while(mid<=end) {
			 mid = start + (end-start)/2;
		if(arr[mid]==key)
			return mid;
		else if(arr[mid]<key)
			start = mid+1;
		else
			end = end-1;
		}
		
		return -1;
	}

}
