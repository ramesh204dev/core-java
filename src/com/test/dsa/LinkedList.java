package com.test.dsa;

public class LinkedList {
	Node head;
	
	public void add(int data) {
		Node new_node = new Node(data);
		
		//check for head is null
		if(head==null) {
			head = new_node;
			System.out.println("data "+data+" added to linkedlist");
			return;
		}
		
		//traverse the linked list to reach lastnode
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		//found temp-->null
		temp.next=new_node;
		System.out.println("data "+data+" added to linkedlist at end");
		return;
	}
	
	public void delete(int data) {
		if(head==null) return; //empty List
		
		//remove the head and point head -->head.Nexts
		if(head.data==data) {
			head =  head.next;
			System.out.println("data "+data+" deleted from linkedlist");
			return;
		}
		
		Node temp = head;
		
		while(temp.next!=null && temp.next.data!=data) {
			temp = temp.next;
		}
		
		if(temp.next==null) {
			System.out.println("data "+data+" is not present in linkedlist");
			return;
		}
		
		//found temp whose temp.next.data is matching with our data
		//removing node temp.next
		//point the temp.next to deletedNode.next (temp.next.next)
		temp.next = temp.next.next;
		System.out.println("data "+data+" deleted from linkedlist");
		return;
	}
	
	public void display() {
		if(head==null) {
			System.out.println("LinkedList is empty");
			return;
		}
		Node temp = head;
		while(temp.next!=null) {
			System.out.print(temp.data+" -->");
			temp= temp.next;
		}
		
		System.out.println(temp.data+" -->null");
	}
	
	
	public int length() {
		if(head==null) return 0;
		int size =1;
		Node temp = head;
		
		
		while(temp.next!=null) {
			size++;
			temp = temp.next;
		}
		
		return size;
		
	}
	
	
	//Insert a Node after a Given Node in Linked List
	public void addAfterAtGiveNode(int data,Node node) {
		if(head==null) {
			System.out.println("linkedlist is empty, not adding the given node ");
			return;
		}
		
		Node new_node  = new Node(data);
		
	
		
		if(head.data==node.data) {
			new_node.next = head.next;
			head.next = new_node;
			System.out.println("data "+data+" is added to head");
			return;
		}
		
		
		Node temp = head;
		while(temp.next!=null && temp.data!=node.data) {
			temp = temp.next;
		}
		
		if(temp.next==null&& temp.data!=node.data) {
			System.out.println("Given node "+node.data+" is not found in linkedlist, not adding the giving node");
			return;
		}
		
		new_node.next = temp.next;
		temp.next=new_node;
		System.out.println("data "+data+" is added to the given node"+temp.data);
		return;
		
	}
	
	
	// Insert a Node before a Given Node in Linked List
	public void addBeforeAtGiveNode(int data,Node node) {
		if(head==null) {
			System.out.println("linkedlist is empty, not adding the given node ");
			return;
		}
		
		Node new_node  = new Node(data);
		
		if(head.data==node.data) {
			new_node.next= head;
			head = new_node;
			System.out.println("data "+data+" is added before head");
			return;
		}
		
		Node temp = head;
		Node before =null;
		while(temp.next!=null && temp.data!=node.data) {
			 before = temp;
			temp =temp.next;
		}
		
		if(temp.next==null && temp.data!=node.data) {
			System.out.println("Given node "+node.data+" is not found in linkedlist, not adding the giving node");
			return;
		}
		
		new_node.next=temp;
		before.next=new_node;
		System.out.println("data "+data+" is added before node "+temp.data);
		return;
		
	}
	
	
	public void addNodeAtBegining(int data) {
		Node new_node = new Node(data);
		if(head==null) {
			head = new_node;
			return;
		}
		
		Node temp = head;
		head = new_node;
		new_node.next = temp;
		System.out.println("data "+data+" added to linkedlist at begining");
		return;
	}
	
	
	//Deletion at the Beginning of Linked List
	public void deleteNodeAtBegining() {
		if(head==null) {
			System.out.println("LinkedList is empty");
			return;
		}
		
		if(head.next==null) {
			System.out.println("LinkedList contains one node which is head and deleted");
			head =null;
			return;
		}
		
		head = head.next;
		System.out.println("head is deleted and new head started from data "+head.data);
		return;
	}

	//Deletion at Specific Position of Linked List
	public void deleteNodeAtPostion(int position) {
		if(head==null) {
			System.out.println("LinkedList empty , nothing can be deleted");
			return;
		}
		
		if(position==1) {
			head = head.next;
			System.out.println("Node at postion 0 is removed");
			return;
		}
		
		Node temp = head;
		Node prev = null;
		
		for(int i=1;temp!=null && i<position;i++) {
			prev = temp;
			temp = temp.next;
		}
		
		//reached to required postion
		if(temp!=null) {
		prev.next = temp.next;
		System.out.println("Node at postion "+position+" is removed");
		return;
		}else {
			System.out.println("Given Postion "+position+" is more than length of LinkedList");
			return;
		}
		
	}
	
	//Deletion at the End of Linked List
	public void deleteNodeAtEnding() {
		if(head==null) {
			System.out.println("LinkedList is empty , no deletion required");
			return;
		}
		
		if(head.next==null) {
			head = null;
			System.out.println("Head node only present ,removed the head node");
			return;
		}
		
		Node temp = head;
		Node prev =null;
		while(temp.next!=null) {
			prev = temp;
			temp = temp.next;
		}
		
		//reached to the end of list
		prev.next = null;
		return;
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(2);
		linkedList.add(25);
		linkedList.add(-6);
		linkedList.add(10);
		
		System.out.println(linkedList.length());
	
		linkedList.display();
		
		linkedList.delete(25);
		
		linkedList.display();
		
		linkedList.add(21);
		
		linkedList.display();
		
		linkedList.addNodeAtBegining(-4);
		
		linkedList.display();
		
		linkedList.addNodeAtBegining(8);
		
		
		linkedList.display();
		
		linkedList.addAfterAtGiveNode(3, new Node(8));
		linkedList.display();
		
		linkedList.addAfterAtGiveNode(14,new Node(6));
		
		linkedList.addAfterAtGiveNode(14,new Node(-6));
		
		linkedList.display();
		
		
		linkedList.addBeforeAtGiveNode(12,new Node(2));
		linkedList.display();
		
		
		linkedList.addBeforeAtGiveNode(26,new Node(21));
		linkedList.display();
		
		LinkedList newList = new LinkedList();
		newList.add(1);
		newList.display();
		
		newList.deleteNodeAtBegining();
		newList.display();
		
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.display();
		
		newList.deleteNodeAtBegining();
		newList.display();
		
		newList.add(4);
		newList.display();
		newList.deleteNodeAtPostion(3);
		newList.display();
		
		newList.addNodeAtBegining(1);
		newList.deleteNodeAtEnding();
		newList.display();
		
//		linkedList.delete(3);
//		linkedList.display();
	}
}

