package com.test.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GrouppingByExplore {
	public static void main(String[] args) {
		 String[] strs = {"eat","tea","tan","ate","nat","bat"};
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
