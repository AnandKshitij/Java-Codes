package binaryTree;

/*
1. You are given the root of a binary tree, and cameras are installed on the nodes of the tree. 
2. Each camera at a node can monitor its parent, itself, and its immediate children.
3. You have to calculate the minimum number of cameras needed to monitor all nodes of the tree.
4. For example, 
Input: [0,0,-1,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes.
*/

import java.util.*;

public class BinaryTreeCameras {
	 // TreeNode class for a node of a Binary Search Tree
	 public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }


	 // This is a functional problem. You have to complete this function.
	 // It takes as input the root of the given tree. It should return the minimum number of cameras required.
	 public static int minCameraCover(TreeNode root) {
		 if(root==null) {
			 return 0;
		 }
		 else if(root.left==null && root.right==null) {
			 return 1;
		 }
		 else if(root.left==null) {
			 //we have tow options either to put camera on root or to put camera on right child
			 
			 //if we put camera on root
			 int factor1 = 1+minCameraCover(root.right.left)+minCameraCover(root.right.right);
			 
			 //if we dont put camera on root
			 //we have to put camera on right child
			 //now we cannot put cameras on the children of right child
			 int factor2 = 1;
			 if(root.right.left!=null) {
				 factor2 += minCameraCover(root.right.left.left) + minCameraCover(root.right.left.right);
			 }
			 if(root.right.right!=null) {
				 factor2 += minCameraCover(root.right.right.left) + minCameraCover(root.right.right.right);
			 }
			 
			 return Math.min(factor1,factor2);
		 }
		 else if(root.right==null) {
			 //we have tow options either to put camera on root or to put camera on left child
			 
			 //if we put camera on root
			 int factor1 = 1+minCameraCover(root.left.left)+minCameraCover(root.left.right);
			 
			 //if we dont put camera on root
			 //we have to put camera on left child
			 //now we cannot put cameras on the children of right child
			 int factor2 = 1;
			 if(root.left.left!=null) {
				 factor2 += minCameraCover(root.left.left.left) + minCameraCover(root.left.left.right);
			 }
			 if(root.left.right!=null) {
				 factor2 += minCameraCover(root.left.right.left) + minCameraCover(root.left.right.right);
			 }
			 
			 return Math.min(factor1,factor2);
		 }
		 else {
			 //we have three options
			 //we can put camera on root, on left child or on right child
			 
			 //if we put camera on root
			 int factor1 = 1+minCameraCover(root.right.left)+minCameraCover(root.right.right)+
					 		 minCameraCover(root.left.left)+minCameraCover(root.left.right);
			 
			 //if we put camera on left child
			 int factor2 = 1 + minCameraCover(root.right);
			 if(root.left.left!=null) {
				 factor2 += minCameraCover(root.left.left.left) + minCameraCover(root.left.left.right);
			 }
			 if(root.left.right!=null) {
				 factor2 += minCameraCover(root.left.right.left) + minCameraCover(root.left.right.right);
			 }
			 
			 //if we put put camera on right child
			 int factor3 = 1 + minCameraCover(root.left);
			 if(root.right.left!=null) {
				 factor3 += minCameraCover(root.right.left.left) + minCameraCover(root.right.left.right);
			 }
			 if(root.right.right!=null) {
				 factor3 += minCameraCover(root.right.right.left) + minCameraCover(root.right.right.right);
			 }
			 
			 return Math.min(factor1,Math.min(factor2,factor3));
		 }
	 	 
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

	 	 System.out.println(minCameraCover(root));

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
