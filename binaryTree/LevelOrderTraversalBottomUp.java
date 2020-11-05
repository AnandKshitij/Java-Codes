package binaryTree;

/*
1. You are given the root of a binary tree.
2. You have to return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
3. For example:
Given binary tree [3,9,20,-1,-1,15,7],

3
/ 
9 20
/ 
15 7

return its bottom-up level order traversal as:

[
[15,7],
[9,20],
[3]
]
 */

import java.util.*;

import binaryTree.LevelOrderTraversal.TreeNode;

public class LevelOrderTraversalBottomUp {
	
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
	 	 // It takes as input the root of the given tree. It should return the
	 	 // bottom-up level order traversal as an arraylist of arraylist.
	 	 public static ArrayList<ArrayList<Integer>> createTreeBottom(TreeNode root) {
	 	 	 // write your code here.
	 		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	 		 
	 		 if(root==null) {
	 			 return result;
	 		 }
	 		 
	 		 Queue<TreeNode> Q = new LinkedList<>();
	 		 Q.add(root);
	 		 
	 		 while(!Q.isEmpty()) {
	 			int size = Q.size();
	 			ArrayList<Integer> curr = new ArrayList<>();
	 			
	 			while(size>0) {
	 				TreeNode rem = Q.remove();
	 				curr.add(rem.val);
	 				if(rem.left!=null) {
	 					Q.add(rem.left);
	 				}
	 				if(rem.right!=null) {
	 					Q.add(rem.right);
	 				}
	 				size--;
	 			}
	 			
	 			result.add(curr);
	 		 }
	 		 
	 		 ArrayList<ArrayList<Integer>> newAns = new ArrayList<>(); 
	 		 
	 		 for(int i=result.size()-1; i>=0; i--) {
	 			 newAns.add(result.get(i));
	 		 }
	 		 
	 		 return newAns;
	 	 }	 
	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 
	 	 	 // length of array representing the tree
	 	 	 int len = sc.nextInt();
	 
	 	 	 int[] arr = new int[len];
	 	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 	 arr[i] = sc.nextInt();
	 	 	 }
	 	 	 TreeNode root = createTree(arr);
	 
	 	 	 ArrayList<ArrayList<Integer>> res = createTreeBottom(root);
	 
	 	 	 for(ArrayList<Integer> list: res) {
	 	 	 	 for(Integer i: list){
	 	 	 	 	 System.out.print(i + " ");
	 	 	 	 }
	 	 	 	 System.out.println();
	 	 	 }
	 
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
	 	 public static TreeNode createTree(int[] arr) {
	 	 	 
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
