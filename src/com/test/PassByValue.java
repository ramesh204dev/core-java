package com.test;

public class PassByValue {
	class Test {
	    static void modifyPrimitive(int x) {
	        x = 10;  // Changes only the local copy
	    }

	    public static void main(String[] args) {
	    	PassByValue passBval = new PassByValue();
	        int num = 7;
	        modifyPrimitive(num);
	        System.out.println(num);  // Output: 5 (unchanged)
	        
	        
	        int x =5;
	        int y= 11;
	        passBval.swap(x,y);
	        System.out.println(x+"  " + y);
	        
	        
	        int[] arr = {5,11};
	        passBval.swapByArray(arr);
	        System.out.println(arr[0]+" "+ arr[1]);
	        Math.abs(y);
	        
	        
	
	    }
	}
	
	
	/*
	 * java is pass by value , pass copies of x and y for method parmeters
	 * Java is pass-by-value, meaning primitive values cannot be swapped directly.
	Workarounds:
		Use a wrapper class (IntWrapper).
		Use an array to store the values.
	 */
	private void swap(int x,int y) {
		int temp=x;
		x=y;
		y=temp;
	}
	
	/*
	 * array is an object. we can modify it's content here also java pass copy of reference to method parameter
	 * if referenced modified it's for local copy original reference will not changed 
	 */
	private void swapByArray(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
	
	

}
