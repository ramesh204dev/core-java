package com.test.dsa;

public class Queue_UsingArray {
	public static void main(String[] args) {
		Queue queue = new Queue(10);
		queue.enqueue(4);
		queue.enqueue(12);
		queue.enqueue(25);
		
		System.out.println(queue.size());
		queue.printQueue();
	}

}

//FIFO
class Queue {
	private int capacity;
	private int[] queue;
	private int front;
	private int rear;
	
	public Queue(int capacity){
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.rear =-1;	
		this.front=0;
	}
	

	
	public boolean isFull() {
		return rear<=(capacity-1);
	}
	
	//adds element to the queue
	public void enqueue(int x) {
		if(isFull()) {
			System.out.println("Queue is overflow");
			return;
		}
		
		queue[++rear]=x;
	
	}
	
	//removes front 
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is underflow");
			return -1;
		}
		int x  = queue[front];
		
		for(int i=0;i<rear;i++) {
			queue[front]=queue[i+1];
		}
		rear--;
		return x;
	}
	
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is underflow");
			return -1;
		}
		return queue[front];
	}
	
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is underflow");
			return;
		}
		
		for(int i=0;i<=rear;i++) {
			
			System.out.print(queue[i]+" ");
		}
	}
	
	  // Check if the queue is empty
    public boolean isEmpty() {
        return rear < front;
    }

    // Get the size of the queue
    public int size() {
        return rear - front + 1;
    }
	
}
