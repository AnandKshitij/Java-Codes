package binarySearchTree;

/*
1.Given a Binary Search Tree and two node values... x and y present in the BST.
2.Your have to find the pth (p >= 1) common ancestor of these two nodes x and y.
3.The 1st common ancestor is the lowest common ancestor.
4.The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants 
(where we allow a node to be a descendant of itself).
5.All the elements of BST are non-negative and there is no duplicate entry in BST. Also, x and y are unequal.
6.You have to complete the function pthCommonAncestor().
7.Return -1 if the pth common ancestor doesn't exist for a given BST

Sample Input
6 2

50 30 70 60 55 65

55 65
Sample Output 
70
*/

import java.util.*;
import java.lang.*;


public class PthCommonAncestor {
	
	static class TreeNode {
		  int data;
		  TreeNode left, right;

		  public TreeNode(int data) {
		  	  this.data = data;
		  }
	}

	static class BinaryTree {
		
		  static TreeNode P = null;
		  static int distance = 0;
		  static TreeNode lca = null;
		  
		  public boolean helperPAncestor(TreeNode root, int x, int y, int p) {
			  if(root==null) {
				  return false;
			  }
			  
			  boolean self = false;
			  
			  if(root.data==x || root.data==y) {
				  if(x==y) {
					  lca = root;
					  distance++;
					  if(distance == p) {
						  P = root;
					  }
					  return true;
				  }
				  self = true;
			  }
			  
			  boolean left = lca!=null || helperPAncestor(root.left, x, y, p);
			  boolean right = lca!=null || helperPAncestor(root.right, x, y, p);
			  
			  
			  if((left && right) || (left && self) || (right && self) || lca!=null) {
				  if(lca==null) {
					  lca = root;
				  }
				  distance++;
				  if(distance==p) {
					  P = root;
				  }
			  }
			  
			  return left || right || self;
		  }
		
		  public int PthAncestor(TreeNode root, int x, int y, int p, ArrayList<Integer> list) {
			  helperPAncestor(root,x,y,p);
			  if(P==null) {
				  return -1;
			  }
			  return P.data;
		  }

		  
	}  
	
	  public static void preorder(TreeNode node) {
	  	  if (node == null)
	  	  	  return;
	  	  System.out.print(node.data + " ");
	  	  preorder(node.left);
	  	  preorder(node.right);
	  }

	  public static TreeNode insert(TreeNode node, int data) {
	  	  if (node == null) {
	  	  	  TreeNode temp = new TreeNode(data);
	  	  	  return temp;
	  	  }
	  	  if (data < node.data) {
	  	  	  node.left = insert(node.left, data);
	  	  } else {
	  	  	  node.right = insert(node.right, data);
	  	  }

	  	  return node;
	  }

	  public static void main(String[] args) {
	  	  Scanner sc = new Scanner(System.in);
	  	  int n = sc.nextInt();
	  	  int p = sc.nextInt();
	  	  TreeNode root = null;
	  	  for (int i = 0; i < n; i++) {
	  	  	  root = insert(root, sc.nextInt());
	  	  }

	  	  int x = sc.nextInt(), y = sc.nextInt();
	  	  if (x > y) {
	  	  	  int temp = y;
	  	  	  y = x;
	  	  	  x = temp;
	  	  }

	  	  BinaryTree bt = new BinaryTree();
	  	  System.out.println(bt.PthAncestor(root, x, y, p, new ArrayList<>()));
	  }

}