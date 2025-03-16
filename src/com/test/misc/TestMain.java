package com.test.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMain {
	public static void main(String[] args) {
		String s1 = "abt";
		String s2 = "bat";
				
//		System.out.println(s1.hashCode()+" "+s2.hashCode());
		
		 String[] strs = {"eat","tea","tan","ate","nat","bat"};
		 HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		 
		 for(String s : strs) {
			 char[] chars = s.toLowerCase().toCharArray();
			 Arrays.sort(chars);
			 String key = new String(chars);
			 
			 if(!map.containsKey(key))
				 map.put(key, new ArrayList<String>());
			 
			 map.get(key).add(s);
			 
		 }
		 
		 System.out.println(map.values());
		 
		 
		Map<String,List<String>> hashMap =  Arrays.stream(strs)
		 	.collect(Collectors.groupingBy(
		 			str -> {
		 			char[] chars = str.toLowerCase().toCharArray();	
		 			Arrays.sort(chars);
		 			return new String(chars);
		 			}
		 			));
		
		System.out.println(hashMap);
		
		
		
		//custom key value in group by condtion
		
	Map<Integer,Set<String>> mapOflengthWithStringSet =	Arrays.stream(strs)
		.collect(Collectors.groupingBy(
				String::length,
				Collectors.toSet()
				));
	
	System.out.println(mapOflengthWithStringSet);
	
	
	
	 List<String> words = Arrays.asList("apple", "bat", "cat", "banana", "dog", "ant");
	 
	Map<Character,List<String>> customKeyAndValueInGrouppingBy = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0),
			 Collectors.mapping(String::toUpperCase, Collectors.toList())
			 ));
	
	System.out.println(customKeyAndValueInGrouppingBy);
	
	Map<Integer,Map<Character,Set<String>>> nestedMap = 
	words.stream().collect(Collectors.groupingBy(
			String::length,
			Collectors.groupingBy(w->w.charAt(0),Collectors.toSet())
			));
	
	
	System.out.println(nestedMap);
	}
}
