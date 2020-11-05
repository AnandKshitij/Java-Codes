package binaryTree;

/*
1. You are given the root of a binary tree.
2. You have to find the inorder traversal of its nodes' values.
3. For example, 
Input: [1,-1,2,-1,-1,3]
1

2
/
3

Output: [1,3,2]

*/

import java.util.*;

public class InorderTraversal {
	
	public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }

	 // This is a functional problem. You have to complete this function.
	 // It takes as input the root node of the given tree. It should return
	 // the inorder traversal arraylist.
	 public static ArrayList<Integer> inorderTraversal(TreeNode node) {
	 	 // write your code here.
		 
		 if(node==null) {
			 ArrayList<Integer> arr = new ArrayList<>();
			 return (arr);
		 }
		 
		 ArrayList<Integer> left = new ArrayList<>();
		 if(node.left!=null) {
			 left = inorderTraversal(node.left);
		 }
		 
		 left.add(node.val);
		 
		 ArrayList<Integer> right = new ArrayList<>();
		 if(node.right!=null) {
			 right = inorderTraversal(node.right);
		 }
		 
		 for(int i=0; i<right.size(); i++) {
			 left.add(right.get(i));
		 }
		 
		 return left;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 
	 	 // length of array representing the tree
	 	 int len = sc.nextInt();

	 	 int[] arr = new int[len];
	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 arr[i] = sc.nextInt();
	 	 }
	 	 TreeNode root = levelOrder(arr);

	 	 ArrayList<Integer> res = inorderTraversal(root);

	 	 for(Integer i: res){
	 	 	 System.out.print(i + " ");
	 	 }

	 	 System.out.println();

	 }
	 
	 // utility function to display a binary tree
	 public static void display(TreeNode node) {
	 	 if (node == null) {
	 	 	 return;
	 	 }

	 	 String str = "";

	 	 str += node.left == null ? "." : node.left.val;
	 	 str += " <= " + node.val + " => ";
	 	 str += node.right == null ? "." : node.right.val;

	 	 System.out.println(str);

	 	 display(node.left);
	 	 display(node.right);
	 }

	 // creation of tree from array by level order, -1 says there is no node
	 public static TreeNode levelOrder(int[] arr) {
	 	 
	 	 TreeNode[] nodes = new TreeNode[arr.length];
	 	 for (int i = 0; i < nodes.length; i++) {
	 	 	 if (arr[i] != -1) {
	 	 	 	 nodes[i] = new TreeNode(arr[i]);

	 	 	 	 if (i > 0) {
	 	 	 	 	 int pi = (i - 1) / 2;

	 	 	 	 	 if (i == 2 * pi + 1) {
	 	 	 	 	 	 nodes[pi].left = nodes[i];
	 	 	 	 	 } else {
	 	 	 	 	 	 nodes[pi].right = nodes[i];
	 	 	 	 	 }
	 	 	 	 }
	 	 	 }
	 	 }

	 	 TreeNode root = nodes[0];
	 	 return root;
	 }

}
