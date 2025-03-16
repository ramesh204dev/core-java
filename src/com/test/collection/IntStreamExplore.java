package com.test.collection;

import java.util.stream.IntStream;

/*
 * IntStream is a specialised stream that handles primitive int values , avoids boxing overahead
 */
public class IntStreamExplore {
	
	public static void main(String[] args) {
		
		//creating intstream
		IntStream numbers = IntStream.of(1,3,4,5,6,2,7);
		
		//exclude upperbound
		IntStream intStreamExcludesUpperBound = IntStream.range(1, 100);
		intStreamExcludesUpperBound.sum();
		
		IntStream intStreamIncludesUpperBound  = IntStream.rangeClosed(1, 100);
		intStreamIncludesUpperBound.average();
		
		IntStream infinteIntStream  = IntStream.generate(()-> (int) Math.random()*10).limit(30);
		infinteIntStream.forEach(System.out::println);
		
		IntStream infinteEvaluate = IntStream.iterate(0, n->n+1).limit(25);
		infinteEvaluate.mapToDouble(n->n*0.5).forEach(System.out::println);
		
		
		IntStream intReduce = IntStream.rangeClosed(1, 12);
		System.out.println(intReduce.reduce(0,(a,b)->a+b));
		
		IntStream intRange = IntStream.of(5,-3,25,3,21,-14,22,0,-9,57);
		
		int max  = intRange.max().orElseThrow();	
	}
}
