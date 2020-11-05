package binaryTree;

/*
1.Given a Binary Tree of size N
2.Your have to complete the function printPaths() that prints all the possible paths from root node to the all the leaf node's of the 
binary tree.

Sample Input
2
1 2 R 1 3 L
Sample Output
1 3 #1 2 #
*/

import java.util.*;
import java.io.*;

public class PrintRootToLeafPaths {
	
	static class TreeNode {
		  int data;
		  TreeNode left, right;

		  TreeNode(int item) {
		  	  data = item;
		  	  left = right = null;
		  }
	}

	static class BinaryTree {

		  public void helperPrintPaths(TreeNode root, String path) {
			  if(root.left==null && root.right==null) {
				  path += root.data + " ";
				  System.out.print(path+"#");
				  return ;
			  }
			  
			  path += root.data + " ";
			  if(root.left!=null) {
				  helperPrintPaths(root.left,path);
			  }
			  if(root.right!=null) {
				  helperPrintPaths(root.right,path);
			  }
		  }
		
		  public void printPaths(TreeNode root) {
			  if(root==null) {
				  return ;
			  }
			  helperPrintPaths(root,"");
		  }

		  void printInorder(TreeNode node) {
		  	  if (node == null) {
		  	  	  return;
		  	  }
		  	  printInorder(node.left);
		  	  System.out.print(node.data + " ");
		  	  printInorder(node.right);
		  }
	}
	int height(TreeNode node) {
	  	  if (node == null)
	  	  	  return 0;
	  	  int l = 1 + height(node.left);
	  	  int r = 1 + height(node.right);
	  	  if (l > r)
	  	  	  return l;
	  	  else
	  	  	  return r;
	  }

	  public static void main(String args[]) {
	  	  Scanner sc = new Scanner(System.in);
	  	  HashMap<Integer, TreeNode> m = new HashMap<Integer, TreeNode>();
	  	  int n = sc.nextInt();
	  	  TreeNode root = null;
	  	  while (n > 0) {

	  	  	  int n1 = sc.nextInt();
	  	  	  int n2 = sc.nextInt();
	  	  	  char lr = sc.next().charAt(0);

	  	  	  TreeNode parent = m.get(n1);
	  	  	  if (parent == null) {
	  	  	  	  parent = new TreeNode(n1);
	  	  	  	  m.put(n1, parent);
	  	  	  	  if (root == null)
	  	  	  	  	  root = parent;
	  	  	  }
	  	  	  TreeNode child = new TreeNode(n2);
	  	  	  if (lr == 'L')
	  	  	  	  parent.left = child;
	  	  	  else
	  	  	  	  parent.right = child;
	  	  	  m.put(n2, child);
	  	  	  n--;
	  	  }

	  	  BinaryTree bt = new BinaryTree();
	  	  bt.printPaths(root);
	  }
}
