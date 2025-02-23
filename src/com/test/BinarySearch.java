package com.test;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arr[] = { 2, 3, 4, 10, 40,45,89,90,99 };
		  BinarySearch bs = new BinarySearch();
		  int result =  bs.binarySearchIterative(arr, 90);
		 if(result==-1) 
			 System.out.println("Given key is not found in the array by Iterative approach ");
		 else
			 System.out.println("Given key is found at the index :: "+result +" Iterative approach");
		 
		 
		 
		 int result1 =  bs.binarySearchRecursive(arr, 0,arr.length,90);
		 if(result1==-1) 
			 System.out.println("Given key is not found in the array by recursive approach");
		 else
			 System.out.println("Given key is found at the index :: "+result+" recursive approach");
		  
		 float fa=1.34f;
		 long la = 3000534657689900L;
		 
		 

	}
	
	/*
	 * Iterative approach O(log N)
	 */
	private int binarySearchIterative(int[] arr,int key) {
		int low=0 ;
		int high=arr.length;
		
		while(low<=high) {
			int mid= low+(high-low)/2;
			if(arr[mid]==key) 
				return mid;
			else if(key>arr[mid]) 
				low=mid+1;
			else 
				high=mid-1;
				
		}
		return -1;
	}
	
	/*
	 * recursive approach O(1)
	 */
	
	private int binarySearchRecursive(int[] arr,int low, int high,int key) {
		int mid = low+ (high-low)/2;
		if(high>=low) {
			if(arr[mid]==key) return mid;
			else if(arr[mid]>key) return binarySearchRecursive(arr, low, mid-1, key);
			else return binarySearchRecursive(arr, mid+1, high, key);
		}
		return -1;
	}

}
