package binaryTree;

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Input Format
 First line contains the level order representation of a tree.
output Format
 Return an array of double type containng the average of each level
 
Sample Input
3 9 20 null null 15 7
Sample Output
3.0 14.5 11.0
*/

import java.util.*;

public class AverageValueOfEachLevel {
	
	public static class TreeNode {
		 
	 	 int val;
	 	 TreeNode left;
	 	 TreeNode right;

	 	 TreeNode(int x) {
	 	 	 val = x;
	 	 }
	 }

	 public static List<Double> averageOfLevels(TreeNode root) {
	 	 // Write your code here
		 
		 List<Double> result = new ArrayList<>();
		 
		 Queue<TreeNode> Q = new LinkedList<>();
		 Q.add(root);
		 
		 while(!Q.isEmpty()) {
			 int count = Q.size();
			 int temp = count;
			 double sum = 0.0;
			 
			 while(temp>0) {
				 TreeNode rem = Q.remove();
				 sum += rem.val;
				 if(rem.left!=null) {
					 Q.add(rem.left);
				 }
				 if(rem.right!=null) {
					 Q.add(rem.right);
				 }
				 temp--;
			 } 
			 double toAdd = sum/count;
			 result.add(toAdd);
		 }
		 return result;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String input = sc.nextLine().trim();

	 	 Integer[] treeArr = inputSplitSpace(input);
	 	 TreeNode root = createTree(treeArr);
	 	 List<Double> res = averageOfLevels(root);
	 	 for (Double v : res) {
	 	 	 System.out.print(v + " ");
	 	 }
	 	 System.out.println();

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
