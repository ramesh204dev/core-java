package com.test.dsa;

public class DoublyLinkedList {
	private Node head;
	
	public void insertAtHead(int data) {
		Node new_node = new Node(data);
		if(head==null) {
			head = new_node;
			return;
		}else {
			new_node.next=head;
			head.prev= new_node;
		}
		
		head = new_node;
	}
	
	
	public void insertAtEnd(int data) {
		Node new_node = new Node(data);
		if(head==null) {
			head = new_node;
			return;
		}else {
			Node temp = head;
			
			while(temp.next!=null) {
				temp = temp.next;
			}
			
			//temp is last node 
			temp.next = new_node;
			new_node.prev=temp;
			return;
		}
	}
	
	public void deleteANode(int data) {
		if(head==null) {
			System.out.println("Doubly LinkedList is empty, nothing to delete");
			return;
		}else {
			Node temp = head;
			while(temp!=null&&temp.data!=data) {
				temp = temp.next;
			}
			
			if(temp==null) { System.out.println("Node with "+data+" not found"); return;}
			//found temp which is the deleted node
			if(temp.prev!=null) temp.prev.next = temp.next;
			if(temp.next!=null) temp.next.prev = temp.prev;
			return;
			
		}
	}
	
	// while(temp!=null) since lastnode.next is null
	public void displayForward() {
		Node temp = head;
		if(temp==null) {
			System.out.println("Doubly LinkedList is empty");
		}else {
			while(temp !=null) {
				System.out.print(temp.data+" ⇄");
				temp = temp.next;
			}
			
			System.out.println(" null");
			
		}
	}
	
	
	//inorder to reach last node -->temp.next is null so temp is our last node
	//we got the temp so traverse using Node.prev pointer
	public void displayBackward() {
		Node temp = head;
		if(temp==null) {
			System.out.println("Doubly LinkedList is empty");
		}else {
			
			while(temp.next!=null)
				temp=temp.next;
			
			//reached the end of doubly linked list
			
			while(temp!=null) {
				System.out.print(temp.data+" ⇄");
				temp = temp.prev;
			}
			
			System.out.println(" null");
		}
	}
	
	public int length() {
		int length=0;
		if(head==null) {return length;}
		else {
			Node temp = head;
			while(temp!=null) {
				length++;
				temp = temp.next;
				
			}
		}
		return length;
	}
	
	public void deleteNodeAtPostion(int postion) {
		if(head==null) { 
		System.out.println("DBLL is empty , nothing to delete");
		return;
		}
		
		Node temp = head;
		for(int i=1;temp!=null && i<postion;i++) {
			temp = temp.next;
		}
		
		//given position not in the range
		if(temp==null)
			return;
		
		if(temp.prev!=null)
			temp.prev.next = temp.next;
		
		if(temp.next!=null)
			temp.next.prev = temp.prev;
		
		if(temp==head)
			head = temp.next;
		return;
		
	}
	
	public void reverse() {
		if(head==null) return;
		Node curr = head, prev=null;
		
		while(curr!=null) {
			prev  = curr.prev; //saving the current node previous 
			
			//reverse the link
			//prev point to next , next point to current swap
			curr.prev = curr.next;
			curr.next = prev;
			
			
			//move to next node
			curr = curr.prev;
			
			
			
		}
		
		head = prev.prev;
		return;
		
		
	}
	public static void main(String[] args) {
		DoublyLinkedList dblLinkedList = new DoublyLinkedList();
		
		dblLinkedList.insertAtHead(2);
		dblLinkedList.insertAtHead(5);
		dblLinkedList.displayForward();
		System.out.println("length of DBLL : "+ dblLinkedList.length());
		
		dblLinkedList.displayBackward();
		
		dblLinkedList.insertAtEnd(7);
		dblLinkedList.insertAtEnd(14);
		dblLinkedList.displayForward();
		
		dblLinkedList.deleteANode(0);
		dblLinkedList.deleteANode(14);
		
		dblLinkedList.displayForward();
		
		dblLinkedList.deleteNodeAtPostion(4);
		dblLinkedList.displayForward();
		
		dblLinkedList.reverse();
		dblLinkedList.displayForward();
		
	}
}
