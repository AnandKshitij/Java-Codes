package binaryTree;

/*
1.Given a binary tree
2.You have to find its minimum depth.
3.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node

Sample Input
3 9 20 null null 15 7
Sample Output
2
*/


import java.io.IOException;
import java.util.*;

public class MinimumDepth {
	
	static class TreeNode {
		 TreeNode left, right;
		 int data;

		 TreeNode(int d) {
		 	 data = d;
		 	 left = right = null;
		 }

	}

	static class BinaryTree {

		static int minDepth = Integer.MAX_VALUE;
		
		public void helperDepth(TreeNode root) {
			 Queue<TreeNode> Q = new LinkedList<>();
			 
			 Q.add(root);
			 int level = 1;
			 
			 while (Q.size()>0) {
				 int count = Q.size();
				 while(count>0) {
					 TreeNode temp = Q.remove();
					 
					 if(temp.left==null && temp.right==null) {
						 minDepth = level;
						 return ;
					 }
					 
					 if(temp.left != null) {
						 Q.add(temp.left);
					 }
					 if(temp.right != null) {
						 Q.add(temp.right);
					 }
					 count--;
				 }
				 level++;
			 }
		}
		
		public int minDepth(TreeNode root) {
			 if(root==null) {
				 return 0;
			 }
			 helperDepth(root);
			 return minDepth;
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
	 	 System.out.println(bt.minDepth(root));
	 }

}