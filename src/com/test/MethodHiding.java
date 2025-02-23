package com.test;

class Bank {
	static double intrestRate = 0.5;
	
	static  double calculateIntrest(double amount) {
		return amount*intrestRate;
	}
	
	
}

class SavingsAccount extends Bank{
	static double intrestRate = 0.9;
	
	static double calculateIntreset(double amount) {
		return amount*intrestRate;
	}
}

public class MethodHiding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Even though bank refers to SavingsAccount, 
		 * the static method from Bank is called, proving that static methods are not overridden but hidden.
		 */
		Bank savingBank = new SavingsAccount();
		System.out.println(savingBank.calculateIntrest(1000));
		
		SavingsAccount savingAcc = new SavingsAccount();
		System.out.println( savingAcc.calculateIntreset(1000));

	}

}
