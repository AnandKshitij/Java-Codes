package binaryTree;

/*
1. You are given a binary search tree with N nodes.
2. You are also given two numbers lo and hi.
3. You have to print all the numbers in the BST that lie in the given range [lo,hi] in non-decreasing order. If no such element exists, 
an empty line should be printed.
3. For example:
Input: root = [4,2,5,1,3] ; lo = 2 and hi = 6

4
/ 
2 5
/ 
1 3

Output: 2 3 4 5 

Sample Input
4 2 5 1 3 
2 6
Sample Output
2 3 4 5
*/

import java.util.*;

public class PrintBSTElementsInGivenRange {
	
	 	public static class TreeNode {
	 	 	 int val;
	 	 	 TreeNode left;
	 	 	 TreeNode right;
	 
	 	 	 TreeNode(int x) {
	 	 	 	 val = x;
	 	 	 }
	 	}
	 	
	 	public static void printNearNodes(TreeNode node, int lo, int hi) {
	 	 	if(node==null) {
	 	 		return ;
	 	 	}
	 	 	
	 	 	int data = node.val;
	 	 	
	 	 	if(data<lo) {
	 	 		printNearNodes(node.right,lo,hi);
	 	 	}
	 	 	
	 	 	else if(data>=lo && data<=hi) {
	 	 		printNearNodes(node.left,lo,hi);
	 	 		System.out.print(data + " ");
	 	 		printNearNodes(node.right,lo,hi);
	 	 	}
	 	 	
	 	 	else {
	 	 		printNearNodes(node.left,lo,hi);
	 	 	}
	 	 	 
	 	}
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 	 	 int lo = sc.nextInt();
	 	 	 int hi = sc.nextInt();
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 
	 	 	 printNearNodes(root, lo, hi);
	 	 	 
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
