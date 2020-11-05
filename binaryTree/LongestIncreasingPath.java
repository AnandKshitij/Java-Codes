package binaryTree;

/*
1.Given a Binary Tree.
2.Your task is to find the length of the longest path which comprises of nodes with consecutive values
in increasing order.
3.Every node is considered as a path of length 1.

Sample Input
2
1 2 L 1 3 R

Sample Output
2

*/

import java.util.*;


public class LongestIncreasingPath {
	
	static class TreeNode {
		 int key;
		 TreeNode left, right;

		 public TreeNode(int key) {
		 	 this.key = key;
		 	 left = right = null;
		 }
	}

	static class BinaryTree {
		 
		 static class Pair{
			 TreeNode node;
			 int length;
		 }
		 
		 static int maxLength = 1;
		 
		 public void helperLongest(TreeNode root) {
			 Pair start = new Pair();
			 start.length = 1;
			 start.node = root;
			 
			 Queue<Pair> Q = new LinkedList<>();
			 Q.add(start);
			 
			 while(Q.size()>0) {
				 Pair P = Q.remove();
				 int data = P.node.key;
				 if(P.length>maxLength) {
					 maxLength = P.length;
				 }
				 
				 if(P.node.left!=null) {
					 int size = 1;
					 int left = P.node.left.key;
					 if(left>data) {
						 size = P.length+1;
					 }
					 Pair temp = new Pair();
					 temp.length = size;
					 temp.node = P.node.left;
					 Q.add(temp);
				 }
				 if(P.node.right!=null) {
					 int size = 1;
					 int right = P.node.right.key;
					 if(right>data) {
						 size = P.length+1;
					 }
					 Pair temp = new Pair();
					 temp.length = size;
					 temp.node = P.node.right;
					 Q.add(temp);
				 }
			 }
		 }
		 
		 public int longestConsecutive(TreeNode root) { 	 
			 if(root==null) {
				 return 0;
			 }
			 helperLongest(root);
			 return maxLength;
		 }

	}
	 public static void insert(TreeNode root, int a1, int a2, char ch) {
	 	 if (root == null)
	 	 	 return;
	 	 if (root.key == a1) {
	 	 	 switch (ch) {
	 	 	 case 'L':
	 	 	 	 root.left = new TreeNode(a2);
	 	 	 	 break;
	 	 	 case 'R':
	 	 	 	 root.right = new TreeNode(a2);
	 	 	 	 break;
	 	 	 }
	 	 } else {
	 	 	 insert(root.left, a1, a2, ch);
	 	 	 insert(root.right, a1, a2, ch);
	 	 }
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int n = sc.nextInt();
	 	 TreeNode root = null;
	 	 if (n == 0) {
	 	 	 System.out.println();
	 	 }
	 	 for (int i = 0; i < n; i++) {
	 	 	 int a1 = sc.nextInt();
	 	 	 int a2 = sc.nextInt();
	 	 	 char ch = sc.next().charAt(0);
	 	 	 if (root == null) {
	 	 	 	 root = new TreeNode(a1);
	 	 	 	 switch (ch) {
	 	 	 	 case 'L':
	 	 	 	 	 root.left = new TreeNode(a2);
	 	 	 	 	 break;
	 	 	 	 case 'R':
	 	 	 	 	 root.right = new TreeNode(a2);
	 	 	 	 	 break;
	 	 	 	 }
	 	 	 } else {
	 	 	 	 insert(root, a1, a2, ch);
	 	 	 }
	 	 }
	 	 BinaryTree bt = new BinaryTree();
	 	 System.out.println(bt.longestConsecutive(root));
	 }

}