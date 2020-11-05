package binarySearchTree;

/*
1. You are given the root of a binary tree.
2. You have to find the number of nodes in the largest subtree which is a Binary Search Tree (BST).
3. For example, 
Input : [9,7,2,3,44,5,6]
Output: 3
Explanation: The given binary tree is:
9
/ 
7 2
/ / 
3 44 5 6 

The largest subtree which is a BST is:
7
/ 
3 44
*/

import java.util.*;

public class LargestBST {
	
	// TreeNode class for a node of a Binary Search Tree
	 	 public static class TreeNode {
	 	 	 int val;
	 	 	 TreeNode left;
	 	 	 TreeNode right;
	 
	 	 	 TreeNode(int x) {
	 	 	 	 val = x;
	 	 	 	 left = right = null;
	 	 	 }
	 	 }
	 	 
	 	 static class Pair{
	 		 int max;
	 		 int min;
	 		 int size;
	 		 boolean isBST;
	 		 
	 		 public Pair() {
	 			 max = Integer.MIN_VALUE;
	 			 min = Integer.MAX_VALUE;
	 			 size = 0;
	 			 isBST = true;
	 		 }
	 	 }
	 	 
	 	 static int max = 1;
	 	 
	 	 public static Pair helperLargestBST(TreeNode root) {
	 		 if(root==null) {
	 			 Pair P = new Pair();
	 			 return P;
	 		 }
	 		 
	 		 Pair left = helperLargestBST(root.left);
	 		 Pair right = helperLargestBST(root.right);
	 		 
	 		 if(left.isBST && right.isBST && left.max<root.val && right.min>root.val) {
	 			 Pair P = new Pair();
	 			 P.size = left.size + right.size + 1;
	 			 max = Math.max(max,P.size);
	 			 P.isBST = true;
	 			 P.min = Math.min(left.min,root.val);
	 			 P.max = Math.max(right.max,root.val);
	 			 return P;
	 		 }
	 		 else if(left.isBST){
	 			Pair P = new Pair();
	 			P.size = left.size + right.size + 1;
	 			P.isBST = false;
	 			P.min = Math.min(left.min,Math.min(root.val,right.min));
	 			P.max = Math.max(right.max,Math.max(root.val,left.max));
	 			return P;
	 		 }
	 		else if(right.isBST){
	 			Pair P = new Pair();
	 			P.size = left.size + right.size + 1;
	 			P.isBST = false;
	 			P.min = Math.min(left.min,Math.min(root.val,right.min));
	 			P.max = Math.max(right.max,Math.max(root.val,left.max));
	 			return P;
	 		}
	 		else {
	 			Pair P = new Pair();
	 			P.size = left.size + right.size + 1;
	 			P.isBST = false;
	 			P.min = Math.min(left.min,Math.min(root.val,right.min));
	 			P.max = Math.max(right.max,Math.max(root.val,left.max));
	 			return P;
	 		}
	 		 
	 		 
	 	 }
	 
	 	 public static int largestBst(TreeNode node) {
	 		 
	 		 if(node==null) {
	 			 return 0;
	 		 }
	 	 	 helperLargestBST(node);
	 	 	 return max;
	 	 }
	 	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 	 	 System.out.println(largestBst(root));
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
