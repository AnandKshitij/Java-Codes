package binarySearchTree;

/*
1.Given a Binary Search Tree (BST) with the root node root
2.You have to complete the function minDiffInBst() which returns the minimum difference between the values of any two different nodes 
in the tree.
 
Sample Input
4 2 6 1 3 null null

Sample Output
1
*/

import java.io.IOException;
import java.util.*;

public class MinDifferenceBetweenAnyTwoNodes {
	
	static class TreeNode {
		 TreeNode left, right;
		 int data;

		 TreeNode(int d) {
		 	 data = d;
		 	 left = right = null;
		 }

	}

	static class BinaryTree {

		 static int minDiff = Integer.MAX_VALUE;		 
		 
		 static TreeNode prev = null;
		 static TreeNode curr = null;
		 
		 public void inOrder(TreeNode root) {
			 if(root==null) {
				 return ;
			 }
			 
			 inOrder(root.left);
			 
			 curr = root;
			 if(prev!=null && prev!=curr) {
				 int diff = curr.data-prev.data;
				 minDiff = Math.min(diff,minDiff);
			 }
			 prev = curr;
			 
			 inOrder(root.right);
		 }
		 
		 public int minDiffInBST(TreeNode root) {	 	 
			 if(root==null) {
				 return minDiff;
			 }
			 if(root.left==null && root.right==null) {
				 return root.data;
			 }
			 
			 inOrder(root);
			 return minDiff;
			 
		 }

		 public String levelOrder(TreeNode root) {
		 	 if (root == null) {
		 	 	 return "[]";
		 	 }

		 	 String output = "";
		 	 Queue<TreeNode> nodeQueue = new LinkedList<>();
		 	 nodeQueue.add(root);
		 	 while (!nodeQueue.isEmpty()) {
		 	 	 TreeNode node = nodeQueue.remove();

		 	 	 if (node == null) {
		 	 	 	 output += "null ";
		 	 	 	 continue;
		 	 	 }

		 	 	 output += String.valueOf(node.data) + " ";
		 	 	 nodeQueue.add(node.left);
		 	 	 nodeQueue.add(node.right);
		 	 }
		 	 return output.substring(0, output.length() - 1);
		 }

		 void printPostorder(TreeNode node) {
		 	 if (node == null)
		 	 	 return;

		 	 printPostorder(node.left);

		 	 printPostorder(node.right);

		 	 System.out.print(node.data + " ");
		 }

		 void printPreorder(TreeNode node) {
		 	 if (node == null)
		 	 	 return;

		 	 System.out.print(node.data + " ");
		 	 printPostorder(node.left);

		 	 printPostorder(node.right);

		 }

		 public void inorder(TreeNode root) {
		 	 if (root != null) {
		 	 	 inorder(root.left);
		 	 	 System.out.print(root.data + " ");
		 	 	 inorder(root.right);
		 	 }
		 }

	}

	 public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
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

	 public static void main(String[] args) throws IOException {

	 	 Scanner s = new Scanner(System.in);
	 	 String str = s.nextLine();
	 	 TreeNode root = constructor_levelOderSerailize(inputSplitSpace(str));
	 	 BinaryTree bt = new BinaryTree();
	 	 System.out.println(bt.minDiffInBST(root));
	 }

}