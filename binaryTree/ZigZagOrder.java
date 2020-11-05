package binaryTree;

/*
1.Given a binary tree
2.You have to complete function zigzagorder() which should return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).
*/

import java.util.*;
import java.io.IOException;



public class ZigZagOrder {
	
	static class TreeNode {
		 TreeNode left, right;
		 int data;

		 TreeNode(int d) {
		 	 data = d;
		 	 left = right = null;
		 }

	}

	static class BinaryTree {

		 public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
		 
			 List<List<Integer>> result = new ArrayList<List<Integer>>();

			 Stack<TreeNode> curr = new Stack<>();
			 curr.push(node);
			 
			 boolean addLeft = true;
			
			 while(curr.size()>0) {
				 
				 List<Integer> toAdd = new ArrayList<Integer>();
				 Stack<TreeNode> next = new Stack<>();
				 
				 while(curr.size()>0) {
					 TreeNode val = curr.pop();
					 toAdd.add(val.data);
					 if(addLeft) {
						 if(val.left!=null) {
							 next.add(val.left);
						 }
						 if(val.right!=null) {
							 next.add(val.right);
						 }
					 }
					 else {
						 if(val.right!=null) {
							 next.add(val.right);
						 }
						 if(val.left!=null) {
							 next.add(val.left);
						 }
					 }
				 }
				 
				 result.add(toAdd);
				 curr = next;
				 addLeft = !addLeft;
			 }
			 
			 return result;
		 }

		 void inorder(TreeNode node) {
		 	 if (node == null)
		 	 	 return;
		 	 else
		 	 	 inorder(node.left);
		 	 System.out.print(node.data + " ");
		 	 inorder(node.right);
		 }

	}
	
	public static TreeNode construct(Integer[] arr) {
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

	 	 Scanner scn = new Scanner(System.in);
	 	 String str = scn.nextLine();
	 	 Integer[] ar = inputSplitSpace(str);
	 	 TreeNode root = construct(ar);

	 	 BinaryTree bt = new BinaryTree();
	 	 List<List<Integer>> res = bt.zigzagLevelOrder(root);

	 	 System.out.println(res);

	 }

}
