package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * direct reference of subjects make mutable 
 */
final class Student {
    private final String name;
    private final List<String> subjects;  // Mutable field

    public Student(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;  // ❌ Direct reference assigned (Not safe)
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {  
        return subjects;  // ❌ Returns direct reference (Can be modified)
    }
}


public class Immutability_Example0 {
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");

        Student student = new Student("Alice", subjects);
        System.out.println(student.getSubjects()); // Output: [Math]

        // Modifying subjects list externally
        subjects.add("Science");
        System.out.println(student.getSubjects()); // ❌ Output: [Math, Science] (Modified!)
    }
}

