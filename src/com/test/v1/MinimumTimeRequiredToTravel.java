package com.test.v1;

public class MinimumTimeRequiredToTravel {
	public static void main(String[] args) {
		int[][] arr = {{1,1},{3,4},{-1,0}};
		System.out.println(findMinimumTimeRequired(arr));
	}
	
	private static  int findMinimumTimeRequired(int[][] arr) {
		int result=0;
		for(int i=1;i<arr.length;i++) {
			
			int horizontal = Math.abs(arr[i][0]-arr[i-1][0]);
			int  vertical= Math.abs(arr[i][1]-arr[i-1][1]) ;
			result += Math.max(vertical, horizontal);
		}
		return result;
	}
}
