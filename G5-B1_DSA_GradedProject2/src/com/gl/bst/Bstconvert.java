package com.gl.bst;

// Class of the node
class Node {
	int key;
	Node left, right;

	Node(int data) {
		key = data;
		left = null;
		right = null;
	}
}

public class Bstconvert {

	private Node node;
	private Node previous_node = null;
	private Node head = null;

	/*
	 * This function recursively calls both left and right nodes and re-arranges to
	 * right skewed tree
	 * 
	 * @param Node passing a node as a parameter Returns void
	 * 
	 */

	public void conversion_bst_skewedtree(Node node) {

		// Base condition
		if (node == null) {
			return;

		}

		// Recursively the left subtree
		conversion_bst_skewedtree(node.left);
		// Check the head node is null
		// keep the leftmost node as head
		if (head == null) {
			// Assign the left most node as head
			head = node;
			node.left = null;
		} else {
			// assigning the previous node's right to current node
			// to form a skewed right
			previous_node.right = node;
			node.left = null;
		}
		// assign 'current node' to previous node
		previous_node = node;
		// Recursively called the right subtree
		conversion_bst_skewedtree(node.right);

	}

	/*
	 * This function from head node it traverse all the right nodes
	 * 
	 * @Param Node - (Head) Node passed as a parameter Returns void
	 * 
	 */
	public void right_traversal(Node node) {
		// The leaf node will return the recursive call-terminating
		if (node == null) {
			System.out.println("\n ***Successfully completed***");

			return;
		}
		// Print the data of each node
		// while traversing the right nodes recursively
		System.out.print(node.key + " ");
		// recursively call the right node
		right_traversal(node.right);
	}

	public static void main(String[] args) {

		// Creating an object of class Bstconvert
		Bstconvert tree = new Bstconvert();

		// Creation of Binary tree with data provided
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		// Convert the above bst to skewed right tree
		tree.conversion_bst_skewedtree(tree.node);
		System.out.println("Output");
		System.out.println("======");

		// Now the head node will have lowest node
		tree.right_traversal(tree.head);

		// Uncomment below lines to check all the right nodes - data
		/*
		 * System.out.println("head:"+tree.head.key);
		 * System.out.println("r   :"+tree.head.right.key);
		 * System.out.println("rr  :"+tree.head.right.right.key);
		 * System.out.println("rrr :"+tree.head.right.right.right.key);
		 * System.out.println("rrrr:"+tree.head.right.right.right.right.key);
		 */

	}

}
