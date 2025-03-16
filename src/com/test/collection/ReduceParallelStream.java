package com.test.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class Employee {
	private String name;
	private double salary;
	
	Employee(String name, double salary){
		this.name=name;
		this.salary=salary;
	}
	
	public String getName() { return name;}
	public void setName(String name) {this.name=name;}
	
	public double getSalary() { return salary;}
	public void setSalary(double salary) { this.salary=salary;}
	
	@Override
	public String toString() {
		return name+" "+"("+salary+")";
	}
}
public class ReduceParallelStream {
	 public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
		            new Employee("Alice", 50000),
		            new Employee("Bob", 70000),
		            new Employee("Charlie", 60000),
		            new Employee("David", 90000)
		        );
		 
		 // Finding the Employee with the Highest Salary
		 // T reduce(BinaryOperator<T>) 
		 
		Optional<Employee> highestPaidEmp = employees.stream().reduce(
				 (e1,e2)-> e1.getSalary() > e2.getSalary() ? e1:e2);
		
		highestPaidEmp.ifPresent(System.out::println);
		
		
		Optional<Double> totalEmpSalary= employees.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		
		totalEmpSalary.ifPresent(System.out::println);
		
		//imagine Employee is large dataset we can use parallelStream
		/*
		 * <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
		 */
		
		employees.parallelStream().reduce(0.0, //identity
				(sum,e1)->sum+e1.getSalary(), //Accumulator
				Double::sum); //combiner
		
		/*
		 * parallelStream(): Enables multi-threading.
		Accumulator (sum + emp.getSalary()): Adds employee salaries within each thread.
		Combiner (Double::sum): Merges results between parallel threads.
		Output remains accurate, but execution is faster for large datasets.
		 */
	}
}
