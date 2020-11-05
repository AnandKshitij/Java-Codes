package binaryTree;

/*
1.A binary tree is univalued if every node in the tree has the same value.
2.You have to complete the function isUnivalTree() that should return true if tree is univalues or false if the tree is not univalued.

Sample Input
2 2 2 5 2
Sample Output
false
*/


import java.io.IOException;
import java.util.*;

public class IsUnivalued {
	 
	static class TreeNode {
		 TreeNode left, right;
		 int data;

		 TreeNode(int d) {
		 	 data = d;
		 	 left = right = null;
		 }

	}

	static class BinaryTree {
		 public boolean isUnivalTree(TreeNode root) {
			 if(root==null) {
				 return true;
			 }
			 if(root.left==null && root.right==null) {
				 return true;
			 }
			 else if(root.right==null) {
				 boolean b1 = isUnivalTree(root.left);
				 boolean b2 = false;
				 if(root.data==root.left.data) {
					 b2 = true;
				 }
				 return b1 && b2;
			 }
			 else if(root.left==null) {
				 boolean b1 = isUnivalTree(root.right);
				 boolean b2 = false;
				 if(root.data==root.right.data) {
					 b2 = true;
				 }
				 return b1 && b2;
			 }
			 else {
				 boolean b1 = isUnivalTree(root.left);
				 boolean b2 = isUnivalTree(root.right);
				 
				 boolean b3 = false;
				 if(root.data==root.left.data) {
					 b3 = true;
				 }
				 boolean b4 = false;
				 if(root.data==root.right.data) {
					 b4 = true;
				 }
				 
				 return (b1 && b2 && b3 && b4);
			 }
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
	 	 System.out.println(bt.isUnivalTree(root));
	 }

}