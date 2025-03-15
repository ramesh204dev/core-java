package com.test.exercise;

import java.io.IOException;

public class LonelyInteger {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter size of array");
//		int n  = Integer.parseInt(bufferedReader.readLine().trim());
//		System.out.println("Enter arry of elements "+n+ " with space seperated");
//		List<Integer> list = Stream.of(bufferedReader.readLine().replaceAll("\\s$+", "").split(" "))
//				.map(Integer::parseInt)
//				.collect(Collectors.toList());
//		
//		System.out.println("List : "+list);
		
		
		int[] arr = {4,2,4,5,2,1,5,7,7};
		
		//XOR operation logic (bitwise operation) returns 0 if same inputs ,else 1 if different inputs
		// 7^7=0111 ^ 0111 = 0000 = 0 (xor with same number returns 0)
		// 7^0= 0111 ^0000 = 0111  (XOR of number with 0 returns number)
		// 7^4 = 4^7 returns same result
		
		//all numbers repeated twice except one number which is lone number 
		//do the XOR of all elements which returns non repeated number
		int result = arr[0];
		for(int i=1;i<arr.length;i++)
			 result ^= arr[i];
		
		System.out.println("lone integer "+result);
		
	}
}
