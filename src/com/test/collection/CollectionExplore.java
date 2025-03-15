package com.test.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class CustomData {
    @Override
    public int hashCode() {
        return 0;
        }
}

class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {return name;}
	public void setName(String name) { this.name=name;}
	
	public int getAge() { return age;}
	public void setAge(int age) { this.age=age;}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null ||  getClass()!=obj.getClass()) return false;
		Person person = (Person) obj;
		return name.equals(person.name) && age==person.age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}
	
	@Override
	public String toString() {
		return name + "(" +age+ ")";
	}
}
public class CollectionExplore {
	public static void main(String[] args) {
		
		// set stores unique values
		// equals method determine uniqueness
		// hashcode determine the segment index to store
		//Best for fast operations (O(1) for add, remove, contains
		Set<String> hashset = new HashSet<String>();
		hashset.add("ramesh");
		hashset.add("suresh");
		hashset.add("mahesh");
		hashset.add("suresh");
		hashset.add(null);
		
		System.out.println(hashset);
		
		
		//maintains insertion order
		
		Set<String> linkedHashset = new LinkedHashSet<String>();
		linkedHashset.add("ramesh");
		linkedHashset.add("suresh");
		linkedHashset.add("mahesh");
		linkedHashset.add("suresh");
		linkedHashset.add(null);
		
		System.out.println(linkedHashset);
		
		
		//maintains natural sorting order O(logN)
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(25);
		treeSet.add(31);
		treeSet.add(25);
		treeSet.add(12);
//		treeSet.add(null); //not allowed for treeset
		
		System.out.println(treeSet);
		
		//custom set implementation of Person which already overrides equals() and hashcode() 
		
		Set<Person> personsSet = new HashSet<Person>();
		personsSet.add(new Person("Ram", 25));
		personsSet.add(new Person("Shyam", 26));
		personsSet.add(new Person("Sita", 19));
		personsSet.add(new Person("Ram", 25));
		
		System.out.println(personsSet);
		
		
		//hashCode() determines the bucket where the object is stored.
		// equals() checks if two objects are actually equal.
		
		
	     Set<CustomData> set = new HashSet<>();
	     CustomData customData = new CustomData();
//	     System.out.println(customData.hashCode());
	        set.add(customData);
	        set.add(customData);
	        set.add(new CustomData());
	        set.add(new CustomData());
	        

	        System.out.println(set.size());
		
	        
	        
	     
	}
}
