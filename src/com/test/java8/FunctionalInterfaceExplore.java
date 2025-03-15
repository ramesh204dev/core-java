package com.test.java8;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface MyFucntionalInterface<T extends Number> {
	int calculate(int num); //single abstract method
	
//	void isEven();  compliation error @FunctionalInterface ensures single abstract method defined in interface
	default void print() {
		System.out.println("default method");
	}
	
	static void publish() {
		System.out.println("staic method");
	}
}

public class FunctionalInterfaceExplore {
	
	
	
	public static void main(String[] args) {
		
		MyFucntionalInterface<Integer> myLambda = num ->  num+10;
		
		System.out.println(myLambda.calculate(20));
		
		
		//functional interface Predicate<T>, Tests a condition , it has  boolean test(T t) method defined
		Predicate<Integer> isEven = num -> num % 2 == 0;
		
		Predicate<Integer> isGreaterThan10 = num -> num >10;
		
		isEven.test(31); //false
		isGreaterThan10.test(11); //true
		
		isEven.and(isGreaterThan10).test(44); //true
		
		isEven.or(isGreaterThan10).test(8); //false
		
		isEven.negate().test(9); //true
		
		Predicate<Integer> isEvenAndGreaterThan10 = isEven.and(isGreaterThan10);
		
		isEvenAndGreaterThan10.test(24); //true
		
		// Function<T,R> , transforms data , takes T as input and transforms to output R  , it has R apply(T) method
		Function<String, Integer> strLength =  s -> s.length();
		strLength.apply("I'm Ramesh"); // calculates all the chars returns 10
		
		Function<Integer,Integer>  square  = num -> num*num;
		
		Function<Integer,Integer> doubleIt = num -> num*2;
		
		square.andThen(doubleIt).apply(3);  // 3*3 =9  9*2=18 returns 18
		
		square.compose(doubleIt).apply(3);  // 3*2=6 6*6=36 returns 36
		
		
		//Consumer<T> , void accept(T) - it does operations but returns nothing  - performs an action 
		Consumer<String> printString = s -> System.out.println("Input String ::: "+s);
		
		printString.accept("Learning");
		
		Consumer<String> toLowerCase = s -> System.out.println(s.toLowerCase());
		Consumer<String> toUpperCase  = s -> System.out.println(s.toUpperCase());
		
		Consumer<String> stringObs = toLowerCase.andThen(toUpperCase);
		
		stringObs.accept("Java");  
		
		
		
		//Supplier<T> , T get() , supplies type T without any input , supplies value
		Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(12);
		
		randomIntegerSupplier.get(); //returns some random integer
		
		BiPredicate<Integer, Integer>  numBiPredicate = (a,b) -> a+b % 2==0 ;
		
		numBiPredicate.test(20, 17); //test condition return boolean
		
		BiFunction<String, Integer, String> strBiFunction = (s1,intg) -> s1+intg ;
		
		strBiFunction.apply("Sam", 24); //concatenates and return Sam24
		
		
		BiConsumer<String,Integer> biConsumer = (s1,intg) ->
		System.out.println("Given String "+s1.toUpperCase() +" Integer"+intg+100)  ;
		
		biConsumer.accept("Krishna", 28);
		
		
		
		
	}
}

