package hw5;

import java.util.*;
// BinaryTree.java stores int values
// Simple implementation due to Nick Parlante, Stanford University
// Includes insert, lookup, printTreeInOrder

public class BinarySearchTree{
  
  /********************************************************
   --Node--
   The binary search tree is built using this nested node class.
   Each node stores one data element, and has left and right
   sub-tree pointer which may be null.
   The node is a "dumb" nested class -- we just use it for
   storage; it does not have any methods.
  */
  private static class Node {
    Node left;
    Node right;
    int data;  

    Node(int newData) {
      left = null;
      right = null;
      data = newData;
    }
  }

  /*******************************************************/
   // Instance variable for tree - Root node pointer. Will be null for an empty tree.
   private Node root;


  /*******************************************************
  * BinaryTree constructor: Creates an empty binary tree -- a null root pointer.
  */
  public BinarySearchTree(){
    root = null;
  }
 

  /*******************************************************
   Returns true if the given target is in the binary tree.
   Uses a recursive helper.
  */
  public boolean lookup(int data) {
    return(lookup(root, data));
  }
 

  /**
   Recursive lookup  -- given a node, recur
   down searching for the given data.
  */
  private boolean lookup(Node node, int data) {
    if (node==null) {
      return(false);
    }

    if (data==node.data) {
      return(true);
    }
    else if (data<node.data) {
      return(lookup(node.left, data));
    }
    else {
      return(lookup(node.right, data));
    }
  }
 

  
  
  
  
  /**************************************************
   Inserts the given data into the binary tree.
   Uses a recursive helper.
  */
  public void insert(int data) {
    root = insert(root, data);
  }
 
  /**
   Recursive insert -- given a node pointer, recur down and
   insert the given data into the tree. Returns the new
   node pointer (the standard way to communicate
   a changed pointer back to the caller).
  */
  private Node insert(Node node, int data) {
    if (node==null) {
      node = new Node(data);
      System.out.println("Making new node and returning its address.");
    }
    else {
      if (data < node.data) {
        node.left = insert(node.left, data);
      }
      else {
        node.right = insert(node.right, data);
      }
    }
    return(node); // in any case, return the new pointer to the caller
  }
  

  /**
   * inorder traversal and printing
   */
  public void printTreeInOrder(){
	  System.out.println("The tree nodes in inorder:");
	  printInOrder(root);
	  System.out.println();
  }
  
  public void printTreePreOrder() {
	  System.out.println("The tree nodes in preorder: ");
	  printPreOrder(root);
	  System.out.println();
  }
  
  public void printTreePostOrder() {
	  System.out.println("The tree nodes in postorder: ");
	  printPostOrder(root);
	  System.out.println();
  }
  
  public int height() {
	  return height(root);
  }
  
  public int countOfNodes() {
	  return countOfNodes(root);
  }
  
  public int findMin() {
	  return findMin(root);
  }
  
  public int countNodesWithExactlyOneChild() {
	  return countNodesWithExactlyOneChild(root);
  }
  
  public int countNodesWithTwoChildren() {
	  return countNodesWithTwoChildren(root);
  }
  
  private int countOfNodes(BinarySearchTree.Node t) {
	  return t == null ? 0 : 1 + countOfNodes(t.left) + countOfNodes(t.right);
  }
  
  private int height(BinarySearchTree.Node t) {	  
	  return t == null ? -1 : 1 + Math.max(height(t.left), height(t.right));
  }
  
  private void printInOrder(BinarySearchTree.Node t){
	  
	  if (t != null){
		  printInOrder(t.left);
		  System.out.print(t.data + "  ");
		  printInOrder(t.right);
	  }
  }

  private void printPreOrder(BinarySearchTree.Node t) {
	  if (t != null){
		  System.out.print(t.data + "  ");
		  printPreOrder(t.left);
		  printPreOrder(t.right);
	  }
  }
  
  private void printPostOrder(BinarySearchTree.Node t) {
	  if (t != null){
		  printPostOrder(t.left);
		  printPostOrder(t.right);
		  System.out.print(t.data + "  ");
	  }
  }
  
  private int findMin(BinarySearchTree.Node t) {	  
	  return t.left == null ? t.data : findMin(t.left);
  }
  
  private int countNodesWithExactlyOneChild(BinarySearchTree.Node t) {
	  if (t == null) {
		  return 0;
	  } else  if (t.left == null && t.right != null) {
		  return 1 + countNodesWithExactlyOneChild(t.right);
	  } else if (t.left != null && t.right == null) {
		  return 1 + countNodesWithExactlyOneChild(t.left);
	  } else if (t.left != null && t.right != null){
		  return 0 + countNodesWithExactlyOneChild(t.left) + countNodesWithExactlyOneChild(t.right);
	  } else {
		  return 0;
	  }
  }
  
  private int countNodesWithTwoChildren(BinarySearchTree.Node t) {
	  if (t == null) {
		  return 0;
	  } else  if (t.left == null && t.right != null) {
		  return 0 + countNodesWithTwoChildren(t.right);
	  } else if (t.left != null && t.right == null) {
		  return 0 + countNodesWithTwoChildren(t.left);
	  } else if (t.left != null && t.right != null){
		  return 1 + countNodesWithTwoChildren(t.left) + countNodesWithTwoChildren(t.right);
	  } else {
		  return 0;
	  }
  }
  
  
  public static void main(String [] args){
	  BinarySearchTree b = new BinarySearchTree();
	  BinarySearchTree b2 = new BinarySearchTree();
	  BinarySearchTree b3 = new BinarySearchTree();
	  BinarySearchTree emptyTree = new BinarySearchTree();
	  
	  int[] n = {27,14,10,19,35,31,42};
	  
	  int[] n3 = {1,2,3,4,5};
	  
	  int[] n2 = {14,31,35,27,42,19,10,6,5,4,3,2,1};
	  
	  for (int i = 0; i < n2.length; i++) {
		  b2.insert(n2[i]);
	  }
	  
	  for (int i = 0; i < n.length; i++) {
		  b.insert(n[i]);
	  }
	  
	  for (int i = 0; i < n3.length; i++) {
		  b3.insert(n3[i]);
	  }
	  
	  
	  System.out.println("Only one child test");
	  System.out.println("Nodes with exactly one child: " + b3.countNodesWithExactlyOneChild());
	  System.out.println("Nodes with two children: " + b3.countNodesWithTwoChildren());
	  System.out.println();
	  
	  System.out.println("Only two children test");
	  System.out.println("Nodes with exactly one child: " + b.countNodesWithExactlyOneChild());
	  System.out.println("Nodes with two children: " + b.countNodesWithTwoChildren());
	  System.out.println();
	  
	  System.out.println("Mixed test");
	  System.out.println("Nodes with exactly one child: " + b2.countNodesWithExactlyOneChild());
	  System.out.println("Nodes with two children: " + b2.countNodesWithTwoChildren());
	  System.out.println();
	  
	  System.out.println("Empty tree test");
	  System.out.println("Nodes with exactly one child: " + emptyTree.countNodesWithExactlyOneChild());
	  System.out.println("Nodes with two children: " + emptyTree.countNodesWithTwoChildren());
	  System.out.println();
	  
//	  b.printTreeInOrder();
//	  System.out.println();
//	  b.printTreePreOrder();
//	  System.out.println();
//	  b.printTreePostOrder();
//	  System.out.println();
//	  
//	  System.out.println("Node count: " + b.countOfNodes());
//	  System.out.println("Height: " + b.height());
//	  System.out.println();
//	  System.out.println("Node count: " + b2.countOfNodes());
//	  System.out.println("Height: " + b2.height());
//	  System.out.println("Node count: " + emptyTree.countOfNodes());
//	  System.out.println("Height: " + emptyTree.height());
//	  
//	  
//	  System.out.println("Min: " + b.findMin());
//	  System.out.println();
//	  System.out.println("Min: " + b2.findMin());
//	  
//	  emptyTree.printTreeInOrder();
//	  System.out.println();
//	  emptyTree.printTreePreOrder();
//	  System.out.println();
//	  emptyTree.printTreePostOrder();
//	  System.out.println();
//	  System.out.println("Height: " + emptyTree.height());
  }
 
}
  
