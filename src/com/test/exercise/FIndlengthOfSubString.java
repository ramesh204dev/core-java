package com.test.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FIndlengthOfSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "abcabcbb";
		
		char[] charArry = input.toCharArray();
		
//		System.out.println(Arrays.toString(charArry));
		
//		System.out.println(input.contains("abc"));
//		String result = String.valueOf(charArry[0]);
//		
//		for(int i=1;i<charArry.length;i++) {
//			String sub = String.valueOf(charArry[i]);
//			
//			if(result.charAt(result.length()-1)==charArry[i]) {
//				System.out.println("Enter");
//				result = sub;}
//			else if(result.contains(sub))
//				continue;
//			else
//				result = result.concat(sub);
//		}
//		

		System.out.println(findMaxlengthOfSubString(input));
		
		System.out.println(findMaxLenthOfSubStringUsingHashSet(input));
		
		System.out.println(findMaxLengthOfSubstringUsingHashMap(input));
		
		System.out.println(findMaxLengthOfSubStringUsingHashMap_V1(input));
		

	}

	
	private static int maxSubString(String s) {
		StringBuilder result  = new StringBuilder();
		int maxlength =0;
		
		for(int i=0;i<s.length();i++) {
			char currChar = s.charAt(i);
			
			while(result.indexOf(String.valueOf(currChar))!=-1) {
				System.out.println("enter");
				result.deleteCharAt(0);
			}
			System.out.println(i+" " +result);
			result.append(currChar);
			System.out.println(i+" " +result);
			maxlength = Math.max(maxlength, result.length());
			System.out.println("len "+maxlength);
			System.out.println();
		}
		
		return maxlength;
	}
	
	
	/*
	 * time complexity O(n^2)
	 * space complaxity O(n) stringbuilder stores character dynamically, with maximum size of n
	 */
	
	private static int findMaxlengthOfSubString(String s) {
		int maxLength =0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			char currChar = s.charAt(i);
			
			//removing the repeated char from the appended the sb
			while(sb.indexOf(String.valueOf(currChar))!=-1) {
				sb.deleteCharAt(0);
			}
			
			sb.append(currChar);
			
			maxLength = Math.max(maxLength, sb.length());
			
			
		}
		
		return maxLength;
		
	}
	
	
	private static int findMaxLenthOfSubStringUsingHashSet(String s) {
		
		int maxLength =0;
		int left =0;
		HashSet<Character>  charSet = new HashSet<Character>();
		
		for(int right=0;right<s.length();right++) {
			
			//same char is present in the hashset remove it and increase the left pointer
			while(charSet.contains(s.charAt(right))) {
				charSet.remove(s.charAt(left));
				left++;
			}
			
			charSet.add(s.charAt(right));
			maxLength = Math.max(maxLength, right-left+1);
		}
		return maxLength;
	}
	
	
	private static int findMaxLengthOfSubstringUsingHashMap(String s) {
		int maxLength =0;
		int left =0;
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		for(int right=0;right<s.length();right++) {
			
			Character currChar  = s.charAt(right);
			hashMap.put(currChar, hashMap.getOrDefault(currChar, 0)+1);
			
			while(hashMap.get(currChar)>1) {
				hashMap.put(currChar, hashMap.get(currChar)-1);
				left++;
			}
			
			maxLength=Math.max(maxLength, right-left+1);
		}
		
		
		return maxLength;
	}
	
	
	/*
	 * Time complexity O(N)
	 * Space Complexity O(N)
	 * 
	 * identify unique substring between left and right pointer
	 * 
	 * abc (left=0 right=2)
	 * assume b appears now  in the input string 
	 * now left = lastseenPostionOfB+1 
	 * 
	 * left (2 right3)  
	 * 
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/5111376/video-3-ways-to-solve-this-question-sliding-window-set-hashing-and-the-last-position/
	 */
	
	private static int findMaxLengthOfSubStringUsingHashMap_V1(String s) {
		int maxLenght =0;
		int left=0;
		HashMap<Character, Integer> hashMap =  new HashMap<Character, Integer>();
		
		for(int right=0;right<s.length();right++) {
			Character currChar  = s.charAt(right);
			
			if(hashMap.containsKey(currChar) && hashMap.get(currChar)>=left) {
				left = hashMap.get(currChar)+1;
			}
			
			hashMap.put(currChar, right);
			maxLenght = Math.max(maxLenght, right-left+1);
			
		}
		
		return maxLenght;
	}
	
}

