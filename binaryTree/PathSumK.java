package binaryTree;

/*
1. You are given the root of a binary tree containing N nodes and a sum.
2. You have to find whether the tree has a root-to-leaf path such that adding up all the values along the path 
equals the given sum.
3. For example,
Input: [1,2,3,4,5,6,7] and sum = 8

Output: Yes

Explanation: The given binary tree is:

1 
/ 
2 3 
/ / 
4 5 6 7 

There exists a root-to-leaf path (1=>2=>5) whose sum of nodes is equal to given sum = 8

*/

import java.util.*;

public class PathSumK {
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
	 
	 	 public static boolean helperPathSum(TreeNode root, int target) {
	 		 if(root==null) {
	 			 return false;
	 		 }
	 		 
	 		 if(root.left==null && root.right==null) {
	 			 if(root.val==target) {
	 				 return true;
	 			 }
	 			 else {
	 				 return false;
	 			 }
	 		 }
	 		 
	 		 boolean f1 = helperPathSum(root.left,target-root.val);
	 		 boolean f2 = helperPathSum(root.right,target-root.val);
	 		 
	 		 return f1||f2;
	 	 }
	 	 
	 	 // It takes as input the root node of the given tree and the given sum. 
	 	 // It should return true if the tree has required path, else should return false.
	 	 public static boolean hasPathSum(TreeNode root, int sum) {
	 	 	 return helperPathSum(root,sum);
	 	 }
	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 	 	 int sum = sc.nextInt();
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 	 	 if(hasPathSum(root, sum)){
	 	 	 	 System.out.println("Yes");
	 	 	 } else {
	 	 	 	 System.out.println("No");
	 	 	 }
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
