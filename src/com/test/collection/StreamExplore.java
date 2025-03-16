package com.test.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stream to simplify processing of large collections in functional way
 * creating stream
 * intermediate operations
 * terminal operations
 */
public class StreamExplore {
	public static void main(String[] args) {
		
		//using List,Set
		List<String> namesList  = Arrays.asList("Ramesh","Suresh","Mahesh","Somesh");
		Stream<String> nameStream = namesList.stream();
		nameStream.forEach(System.out::println);
		
		
		//using Array
		String[] nums = {"A","B","C"};
		Stream<String> charStream = Arrays.stream(nums);
		charStream.forEach(System.out::println);
		
		Stream<Integer> numsStream = Stream.of(1,2,3,4,5,6);
		numsStream.forEach(System.out::println);
		
		Stream<Integer> infiniteStream = Stream.iterate(0, n->n+1);
		infiniteStream.limit(10).forEach(n-> System.out.print(n+" ,"));
		
		//Intermediate Lazy operated (not evaluated until terminal operations are called
		
//		numsStream.filter(n-> n%2==0).forEach(System.out::println);   
		//stream has already been operated upon or closed
		
		Stream
				.iterate(1, n->n+1)
				.limit(24)
				.filter(n->n%2==0)
				.forEach(System.out::println);
		
		Stream<String>  studentNames = Arrays.asList("Seeta","Geeta","Subhashini","Hashini").stream();
		
		studentNames
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
		//once a terminal operation performed that stream can't be reused
		
		Stream<String>  studentNamesStream = Arrays.asList("Seeta","Geeta","Subhashini","Hashini").stream();
		
		studentNamesStream
		.sorted()
		.forEach(System.out::println);
		
		
		Stream<String>  namesStream = Arrays.asList("Seeta","Geeta","Subhashini","Hashini","Seeta").stream();
		
		namesStream
		.distinct()
		.forEach(System.out::println);	
		
		
		//terminal operations
		
		List<String> studentNamesAsc = List.of("Ramesh","Suresh","Abhi","Sasi","Mahesh").stream()
					.sorted()
					.collect(Collectors.toList());
		
		Stream<Integer> numbersStream = Stream.iterate(1, n->n+1);
		
		int totalSum = numbersStream.limit(20).reduce(0, Integer::sum);
		System.out.println(totalSum);
		
		Stream<Integer> numStream = Stream.iterate(1, n->n+1);
		
//		Optional<Integer> minNumber = numbersStream.limit(31).min(Integer::compare);
		
		Optional<Integer> maxNumber = numStream.limit(10).reduce((a,b)->a<b?a:b);
		
		maxNumber.ifPresent(System.out::println);
		
//		Optional<Integer> maxNumber = Stream.iterate(1, n->n+1).limit(31).max(Integer::compare);
		
		
		final List<String> l = new LinkedList<>();

        l.add("A");
        l.add("B");
        l.add("C");

        l.stream().forEach(e -> {
//            l.add("Z");  //we will get ConcurrentModificationException
            System.out.println(e);
        });
        
        
    
        
        //reduce method to determine the maximum/minimum in give array
        //Binary Operator takes two parameter and combines them
        Stream<Integer> numbersExStream = Stream.of(23,1,31,3,19,7,45,8,-2);
        
        numbersExStream.reduce((a,b)-> a<b ? a:b).ifPresent(System.out::println);
        
        Stream<Integer> numbersXStream = Stream.of(23,1,31,3,19,7,45,8,-2);
		
        numbersXStream.reduce((a,b)->a>b?a:b).ifPresent(System.out::println);
        
        List<Integer> numbersListEx = List.of(23,1,4,9,-5,45,90,34);
        
        int totalSum1 = numbersListEx.stream().reduce(0,Integer::sum);
        
        System.out.println(totalSum1);
        
        //multiple all the numbers
        
        int multiVal = numbersListEx.stream().reduce(1, (a,b)-> a*b);
        
        System.out.println(multiVal);
         
	}
	
}
