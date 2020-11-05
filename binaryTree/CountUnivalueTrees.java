package binaryTree;

/*
1. You are given the root of a binary tree
2. You have to find the count of uni-value subtrees
3. In a uni-value subtree, all nodes of the subtree have the same value

Sample Input
5 9 5 5 5 null 5
Sample Output
4
*/

import java.util.*;

public class CountUnivalueTrees {
	
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
	 	 
	 	 static int count = 0;
	 	 
	 	 public static boolean helperCount(TreeNode root) {
	 		 if(root==null) {
	 			 return true;
	 		 }
	 		 else if(root.left==null && root.right==null) {
	 			 count++;
	 			 return true;
	 		 }
	 		 else if(root.left==null) {
	 			 boolean b1 = helperCount(root.right);
	 			 boolean b2 = false;
	 			 if(root.val==root.right.val) {
	 				 b2 = true;
	 			 }
	 			 if(b1 && b2) {
	 				 count++;
	 				 return true;
	 			 }
	 			 else {
	 				 return false;
	 			 }
	 		 }
	 		else if(root.right==null) {
	 			 boolean b1 = helperCount(root.left);
	 			 boolean b2 = false;
	 			 if(root.val==root.left.val) {
	 				 b2 = true;
	 			 }
	 			 if(b1 && b2) {
	 				 count++;
	 				 return true;
	 			 }
	 			 else {
	 				 return false;
	 			 }
	 		 }
	 		else {
	 			boolean b1 = helperCount(root.left);
	 			boolean b2 = helperCount(root.right);
	 			boolean b3 = false;
	 			if(root.val==root.right.val && root.val==root.left.val) {
	 				 b3 = true;
	 			}
	 			if(b1 && b2 && b3) {
	 				count++;
	 				return true;
	 			}
	 			else {
	 				return false;
	 			}
	 		}
	 	 }
	 
	 	 public static int countUnivalSubtrees(TreeNode root) {
	 	 	 helperCount(root);
	 	 	 return count;
	 	 }
	 	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 	 	 
	 	 	 System.out.println(countUnivalSubtrees(root));
	 
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
