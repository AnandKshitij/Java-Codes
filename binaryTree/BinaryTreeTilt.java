package binaryTree;


/*
1.Given a binary tree.
2.You have to find the tilt of the given tree.
3.The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
and the sum of all right subtree node values. Null node has tilt 0.
4.The tilt of the whole tree is defined as the sum of all nodes' tilt.
*/

import java.io.*;
import java.util.*;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;

	 TreeNode(int x) {
	 	 val = x;
	 }
}

class BinaryTree {
   static int tilt = 0;
	 
	 public int findSum(TreeNode node) {
		 if(node==null) {
			 return 0;
		 }
		 int leftSum = findSum(node.left);
		 int rightSum = findSum(node.right);
		 
		 int tiltNode = leftSum-rightSum;
		 
		 if(tiltNode<0) {
			 tiltNode = tiltNode*-1;
		 }
		 
		 tilt += tiltNode;
		 
		 return leftSum+rightSum+node.val;
	 }
	 public int findTilt(TreeNode node) {
	 //Write your code here .
		 
		 int sum = findSum(node);
		 return tilt;
	 }
	 
}

public class BinaryTreeTilt {

	 public static TreeNode construct(Integer[] arr) {
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

	 public static Integer[] inputSplitSpace(String str) {
	 	 String[] sArr = str.split(" ");
	 	 Integer[] arr = new Integer[sArr.length];
	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
	 	 }
	 	 return arr;
	 }
	 
	 	 
	 //Don't make any changes here.
	 public static void main(String[] args) throws IOException {

	 	 Scanner scn = new Scanner(System.in);
	 	 String str = scn.nextLine();
	 	 Integer[] ar = inputSplitSpace(str);
	 	 TreeNode root = construct(ar);

	 	 int ret = new BinaryTree().findTilt(root);

	 	 String out = String.valueOf(ret);

	 	 System.out.print(out);
	 }
}