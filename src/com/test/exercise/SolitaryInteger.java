package com.test.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SolitaryInteger {

	public static void main(String[] args) {
		int[] arr = {1,4,3,3,2,5,1,2,5,7,7};
		
		Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			
			if(hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i])+1);
				continue;
			}
			
			hashMap.put(arr[i], 1);
		}
		
		
		for(Entry<Integer, Integer> entry: hashMap.entrySet()) {
			if(entry.getValue()==1)
				System.out.println(entry.getKey());
		}
		
		
		//since input is in the range of [1,100]
		int[] result = new int[101];
		
		for(int i=0;i<arr.length;i++) {
			
			result[arr[i]] += 1;
		}
		
		for(int i=1;i<result.length;i++) {
			if(result[i]==1) {
				System.out.println(i);
				break;}
		}

	}

}
