package com.test.v1;

/*
 * Extending Exception class makes custom checked exception
 * needs be handled with try-catch or throws
 * IOException
 * SQLException
 * InterruptedException
 */
class InvalidAgeException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String message) {
		super(message);
		
	}
}

/*
 * Extending RuntimeException class makes custome unchecked exception
 * no needs to be handled at compile time
 * ArrayIndexOutOfBoundsException
 * ArithmeticException
 * NullPointerException
 */
class NegativeAmountException extends RuntimeException{
	
	public NegativeAmountException(String message) {
		super(message);
		
	}
}

public class UserExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		withDrawAmount(-10);
		
		try {
			CalculateAge(17);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}
	}

	private static void CalculateAge(int age) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("Age is less than 18 , Not allowed");
		}
		System.out.println(age);
	}
	
	private static void withDrawAmount(double amount) {
		if(amount<0) {
			throw new NegativeAmountException("Negative amount can't be allowed");
		}
		System.out.println(amount);
	}
}
