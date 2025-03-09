package com.test.exercise;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s  = "aaaba";
		int maxLenght =0;
		int left =0;
		HashSet<Character> hashset = new HashSet<Character>();
		
		for(int right=0;right<s.length();right++) {
			
			
			while(hashset.contains(s.charAt(right))) {
				hashset.remove(s.charAt(left));
				left++;
			}
				
			hashset.add(s.charAt(right));
			
			maxLenght = Math.max(maxLenght, right-left+1);
		}
		
		System.out.println(maxLenght);
		
		System.out.println(findLongestSubstringUsingHashMap(s));

	}
	
	
	private static int findLongestSubstringUsingHashMap(String s) {
		int maxLength=0;
		int left =0;
		HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
		
		for(int right=0;right<s.length();right++) {
			Character currChar = s.charAt(right);
			
			//repeated character apperas
			//findOut lastSeen postion using our hashMap
			
			if(hashMap.containsKey(currChar) && hashMap.get(currChar)>=left) {
				left = hashMap.get(currChar)+1;
			}
			
			hashMap.put(currChar, right);
			maxLength = Math.max(maxLength, right-left+1);
		}
		
		return maxLength;
	}

}
