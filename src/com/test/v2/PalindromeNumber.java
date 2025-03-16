package com.test.v2;

import java.util.HashMap;
import java.util.Map;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		int num= 121;
		int sum =0;
		
		while(num!=0) {
			sum = sum *10 + num % 10;
			num = num/10;
		}
		
		System.out.println(sum);
		
		palindromString("aba");
		
		System.out.println(validAnangram("aba", "abc"));
		
		System.out.println(validAnangram_better("aba", "abc"));
	}
	
	
	private static void palindromString(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		
		StringBuilder str = new StringBuilder();
		
		for(int j=s.length()-1;j>=0;j--) {
			str.append( chars[j]);
		}
		
		System.out.println(str);
		
	}
	
	
	private static boolean validPalindrome(String s) {
		String str = s.replaceAll("[^a-zA-Z-0-9]", "");
		char[]  chars = s.toLowerCase().toCharArray();
		
		for(int i=0,j=chars.length-1;i<=j;i++,j--) {
			
			if(chars[i]!=chars[j])
				return false;
		}
		
		return true;
		
	}
	
	
	//Hashmap for maintaing the frequency of each character in given /test strings
	// time complexity O(N) and space complexity O(N)
	private static boolean validAnangram(String s1,String s2) {
		
		if(s1.length()!=s2.length()) return false;
		
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		for(int i=0;i<s1.length();i++) {
			counter.put(s1.charAt(i), counter.getOrDefault(s1.charAt(i), 0)+1);
		}
		
		
		for(int i=0;i<s2.length();i++) {
			
			if(!counter.containsKey(s2.charAt(i)) || counter.get(s2.charAt(i))==0)
				return false;
			
			counter.put(s2.charAt(i), counter.getOrDefault(s2.charAt(i), 0)-1);
		}
		
	
			
		return true;
	}
	
	//using ASCII 
	// fixed size array since letters available are from a-z 
	private static boolean validAnangram_better(String s1,String s2) {
	
		
		if(s1.length()!=s2.length()) return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		//since string containts a-z create an array of size 26
		int[] alphabets = new int[26];
		
		
		//update the frequency of each chars of given string
		for(int i=0;i<s1.length();i++)
			alphabets[s1.charAt(i)-'a']++;
		
		
		///update the frequency of each chars of test string
		for(int i=0;i>s2.length();i++) {
			
			if(alphabets[s2.charAt(i)-'a']==0)
				return false;
			
			alphabets[s2.charAt(i)-'a']--;
		}
		
		
		//if its anangram all the index values are 0 only 
		for(int i:alphabets) {
			if(i!=0) return false;
		}
		return true;
	}
}
