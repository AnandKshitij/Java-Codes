package binaryTree;

/*
1. You are given the root of a binary tree.
2. Imagine you are standing on the right side of it.
3. You have to return return the values of the nodes you can see(ordered from top to bottom).
4. For example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
*/

import java.util.*;

public class RightSideView {
  	  public static class TreeNode {
  	  	  int val;
  	  	  TreeNode left;
  	  	  TreeNode right;
  
  	  	  TreeNode(int x) {
  	  	  	  val = x;
  	  	  }
  	  }
  	  
  	  static int maxLevel = -1;
  	  static ArrayList<Integer> ans = new ArrayList<Integer>(); 
  	  
  	  public static void helperRightView(TreeNode root, int currLevel){
  		  if(root==null) {
  			  return ;
  		  }
  		  if(currLevel>maxLevel) {
  			  ans.add(root.val);
  			  maxLevel++;
  		  }
  		  
  		  currLevel++;
  		  
  		  helperRightView(root.right, currLevel);
  		  helperRightView(root.left, currLevel);
  	  }
  	  
  	  // It takes as input the root node of the given tree. It should return the required arraylist. 
  	  public static ArrayList<Integer> rightSideView(TreeNode root) {
  		  helperRightView(root,0);
  		  return ans;
  	  }
  
  	  public static void main(String[] args) {
  	  	  Scanner sc = new Scanner(System.in);
  	  	  String input = sc.nextLine().trim();
  
  	  	  Integer[] treeArr = inputSplitSpace(input);
  	  	  TreeNode root = createTree(treeArr);
  
  	  	  ArrayList<Integer> result = rightSideView(root);
  	  	  for(Integer i: result) {
  	  	  	  System.out.print(i + " ");
  	  	  }
  	  	  System.out.println();
  
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
