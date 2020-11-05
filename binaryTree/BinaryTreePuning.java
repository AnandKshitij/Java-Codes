package binaryTree;

/*
1. You are given the root of a binary tree where every node's value is either a 0 or a 1.
2. You have to return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
3. For example:
Input: [1,0,1,0,0,0,1]

Output: [1,null,1,null,1]
*/

import java.util.*;

public class BinaryTreePuning {

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
	 	 // It takes as input the root node of the given tree. It should return the root 
	 	 // of the pruned tree.
	 	 public static TreeNode pruneTree(TreeNode root) {
	 	 	 // write your code here.
	 		 if(root==null) {
	 			 return root;
	 		 }
	 		 
	 		 root.left = pruneTree(root.left);
	 		 root.right = pruneTree(root.right);
	 	 	 
	 		 if(root.left==null && root.right==null && root.val==0) {
	 			 return null;
	 		 }
	 		 
	 		 return root;
	 	 }
	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 
	 	 	 TreeNode resultRoot = pruneTree(root);
	 	 	 display(resultRoot);
	 
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
