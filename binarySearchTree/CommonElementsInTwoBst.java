package binarySearchTree;

/*
1. You are given the root nodes of two binary search trees.
2. You have to print the nodes that are common in both the BST in sorted order.
3. For example:
Input: root1 = [4,2,5,1,3] and root2 = {9,5,11,3,6}

Output: 3 5

Sample Input
4 2 5 1 3 
9 5 11 3 6
Sample Output
3 5
*/

import java.util.*;

public class CommonElementsInTwoBst {
	
	 public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;
	 
	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }
	 
	 static class Pair{
		 int state;
		 TreeNode node;
		 
		 public Pair(TreeNode n) {
			 node = n;
		 }
	 }
	 
	 static Stack<Pair> S1 = new Stack<>();
	 static Stack<Pair> S2 = new Stack<>();
	 
	 public static void helperPrint(TreeNode root1, TreeNode root2) {
		 
		 Pair P1 = new Pair(root1);
		 S1.add(P1);
		 
		 Pair P2 = new Pair(root2);
		 S2.add(P2);
		 
		 while(!S1.isEmpty() && !S2.isEmpty()) {
			 Pair top1 = S1.peek();
			 Pair top2 = S2.peek();
			 
			 root1 = top1.node;
			 root2 = top2.node;
			 
			 if(top1.state==1 && top2.state==1) {
				 int val1 = top1.node.val;
				 int val2 = top2.node.val;
				 
				 if(val1==val2) {
					 System.out.print(val1 + " ");
					 top1.state += 1;
					 top2.state += 1;
				 }
				 else if(val1>val2) {
					 top2.state += 1;
				 }
				 else {
					 top1.state += 1;
				 }
			 }
			 else if(top1.state==1) {
				 if(top2.state == 0) {
					 top2.state = 1;
					 
					 if(root2.left!=null) {
						 root2 = root2.left;
						 Pair P = new Pair(root2);
						 S2.push(P);
					 }
				 }
				 else if(top2.state==2) {
					 
					 S2.pop();
					 
					 if(root2.right!=null) {
						 root2 = root2.right;
						 Pair P = new Pair(root2);
						 S2.push(P);
					 }
				 }
			 }
			 else if(top2.state==1) {
				 if(top1.state == 0) {
					 top1.state = 1;
					 
					 if(root1.left!=null) {
						 root1 = root1.left;
						 Pair P = new Pair(root1);
						 S1.push(P);
					 }
				 }
				 else if(top1.state==2) {
					 S1.pop();
					 if(root1.right!=null) {
						 root1 = root1.right;
						 Pair P = new Pair(root1);
						 S1.push(P);
					 }
				 }
			 }
			 else {
				 if(top1.state == 0) {
					 top1.state = 1;
					 
					 if(root1.left!=null) {
						 root1 = root1.left;
						 Pair P = new Pair(root1);
						 S1.push(P);
					 }
				 }
				 else if(top1.state==2) {
					 S1.pop();
					 if(root1.right!=null) {
						 root1 = root1.right;
						 Pair P = new Pair(root1);
						 S1.push(P);
					 }
				 }
				 
				 if(top2.state == 0) {
					 top2.state = 1;
					 
					 if(root2.left!=null) {
						 root2 = root2.left;
						 Pair P = new Pair(root2);
						 S2.push(P);
					 }
				 }
				 else if(top2.state==2) {
					 S2.pop();
					 if(root2.right!=null) {
						 root2 = root2.right;
						 Pair P = new Pair(root2);
						 S2.push(P);
					 }
				 }
			 }
		 }
	 }
	 
	 // This is a functional problem. You have to complete this function.
	 // It takes as input the root nodes of two BSTs. It should print the common nodes in sorted order.
	 public static void printCommon(TreeNode root1, TreeNode root2) {
	 	 helperPrint(root1,root2);	 
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String input1 = sc.nextLine().trim();
	 	 Integer[] treeArr1 = inputSplitSpace(input1);
	 	 TreeNode root1 = createTree(treeArr1);
	 
	 	 String input2 = sc.nextLine().trim();
	 	 Integer[] treeArr2 = inputSplitSpace(input2);
	 	 TreeNode root2 = createTree(treeArr2);
	 
	 	 printCommon(root1, root2);
	 	 sc.close();	 
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
