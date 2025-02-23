package com.test;

import java.util.ArrayList;
import java.util.List;

final class ImmutableStudent {
    private final String name;
    private final List<String> subjects;

    public ImmutableStudent(String name, List<String> subjects) {
        this.name = name;
        this.subjects = new ArrayList<>(subjects); // ✅ Defensive Copy in Constructor
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return new ArrayList<>(subjects); // ✅ Returning a Copy
    }
}

public class Immutability_JavaExmaple1 {
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");

        ImmutableStudent student = new ImmutableStudent("Alice", subjects);
        System.out.println(student.getSubjects()); // Output: [Math]

        // Trying to modify the list
        subjects.add("Science");  // External change

        System.out.println(student.getSubjects()); // ✅ Output: [Math] (Unchanged!)
    }
}
