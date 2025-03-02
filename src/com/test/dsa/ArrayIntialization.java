package com.test.dsa;

import java.util.stream.IntStream;

public class ArrayIntialization {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int[] arr0 = new int[10]; // array of fixed size 10 with value 0 as intial value
		int[] arr1 = new int[] {1,2,3,4,5,6,7};
		int[][] arr2d = {{1,2,3} , {4,5,6}, {7,7,8}};
		int[] arr2 = IntStream.range(0, 9).toArray();  //prints 0,1,2,3,4,5,6,7,8
	}
}
