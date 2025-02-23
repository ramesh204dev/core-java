package com.test;

final class ImmutablePerson{
	private final String name;
	private final Address address;
	public ImmutablePerson(String name,Address address) {
		this.name=name;
		this.address=new Address(address.getCity());
	}
	public String getName() {return name;}
	public Address getAddress() {return new Address(address.getCity());};
}
public class Immutability_JavaExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address = new Address("Hyderabad");
		ImmutablePerson person = new ImmutablePerson("Suresh", address);
		System.out.println(person.getAddress().getCity());
		
		address.setCity("Bangalore");
		System.out.println(person.getAddress().getCity());
		
		
		String test = "Hello";
		test.concat(" World");  //creates a new String original Str is not modified since String Object is immjutable
		System.out.println("test");
		
		test = test.concat(" World"); //reference is given for newly object
		System.out.println(test);
	}

}
