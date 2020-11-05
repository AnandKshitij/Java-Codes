package binaryTree;

/*
1. You are given the root of a binary tree containing N nodes and a number K.
2. You have to find the count of nodes that are at distance K from a leaf node.
3. For example, 
Input: [1,2,3,4,5,6,7,null,null,null,null,null,8] and K = 2
Output: 2
Explanation: 
1 
/ 
2 3 
/ / 
4 5 6 7 
//
8 

Nodes at distance 2 from leaf nodes are 3 and 1.
*/

import java.util.*;

public class NodesAtDistanceKFromLeafNode {
	
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
	 	 static ArrayList<TreeNode> nodes = new ArrayList<>();
	 	 
	 	 public static void helperCount(TreeNode root, int k) {
	 		 
	 		 if(root.left==null && root.right==null) {
	 			 nodes.add(root);
	 			 int size = nodes.size();
	 			 if((size-k-1)>=0) {
	 				 TreeNode check = nodes.get(size-k-1);
	 				 if(check != null) {
	 					 System.out.println(check.val);
	 					 count += 1;
	 					 nodes.set(size-k-1,null);
	 				 }
	 			 }
	 			 nodes.remove(nodes.size()-1);
	 			 return ;
	 		 }
	 		 
	 		 nodes.add(root);
	 		 if(root.left!=null) {
	 			 helperCount(root.left,k);
	 		 }
	 		 if(root.right!=null) {
	 			 helperCount(root.right,k);
	 		 }
	 		 
	 		 nodes.remove(nodes.size()-1);
	 	 }
	 	 
	 	 public static int KDistantfromLeaf(TreeNode node, int k) {
	 		if(node==null){
	 	         return 0;
	 	     }
	 		 helperCount(node,k);
	 		 return count;
	 	 }
	 	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 	 	 int K = sc.nextInt();
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 	 	 System.out.println(KDistantfromLeaf(root, K));
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
