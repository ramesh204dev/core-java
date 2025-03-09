package com.test.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/*
 * non linear data structre where all the node are fully filled except possibly last level left most filled
 * 
 * For a complete binary tree, elements are stored in level by level and 
 * not from the leftmost side in the last
 */


/*
 * For a complete binary tree, elements are stored in level by level manner
 *  and filled from the leftmost side of the last level
 */

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}


public class CompleteBinaryTree {
	TreeNode root;
	
	public void insert(int data) {
		TreeNode new_node = new TreeNode(data);
		
		if(root==null) {
			root = new_node;
			System.out.println("inserted at root level "+ data);
			return;
		}
		
		//queue is added to get access to first added node (FIFO) 
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			
			//filling left most in given level
			if(temp.left==null) {
				temp.left = new_node;
				System.out.println("inserted at left node "+ data);
				return;
			}else {
				queue.add(temp.left);
			}
			
			
			if(temp.right==null) {
				temp.right = new_node;
				System.out.println("inserted at right node "+ data);
				return;
			}else {
				queue.add(temp.right);
			}
			
		}
		
	}
	
	//Left --> Root --> right
	//iterative approach
	public void inorderTraversal(TreeNode node) {
		if(node==null) return;
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}
	
	
	//using stack also we can do InorderTraversal
	// stack can pop the lasted added element LIFO
	public void inOrderTraversalUsingStack(TreeNode root) {
		if(root==null) return;
		Stack<TreeNode> stack  = new Stack<TreeNode>();
		TreeNode currentNode = root;
		
		while(currentNode!=null || !stack.isEmpty()) {
			
			//push the left node to stack
			while(currentNode!=null) {
				stack.push(currentNode);
				currentNode  = currentNode.left;
			}
			
			currentNode = stack.pop(); //pops the lastadded Node to stack
			System.out.print(currentNode.data+" ");
			
			currentNode = currentNode.right;
		}
	}
	
	public TreeNode insertLevelOrder(int[] arr, int i) {
		TreeNode root = null;
		if(i<arr.length) {
			root = new TreeNode(arr[i]);
			
			root.left = insertLevelOrder(arr, 2*i+1);
			System.out.println("node inserted at left with index"+i+ " data "+ root.data);
			root.right = insertLevelOrder(arr, 2*i+1);
			
		}
		return root;
		
		
	}
		
	
	public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);
        
        System.out.println();
        System.out.print("Inorder Traversal using Stack: ");
        tree.inOrderTraversalUsingStack(tree.root);
        
        System.out.println();
        CompleteBinaryTree t2 = new CompleteBinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = t2.insertLevelOrder(arr, 0);
        
    }
}
