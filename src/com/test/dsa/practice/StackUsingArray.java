package com.test.dsa.practice;

public class StackUsingArray {
	private int[] arr;
	private int top, capacity;
	
	StackUsingArray(int capacity){
		this.top = -1;
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	public void push(int data) {
		if(top >= capacity-1)
			System.out.println("Stack is overflow");
		else
			arr[++top] = data;
		System.out.println(arr[top]+" pushed to stack");
	}
	
	public int pop() {
		if(top<0) {
			System.out.println("Stack is underflow");
			return Integer.MIN_VALUE;
			}
		else
			return arr[top--];
	}
	
	public int peek() {
		if(top<0) {
			System.out.println("Stack is underflow");
			return Integer.MIN_VALUE;}
		else
			return arr[top];
	}
	public static void main(String[] args) {
		StackUsingArray stack  = new StackUsingArray(10);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());

	}

}
