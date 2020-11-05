package binaryTree;

/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when 
the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.
*/

import java.util.*;

public class TopView {
	
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
	 
	 	 static HashMap<Integer,Integer> H = new HashMap<>();
	 	 
	 	 static class Pair{
	 		 int level;
	 		 TreeNode node;
	 		 
	 		 public Pair(TreeNode n, int l) {
	 			 this.node = n;
	 			 this.level = l;
	 		 }
	 	 }
	 	 
	 	 public static void printTopView(TreeNode root) {
	 	 	 if(root==null) {
	 	 		 return ;
	 	 	 }
	 	 	 
	 	 	 Queue<Pair> Q = new LinkedList<>();
	 	 	 
	 	 	 int minLevel = 0;
	 	 	 	 	
	 	 	 Pair start = new Pair(root,0);
	 	 	 H.put(0,root.val);
	 	 	 Q.add(start);
	 	 	 
	 	 	 while(!Q.isEmpty()) {
	 	 		 
	 	 		 Pair P = Q.remove();
	 	 		 TreeNode curr = P.node;
	 	 		 
	 	 		 if(curr.left!=null) {
	 	 			 int leftLevel = P.level-1;
	 	 			 if(!H.containsKey(leftLevel)) {
	 	 				 H.put(leftLevel,curr.left.val);
	 	 				 minLevel = Math.min(leftLevel,minLevel);
	 	 			 }
	 	 			 Pair newP = new Pair(curr.left,leftLevel);
	 	 			 Q.add(newP);
	 	 		 }
	 	 		 
	 	 		if(curr.right!=null) {
	 	 			 int rightLevel = P.level+1;
	 	 			 if(!H.containsKey(rightLevel)) {
	 	 				 H.put(rightLevel,curr.right.val);
	 	 			 }
	 	 			 Pair newP = new Pair(curr.right,rightLevel);
	 	 			 Q.add(newP);
	 	 		 }
	 	 	 }
	 	 	 
	 	 	 while(!H.isEmpty()) {
	 	 		 int val = H.get(minLevel);
	 	 		 System.out.print(val + " ");
	 	 		 H.remove(minLevel);
	 	 		 minLevel++;
	 	 	 }
	 	 }
	 
	 	 public static class Node {
	 	 	 int data;
	 	 	 TreeNode node;
	 
	 	 	 public Node(TreeNode node, int index) {
	 	 	 	 this.data = index;
	 	 	 	 this.node = node;
	 	 	 }
	 	 }
	 
	 	 public static void main(String[] args) {
	 	 	 Scanner sc = new Scanner(System.in);
	 	 	 String input = sc.nextLine().trim();
	 
	 	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 	 TreeNode root = createTree(treeArr);
	 	 	 printTopView(root);
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
