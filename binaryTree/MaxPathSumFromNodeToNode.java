package binaryTree;

/*
1. You are given the root of a non-empty binary tree.
2. You have to find the maximum path sum.
3. A path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
*/

import java.util.*;

public class MaxPathSumFromNodeToNode {
	
	 // TreeNode class for a node of a Binary Search Tree
	 public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }
	 
	 static int max = Integer.MIN_VALUE;
	 
	 public static int helperPathSum(TreeNode root) {
		 if(root==null) {
			 return 0;
		 }
		 
		 int leftSum = 0;
		 if(root.left!=null) {
			 leftSum = helperPathSum(root.left);
		 }
		 
		 int rightSum = 0;
		 if(root.right!=null) {
			 rightSum = helperPathSum(root.right);
		 }
		 
		 int factor1 = root.val;
		 int factor2 = root.val + leftSum;
		 int factor3 = root.val + rightSum;
		 int factor4 = root.val + leftSum + rightSum;
		 
		 int curr = Math.max(factor1,Math.max(factor2,Math.max(factor3,factor4)));
		 max = Math.max(max,curr);
		 
		 int f1 = root.val;
		 int f2 = root.val + leftSum;
		 int f3 = root.val + rightSum;
		 
		 return Math.max(f1,Math.max(f2,f3));
	 }

	 // This is a functional problem. You have to complete this function.
	 // It takes as input the root node of a binary tree. It should return 
	 // the maximum path sum.
	 public static int maxPathSum(TreeNode root) {
	 	 // write your code here.
		 if(root==null) {
			 return 0;
		 }
		 int ret = helperPathSum(root);
		 return max;
	 }

	 

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String input = sc.nextLine().trim();

	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 TreeNode root = createTree(treeArr);

	 	 System.out.println(maxPathSum(root));
	 }
	 
	 // utility function to display a binary tree.
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

	 // utility function, don't change its code
	 public static Integer[] inputSplitSpace(String str) {
	 	 String[] sArr = str.split(" ");
	 	 Integer[] arr = new Integer[sArr.length];
	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
	 	 }
	 	 return arr;
	 }

	 // utility function to create a tree, don't change its code.
	 public static TreeNode createTree(Integer[] arr) {
	 	 ArrayDeque<TreeNode> que = new ArrayDeque<>();
	 	 TreeNode root = new TreeNode(arr[0]);
	 	 que.addLast(root);
	 	 int i = 1;
	 	 while (!que.isEmpty() && i < arr.length) {
	 	 	 TreeNode nn = que.removeFirst();

	 	 	 if (i < arr.length && arr[i] != null) {
	 	 	 	 TreeNode n = new TreeNode(arr[i]);
	 	 	 	 nn.left = n;
	 	 	 	 que.addLast(n);
	 	 	 }
	 	 	 i++;

	 	 	 if (i < arr.length && arr[i] != null) {
	 	 	 	 TreeNode n = new TreeNode(arr[i]);
	 	 	 	 nn.right = n;
	 	 	 	 que.addLast(n);
	 	 	 }
	 	 	 i++;
	 	 }

	 	 return root;
	 }

}
