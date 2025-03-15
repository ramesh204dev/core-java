package com.test.exercise;

public class ReverseGivenString {
	public static void main(String[] args) {
		String input = "My Name is Ramesh";
		String[] temp = input.split(" ");
		StringBuilder result = new StringBuilder();
		for(int i=temp.length-1; i>=0;i--) {
			result.append(temp[i]+" ");
		}
		
		System.out.println(result.toString());
	}
}
