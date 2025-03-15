package com.test.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

//https://www.geeksforgeeks.org/comparator-interface-java/
class Student {
	private String name;
	private int age;
	
	Student(int age,String name){
		this.name=name;
		this.age=age;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"("+age+")";
	}
}

class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
//	@Override
//	public int compare(Student o1, Student o2) {
//		return o1.getAge()-o2.getAge();
//	}
	

}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int nameCompare = o1.getName().compareTo(o2.getName());
		int ageCompare = o1.getAge() - o2.getAge();
		
		//if name matches then compare age
		return nameCompare==0 ? ageCompare:nameCompare;
	}
	
}
public class ComparatorExplore {
	public static void main(String[] args) {
		
	
	List<Student> students = new ArrayList<>();
    
    // Add Elements in List
	  students.add(new Student(111, "Mayank"));
	  students.add(new Student(110, "Mayank"));
	  students.add(new Student(131, "Anshul"));
	  students.add(new Student(121, "Solanki"));
	  students.add(new Student(101, "Aggarwal"));
	  
//	  students.sort(new NameComparator());
	  
	  
	//above same thing can be done using lambda
//	  
//	  students.sort((s1,s2)->s1.name.compareTo(s2.name));
//	  students.sort((s1,s2)->Integer.compare(s1.age, s2.age));
//	  students.sort((s1,s2)-> s1.age-s2.age);
	  
//	  students.sort(new StudentComparator());
	  
	  System.out.println(students);
	  
	  
	  students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));
	  
	  System.out.println(students);
	  
	  
	  TreeSet<Student> treeSet = new TreeSet<Student>(new NameComparator());
	  treeSet.add(new Student(12,"Rita"));
	  treeSet.add(new Student(8,"Gita"));
	  
	  Comparator<Student> nameComparator = (s1,s2) -> s1.getName().compareTo(s2.getName());
	  Comparator<Student> ageComparator = (s1,s2) -> s1.getAge() - s2.getAge();
	  
	  System.out.println(treeSet);
	  
	  TreeSet<Student> treeSetEx = new TreeSet<Student>(nameComparator.thenComparing(ageComparator));
	  treeSetEx.add(new Student(12,"Seeta"));
	  treeSetEx.add(new Student(8,"Seeta"));
	  treeSetEx.add(new Student(23, "Ram"));
	  
	  System.out.println(treeSetEx);
	  
	  
	  
	  
	  Comparator<Student> nameAgeComparator = Comparator.comparing(Student::getName)
			  .thenComparing(Student::getAge);
	  
	  TreeMap<Student, String> treeMap = new TreeMap<Student, String>(nameAgeComparator);
	  
	  treeMap.put(new Student(19,"Rahul"), "SSC");
	  treeMap.put(new Student(13, "Mahesh"), "SSC");
	  treeMap.put(new Student(8,"Priya"), "3rd");
	  treeMap.put(new Student(15, "Mahesh"), "SSC");
	  
	  System.out.println(treeMap);
	  
	}
}
