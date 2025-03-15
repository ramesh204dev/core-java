package com.test.v2;

class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

class LinkedList {
	Node head;
	
	public void add(int data) {
		Node new_node = new Node(data);
		
		if(head==null) {
			head =new_node;
			return;}
		
		Node temp = head;
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		temp.next = new_node;
	}
}
public class LinkedListHelper {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		
		int postion = 1;
		
		Node temp = ll.head;
		
		System.out.println("Original LinkedList");
		int count =0;
		while(temp!=null) {
			count++;
			System.out.print(temp.data+ " -->");
			temp = temp.next;
			
		}
		
		
		int n = count -postion-1;
		
		Node kNode = ll.head;
		
		for(int i=0;i<n;i++) {
			kNode = kNode.next;
		}
		
		Node trav = ll.head;
		for(int i=0;i<postion;i++) {
			trav = trav.next;
		}
		
		//swap the values
		int tempData = kNode.data;
		kNode.data = trav.data;
		trav.data=tempData;
		
		System.out.println("Swapped LinkedList");
		Node printNode = ll.head;
		
		while(printNode.next!=null) {
			System.out.print(printNode.data+" -->");
			printNode = printNode.next;
		}
		
		System.out.println(printNode.data+" --> Null");
		
		
		kthNodeSwap(ll, 2);
		System.out.println("Swapped LinkedList");
		Node print = ll.head;
		while(print.next!=null) {
			System.out.print(print.data+" -->");
			print = print.next;
		}
		
		System.out.println(print.data+" --> Null");
		
	}
	
	
	private static void kthNodeSwap(LinkedList linkedList,int postion) {
		
		//calculate number of nodes in given linkelist
		Node temp = linkedList.head;
		int length =0;
		while(temp!=null) {
			length++;
			temp = temp.next;
		}
		
		
		Node first=linkedList.head, second=linkedList.head;
		
		for(int i=0;i<postion;i++) {
			first = first.next;
		}
		
		for(int j=0;j<length-postion-1;j++) {
			second = second.next;
		}
		
		//swap data of nodes
		int tempData = second.data;
		second.data = first.data;
		first.data = tempData;
		
	}
}
