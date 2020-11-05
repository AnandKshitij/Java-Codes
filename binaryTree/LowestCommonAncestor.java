package binaryTree;

/*
1.Given a Binary Tree
2.You are also given two nodes value n1 and n2.
3.The task is to find the lowest common ancestor of the given two nodes.

Sample Input
2
1 2 L 1 3 R
2 3
Sample Output
1

*/

import java.util.*;
import java.io.*;

public class LowestCommonAncestor {
	
	static class TreeNode {
		  int data;
		  TreeNode left, right;

		  TreeNode(int item) {
		  	  data = item;
		  	  left = right = null;
		  }
	}

	static class BinaryTree {
		
		 static TreeNode lca = null;
		 
		 public boolean helperLca(TreeNode root, int n1, int n2) {
			 if(root==null) {
				 return false;
			 }
			 if(lca!=null) {
				 return true;
			 }
			 
			 boolean self = false;
			 if(root.data==n1 || root.data==n2) {
				 if(n1==n2) {
					 lca = root;
					 return true;
				 }
				 self = true;
			 }
			 
			 boolean leftAns = helperLca(root.left, n1, n2);
			 boolean rightAns = helperLca(root.right, n1, n2);
			 
			 if((leftAns && rightAns) || (leftAns && self) || (rightAns && self)) {
				 if(lca==null){
					 lca = root;
				 }
			 }
			 
			 return leftAns || rightAns || self;
		}

	  public TreeNode lca(TreeNode root, int n1, int n2) {
		  helperLca(root,n1,n2);
		  return lca;
	  }

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

	  	  int firstNode = sc.nextInt();
	  	  int secondNode = sc.nextInt();

	  	  BinaryTree bt = new BinaryTree();
	  	  TreeNode lca = bt.lca(root, firstNode, secondNode);
	  	  System.out.println(lca.data);

	  }
}
