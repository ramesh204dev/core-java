package com.test.dsa.practice;

public class Queue {
	private Node front,rear;
	
	Queue(){
		front=rear=null;
	}
	
	
	public void enqueue(int data) {
		Node new_node = new Node(data);
		if(rear==null) {
			rear = new_node;
		}else {
			rear.next = new_node;
			rear = new_node;
		}
	}
	
	public void dequeue() {
		if(isEmpty())
			System.out.println("Queue is underflow");
		else {
			front  = front.next;
		}
		
		if(front==null)
			rear =null;
			
	}
	
	public boolean isEmpty() {
		return front==null && rear==null;
	}
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);

	}

}
