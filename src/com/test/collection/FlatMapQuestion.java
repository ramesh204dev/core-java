package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PrivateEmployee {
	private int id;
	private String name;
	private String department;
	private int salary;
	private List<String> contactNumbers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<String> getContactNumbers() {
		return contactNumbers;
	}
	public void setContactNumbers(List<String> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
	public PrivateEmployee(int id, String name, String department, int salary, List<String> contactNumbers) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.contactNumbers = contactNumbers;
	}
	
}
public class FlatMapQuestion {
	public static void main(String[] args) {
		List<PrivateEmployee> employees = new ArrayList<>();
		employees.add(new PrivateEmployee(111, "Ramesh", "IT", 600000, Arrays.asList("111-000-0000","111-000-0001")));
		employees.add(new PrivateEmployee(222, "John", "FINANCE", 500000, Arrays.asList("222-000-0000","222-000-0001")));
		employees.add(new PrivateEmployee(333, "Mike", "HR", 300000, Arrays.asList("333-000-0000","333-000-0001")));
		
		List<String> phoneNumberList = employees.stream()
		.flatMap(e ->e.getContactNumbers().stream())
		.collect(Collectors.toList());
		
		System.out.println(phoneNumberList);

		
		String input  = "My Name is Ramesh";
		String[] inputArray = input.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=inputArray.length-1;i>=0;i--) {
			sb.append(inputArray[i]+" ");
		}
		
		System.out.println(sb.toString());
	}

}
