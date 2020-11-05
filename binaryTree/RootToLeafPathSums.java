package binaryTree;

/*
1.Given a binary tree where every node value is a number.
2.Find the sum of all the numbers which are formed from root to leaf paths

Sample Input
2
1 2 L 1 3 R
Sample Output
25

There are two root to leaf paths in the above example
1 2
1 3
If we make there numbers it becomes 12 and 13
Sum = 12+13 = 25
*/


import java.util.*;
import java.io.*;

public class RootToLeafPathSums {
	
	static class TreeNode {
		 int data;
		 TreeNode left, right;

		 TreeNode(int item) {
		 	 data = item;
		 	 left = right = null;
		 }
	}

	static class BinaryTree {

		 static int totalSum = 0;
		 
		 public static void helperSum(TreeNode root, int sum) {
			 if(root.left==null && root.right==null) {
				 sum = sum*10;
				 sum += root.data;
				 totalSum += sum;
				 return ;
			 }
			 
			 sum = sum*10;
			 sum += root.data;
			 
			 if(root.left!=null) {
				 helperSum(root.left,sum);
			 }
			 if(root.right!=null) {
				 helperSum(root.right,sum);
			 }
		 }
		
		 public int treePathsSum(TreeNode node) {
			 if(node==null) {
				 return 0;
			 }
			 helperSum(node,0);
			 return totalSum;
		 }

		 void printInorder(TreeNode node) {
		 	 if (node == null) {
		 	 	 return;
		 	 }
		 	 printInorder(node.left);
		 	 System.out.print(node.data + " ");
		 	 printInorder(node.right);
		 }
	}

	int height(TreeNode node) {
	 	 if (node == null)
	 	 	 return 0;
	 	 int l = 1 + height(node.left);
	 	 int r = 1 + height(node.right);
	 	 if (l > r)
	 	 	 return l;
	 	 else
	 	 	 return r;
	 }

	 public static void main(String args[]) {
	 	 Scanner sc = new Scanner(System.in);
	 	 HashMap<Integer, TreeNode> m = new HashMap<Integer, TreeNode>();
	 	 int n = sc.nextInt();
	 	 TreeNode root = null;
	 	 while (n > 0) {

	 	 	 int n1 = sc.nextInt();
	 	 	 int n2 = sc.nextInt();
	 	 	 char lr = sc.next().charAt(0);

	 	 	 TreeNode parent = m.get(n1);
	 	 	 if (parent == null) {
	 	 	 	 parent = new TreeNode(n1);
	 	 	 	 m.put(n1, parent);
	 	 	 	 if (root == null)
	 	 	 	 	 root = parent;
	 	 	 }
	 	 	 TreeNode child = new TreeNode(n2);
	 	 	 if (lr == 'L')
	 	 	 	 parent.left = child;
	 	 	 else
	 	 	 	 parent.right = child;
	 	 	 m.put(n2, child);
	 	 	 n--;
	 	 }

	 	 BinaryTree bt = new BinaryTree();
	 	 System.out.println(bt.treePathsSum(root));

	 }
}
