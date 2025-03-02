package com.test.dsa;

public class Stack_UsingArray {
	public static void main(String[] args) {
		Stack customStack = new Stack();
		customStack.push(10);
		customStack.push(-12);
		customStack.push(-98);
		
		System.out.println(customStack.pop());
		
		System.out.println(customStack.peek());
		
		System.out.println(customStack.peek());
		
		customStack.push(25);
		
		System.out.println(customStack.pop());
	}
}


/*
 * stack implementation using array 
 * push 
 * pop
 * peek
 * isEmpty
 * print
 */
class Stack {
	
	int maxStackSize = 1000;
	int top;
	int[] arr = new int[maxStackSize]; //initialize array with fixed size of 1000
	Stack() {
		top = -1;
	}
	
	boolean isEmpty() {
		return top<0 ? true: false;		
	}
	
	boolean push(int x) {
		
		if(top>=maxStackSize-1) {
			System.out.println("Stack is Overflow");
			return false;
		}else {
			arr[++top] =x;
			System.out.println("Element "+x+" is pused to stack");
			return true;
		}
	}
	
	
	int pop() {
		if(top<0) {
			System.out.println("Stack is underflow");
			return 0;
		}else {
			int x = arr[top--];
			System.out.println("Element "+x+" is poped from stack");
			return x;
		}
	}
	
	
	int peek() {
		if(top<0) {
			System.out.println("Stack is underflow");
			return 0;
		}else {
			int x = arr[top];
			System.out.println("Element "+x+" is peeked from stack");
			return x;
		}
	}
	
	
	void print() {
		for(int i=top;i<-1;i--) {
			System.out.println(arr[i]);
		}
	}
	
	
}