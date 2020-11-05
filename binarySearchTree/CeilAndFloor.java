package binarySearchTree;

/*
Given a BST and a value key
Find the floor and ceil of that value in BST
The floor and ceil should not be the key itself
*/

import java.util.*;

public class CeilAndFloor {

	 // TreeNode class for a node of a Binary Search Tree
	 public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }

	 static class Result {
	 	 TreeNode floor = null;
	 	 TreeNode ceil = null;
	 }
	 
	 public static void find(TreeNode node, Result r, int key) {
		 if(node==null) {
			 return ;
		 }
		 
		 find(node.left, r ,key);
		 
		 int currVal = node.val;
		 if(currVal<key) {
			 if(r.floor==null) {
				 r.floor = node;
			 }
			 else if(currVal>r.floor.val) {
				 r.floor = node;
			 }
		 }
		 if(currVal>key) {
			 if(r.ceil==null) {
				 r.ceil = node;
			 }
			 else if(currVal<r.ceil.val) {
				 r.ceil = node;
			 }
		 }
		 
		 find(node.right, r, key);
	 }
	 
	 public static void findFloorCeil(TreeNode node, Result r, int key) {
	 	find(node,r,key);
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String input = sc.nextLine().trim();
	 	 int key = sc.nextInt();
	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 TreeNode root = createTree(treeArr);

	 	 Result r = new Result();
	 	 findFloorCeil(root, r, key);

	 	 if(r.floor != null){
	 	 	 System.out.print(r.floor.val + " ");
	 	 } else{
	 	 	 System.out.print("-1 ");
	 	 }

	 	 if(r.ceil != null){
	 	 	 System.out.println(r.ceil.val+ " ");
	 	 } else{
	 	 	 System.out.println("-1 ");
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
