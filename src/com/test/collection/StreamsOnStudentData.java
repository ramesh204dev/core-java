package com.test.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class StudentStream {
	String firstName, lastName, city, department;
    double grade;
    int age;
	public StudentStream(String firstName, String lastName, String city, double grade, int age, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.department = department;
		this.grade = grade;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + city + ", " + grade + ", " + age + ", " + department + ")";
    }

}
public class StreamsOnStudentData {
	public static void main(String[] args) {
		   List<StudentStream> students = Arrays.asList(
		            new StudentStream("John", "Smith", "Miami", 8.38, 19, "Civil"),
		            new StudentStream("Mike", "Miles", "New York", 8.4, 21, "IT"),
		            new StudentStream("Michael", "Peterson", "New York", 7.5, 20, "Civil"),
		            new StudentStream("James", "Robertson", "Miami", 9.1, 20, "IT"),
		            new StudentStream("John", "Miller", "Miami", 7.83, 20, "Civil")
		        );
		   
		   // 1. Find students from Miami with a grade greater than 8.0
	List<StudentStream>	miamiStudents =   students.stream().filter(s->s.getCity().equals("Miami"))
			.collect(Collectors.toList());
	System.out.println(miamiStudents);
	
	   // 2. Find the student with the highest grade
	//Optional class introduced in java 8 to handle NPE null pointer error 
	// isPresent Optional.ofNullable() safe way to handle NPE
	Optional<StudentStream> student =
			students.stream().max(Comparator.comparingDouble(StudentStream::getGrade));
	
	System.out.println(student.orElse(null));
		   
	 // 3. Count the number of students in each department
	Map<String,Long> studentCountPerDepart = students.stream().collect(Collectors.groupingBy(StudentStream::getDepartment,Collectors.counting()));
	System.out.println(studentCountPerDepart);
	
	  // 4. Find the average grade per department
	Map<String,Double> avgGradePerDepart = students.stream().collect(
			Collectors.groupingBy(StudentStream::getDepartment,Collectors.averagingDouble(StudentStream::getGrade)));
	System.out.println(avgGradePerDepart);
	
	 // 5. List students sorted by age and then by grade
	List<StudentStream> sortedStudList  = students.stream()
			.sorted(Comparator.comparingInt(StudentStream::getAge)
					.thenComparingDouble(StudentStream::getGrade)).collect(Collectors.toList());
	
	System.out.println(sortedStudList);
	
	 // 6. Create a comma-separated list of student names
	String names  = students.stream().map(s->s.getFirstName()+" -"+s.getLastName())
			.collect(Collectors.joining(","));
	System.out.println(names);
	
	  // 7. Check if all students are above 18
	Boolean studentAgeCheck = students.stream().allMatch(s->s.getAge()>18);
	System.out.println(studentAgeCheck);
	
	 // 8. Find the department with the most students
	String mostStudentDept = students.stream()
	.collect(Collectors.groupingBy(StudentStream::getDepartment,Collectors.counting()))
	.entrySet()
	.stream()
	.max(Map.Entry.comparingByValue())
	.map(Map.Entry::getKey)
	.orElse("None");
	
	System.out.println(mostStudentDept);
	
	
	 // 9. Divide students into those who have grades above 8.0 and below
	Map<Boolean,List<StudentStream>> gradeSplit =  students.stream()
		.collect(Collectors.partitioningBy(s->s.getGrade()>8));
	System.out.println(gradeSplit);
	
	// 10. Find the student with the longest full name
	Optional<StudentStream> longestFullNameStudent = students.stream()
	.max( Comparator.comparingLong( s-> (s.getFirstName()+s.getLastName()).length()));
	
	System.out.println(longestFullNameStudent);
	}
	
	
}
