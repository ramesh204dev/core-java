package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamPerformance {
	public static void main(String[] args) {
		
		List<Integer> intList  = new ArrayList<Integer>();
		for(int i=0;i<1_000_000;i++)
			intList.add(i);
		
		long start = System.currentTimeMillis();
		intList.stream().map(n->n*2).count();
		System.out.println("Sequnetial Processing Time "+ (System.currentTimeMillis()-start)+" ms");
		
		start = System.currentTimeMillis();
		intList.parallelStream().map(n->n*2).count();
		System.out.println("Parallel Processing Time "+ (System.currentTimeMillis()-start)+" ms");
		
		//parallel stream are useful for larger data but slower for smaller data due to overhead
		
		
		List<List<String>>  listOfList = Arrays.asList(
				Arrays.asList("Abhi","Aaksh","Suresh","Somesh","Venkatesh"),
				Arrays.asList("Seeta","Geeta","Ganga","Sravani"),
				Arrays.asList("Chintu","Bantu","Rohan"));
		
		List<String>  list = listOfList.stream()
					.flatMap(List::stream)
					.sorted()
					.collect(Collectors.toList());  //unorderedList
		
		System.out.println(list);
		
		
		Map<Character,List<String>> startLetterNamesMap = list.stream()
				.collect(Collectors.groupingBy(name->name.charAt(0)));
		
		System.out.println(startLetterNamesMap);
	
	}
}
