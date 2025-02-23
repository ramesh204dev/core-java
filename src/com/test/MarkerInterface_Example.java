package com.test;
import java.io.*;

class Employee implements Serializable {  // Implements marker interface
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class MarkerInterface_Example {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("Alice");

        // Serializing the object
        FileOutputStream fileOut = new FileOutputStream("employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(emp);
        out.close();
        fileOut.close();

        System.out.println("Object serialized successfully.");
    }
}

