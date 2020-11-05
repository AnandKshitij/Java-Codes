package binaryTree;

/*
1.Given a binary tree of N edges where every node contains distinct data.
2.You have to find the maximum path sum. The path may start and end at any node in the tree
*/

import java.util.*;


public class MaxSumFromNodeToNode {

	static class Node {
		 int data;
		 Node left, right;

		 Node(int item) {
		 	 data = item;
		 	 left = right = null;
		 }
	}

	static class BinaryTree {

		 static int maxSum = Integer.MIN_VALUE;
		
		 int helperSum(Node node) {
			 if(node==null) {
				 return 0;
			 }
			 
			 int ls = helperSum(node.left);
			 int rs = helperSum(node.right);
			 
			 int ret = Math.max(ls+node.data,Math.max(rs+node.data,node.data));
			 
			 int f = ls + rs + node.data;
			 int currAns = Math.max(ret,f);

			 maxSum = Math.max(currAns,maxSum);
			 return ret;
		 }
		 
		 int findMaxSum(Node node) {
			 if(node==null) {
				 return 0;
			 }
			 helperSum(node);
			 return maxSum;
		 }

		 
	}

	
	public static void insert(Node root, int a, int a1, char lr) {
	 	 if (root == null) {
	 	 	 return;
	 	 }
	 	 if (root.data == a) {
	 	 	 switch (lr) {
	 	 	 case 'L':
	 	 	 	 root.left = new Node(a1);
	 	 	 	 break;
	 	 	 case 'R':
	 	 	 	 root.right = new Node(a1);
	 	 	 	 break;
	 	 	 }
	 	 	 return;
	 	 }
	 	 insert(root.left, a, a1, lr);
	 	 insert(root.right, a, a1, lr);
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int n = sc.nextInt();
	 	 if (n == 0) {
	 	 	 System.out.println(0);
	 	 	 
	 	 }
	 	 Node root = null;
	 	 for (int i = 0; i < n; i++) {

	 	 	 int a = sc.nextInt();
	 	 	 int a1 = sc.nextInt();

	 	 	 char lr = sc.next().charAt(0);

	 	 	 if (i == 0) {

	 	 	 	 root = new Node(a);

	 	 	 	 switch (lr) {

	 	 	 	 case 'L':
	 	 	 	 	 root.left = new Node(a1);
	 	 	 	 	 break;
	 	 	 	 case 'R':
	 	 	 	 	 root.right = new Node(a1);
	 	 	 	 	 break;
	 	 	 	 }
	 	 	 } else {
	 	 	 	 insert(root, a, a1, lr);
	 	 	 }
	 	 }

	 	 BinaryTree g = new BinaryTree();
	 	 System.out.println(g.findMaxSum(root));

	 }
}