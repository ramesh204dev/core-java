package com.test;
class Address{
	private String city;
	Address(String city){
		this.city=city;
	}
	public String getCity() {return city;}
	public void setCity(String city) {this.city=city;}
}
final class Person{
	private final String name;
	private final Address address;
	Person(String name,Address address){
		this.name=name;
		this.address=address; // // ❌ Direct assignment (Not safe)
	}
	
	public String getName() { return name;}
	public Address getAddress() {return address;} // ❌ Exposes the mutable object
}
public class Immutable_Java_Example2 {
	
	public static void main(String[] args) {
		Address address = new Address("Hyderabad");
		Person person = new Person("Suresh",address);
		System.out.println(person.getAddress().getCity()); //Hyderabad 
		address.setCity("Bangalore");
		System.out.println(person.getAddress().getCity()); //Bangalore 
	}
}
