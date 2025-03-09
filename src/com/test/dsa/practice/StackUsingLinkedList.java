package com.test.dsa.practice;
class Node {
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next =null;
	}
}
public class StackUsingLinkedList {
	Node head;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		System.out.println(head.data+" is pushed to stack");
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}else {
			Node temp = head;
			head = temp.next;
			System.out.println(temp.data+" is poped from stack");
			temp = null;
		}
	}
	
	public int peek() {
		if(!isEmpty()) {
			return head.data;
		}else {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		stack.pop();
	}
	
	
}
