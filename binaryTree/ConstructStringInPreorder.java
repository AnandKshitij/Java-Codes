package binaryTree;

/*
1. You are given the root of a binary tree containing N nodes.
2. You have to construct a string of parenthesis and integers from the given binary tree in the preorder traversing way.
3. Represent null node with empty parenthesis pair "()". Also, omit all the unnecessary empty parenthesis pairs that do not affect the one-to-one mapping between the string and the tree.
4. For example,
Input: Binary tree: [1,2,3,4]
1
/ 
2 3
/ 
4 

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", but all the unnecessary empty parenthesis pairs can be omitted.

If right subtree is absent and left subtree is absent then both can be omitted

But if only left subtree is missing and right subtree is absent then we need () for left subtree. Tjis is to distinguish between 
the trees having only left and only right subtree 
*/


import java.util.*;

public class ConstructStringInPreorder {

	 public static class TreeNode {
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 	 left = right = null;
	 	 }
	 }	 
	 
	 static String S1 = "" ;
	 
	 public static void helperString(TreeNode t) {
		 if(t.left==null && t.right==null) {
			 return ;
		 }
		 else if(t.left==null) {
			 S1 += "()(" + t.right.val;
			 helperString(t.right);
			 S1 += ")";
		 }
		 else if(t.right==null) {
			 S1 += "(" + t.left.val;
			 helperString(t.left);
			 S1 += ")";
		 }
		 else {
			 S1 += "(" + t.left.val;
			 helperString(t.left);
			 S1 += ")";
			 S1 += "(" + t.right.val;
			 helperString(t.right);
			 S1 += ")";
		 }
	 }

	 public static String tree2str(TreeNode t) {
	 	 if(t==null) {
	 		 return S1;
	 	 }
		 S1 = ""  + t.val;
		 helperString(t);
		 return S1;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String input = sc.nextLine().trim();
	 	 
	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 TreeNode root = createTree(treeArr);
	 	 
	 	 System.out.println(tree2str(root));

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