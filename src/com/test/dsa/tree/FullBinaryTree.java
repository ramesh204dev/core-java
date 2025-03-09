package com.test.dsa.tree;

/*
 * a full binary tree is a binary tree which has 0 or 2 child nodes
 */
public class FullBinaryTree {
	
	private static boolean isFullBinaryTree(Node root) {
		
		//empty root is a full binary tree 0 child
		if(root==null)
			return true;
		
		if( (root.left==null && root.right!=null) || (root.right==null && root.left!=null)) 
			return false;
		
		return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(12);
		root.left.left = new Node(13);
		root.left.right = new Node(14);
		root.right.left = new Node(12);
		root.right.right = new Node(15);
		
		boolean isFull = isFullBinaryTree(root);
		
		if(isFull)
			System.out.println("Full Binary Tree");
		else
			System.out.println("Not a full Binary Tree");
}
	}


class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		this.left =null;
		this.right =null;
	}
}

