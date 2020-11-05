package binarySearchTree;

/*
1. You are given the root node of a binary search tree with N nodes and a key value K.
2. You have to find the inorder successor and predecessor of K in the BST.
3. In case, if the either of predecessor or successor is not found return -1

Sample Input
4 2 5 1 3 
6
Sample Output
5 -1
*/

import java.util.*;

public class InorderSuccessorAndPredecessor {
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
	 	 	 TreeNode pre = null;
	 	 	 TreeNode succ = null;
	 	 }
	 	 
	 	 static TreeNode prev = null;
	 	 static TreeNode curr = null;
	 	 
	 	 public static void find(TreeNode node, Result r, int key) {
	 		 
	 		 if(node==null) {
	 			 return ;
	 		 }
	 		 
	 		 find(node.left,r,key);
	 		 
	 		 curr = node;
	 		 if(prev!=null && prev.val==key) {
	 			 r.succ = curr;
	 		 }
	 		 if(curr!=null && curr.val==key) {
	 			 r.pre = prev;
	 		 }
	 		 
	 		 prev = curr;
	 		 
	 		 find(node.right,r,key);
	 	 }
	 	 
	 	 public static void findPreSuc(TreeNode node, Result r, int key) {
	 		 find(node,r,key);
	 		
	 		 //printing is happening on its own
	 		 //we just need to store value in r
	 	 }
	 	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 	 	 int key = sc.nextInt();
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 
	 	 	 Result r = new Result();
	 	 	 findPreSuc(root, r, key);
	 
	 	 	 if(r.pre != null){
	 	 	 	 System.out.print(r.pre.val + " ");
	 	 	 } else{
	 	 	 	 System.out.print("-1 ");
	 	 	 }
	 
	 	 	 if(r.succ != null){
	 	 	 	 System.out.println(r.succ.val+ " ");
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
