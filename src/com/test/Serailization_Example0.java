package com.test;
import java.io.*;

//Step 1: Create a Serializable class
class Employee1 implements Serializable {
 private static final long serialVersionUID = 1L;  // Ensure version consistency
 private String name;
 private int age;

 public Employee1(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public void display() {
     System.out.println("Employee Name: " + name + ", Age: " + age);
 }
}


public class Serailization_Example0 {
 public static void main(String[] args) {
     // Step 2: Define the file path where the object will be saved
     String filePath = "C:/Users/venka/Documents/employee.ser"; // Change path as needed

     Employee1 emp = new Employee1("Alice", 30); // Create an object

     // Step 3: Serialize the object and save to the file
     try (FileOutputStream fileOut = new FileOutputStream(filePath);
          ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

         out.writeObject(emp);
         System.out.println("Object serialized and saved at: " + filePath);

     } catch (IOException e) {
         e.printStackTrace();
     }

     // Step 4: Deserialize the object from the file
     try (FileInputStream fileIn = new FileInputStream(filePath);
          ObjectInputStream in = new ObjectInputStream(fileIn)) {

         Employee1 deserializedEmp = (Employee1) in.readObject();
         System.out.println("Deserialized Employee:");
         deserializedEmp.display();

     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
 }
}

