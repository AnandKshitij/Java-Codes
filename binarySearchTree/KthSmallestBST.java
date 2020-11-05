package binarySearchTree;

/*
1. You are given a binary search tree with N nodes and a number K.
2. You have to find the Kth smallest element in the BST.
3. For example:
Input: root = [4,2,5,1,3] and K = 2

4
/ 
2 5
/ 
1 3

Output: 2

Sample Input
4 2 5 1 3 
2
Sample Output
2
*/

import java.util.*;

public class KthSmallestBST {

	  // TreeNode class for a node of a Binary Search Tree
	  public static class TreeNode {
	  	  int val;
	  	  TreeNode left;
	  	  TreeNode right;

	  	  TreeNode(int x) {
	  	  	  val = x;
	  	  }
	  }
	  
	  static int count = 0;
	  static int elementK;
	  
	  public static void helperKSmallest(TreeNode root, int k) {
		  if(root==null) {
			  return ;
		  }
		  
		  helperKSmallest(root.left,k);
		  count++;
		  
		  if(count==k) {
			  elementK = root.val;
			  return ;
		  }
		  
		  helperKSmallest(root.right,k);
	  }

	  public static int kthSmallest(TreeNode root, int k) {
	  	 helperKSmallest(root,k);
	  	 return elementK;
	  }

	  public static void main(String[] args) {
	  	  Scanner sc = new Scanner(System.in);
	  	  String input = sc.nextLine().trim();
	  	  int K = sc.nextInt();

	  	  Integer[] treeArr = inputSplitSpace(input);
	  	  TreeNode root = createTree(treeArr);

	  	  System.out.println(kthSmallest(root, K));
	  
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
