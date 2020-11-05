package binarySearchTree;

/*
1.Given a Binary Search Tree and 2 nodes value n1 and n2
2.Your task is to find the lowest common ancestor(LCA) of the two nodes.
3.You have to complete the function LCA() that returns the lca of the two nodes

Sample Input
6
5 4 6 3 7 8
7 8
Sample Output
7
*/

import java.util.*;


public class LowestCommonAncestorInBST {
	
	static class TreeNode {
		 int data;
		 TreeNode left, right;

		 TreeNode(int item) {
		 	 data = item;
		 	 left = right = null;
		 }
	}

	static class BST {
		boolean search(TreeNode root, int data) {
			if(root==null) {
				return false;
			}
			
			if(root.data==data) {
				return true;
			}
			
			return search(root.left,data)||search(root.right,data);
		}
		
		TreeNode helperLCA(TreeNode root, int d1, int d2) {
			if(root==null) {
				return null;
			}
			
			if(root.data<d1 && root.data<d2) {
				return helperLCA(root.right,d1,d2);
			}
			else if(root.data>d1 && root.data>d2) {
				return helperLCA(root.left,d1,d2);
			}
			
			return root;
		}
		
		TreeNode LCA(TreeNode node, int n1, int n2) {	
			boolean b1 = search(node,n1);
			boolean b2 = search(node,n2);
			if(!b1 || !b2) {
				return null;
			}
			
			return helperLCA(node,n1,n2);
		}
	}
	
	TreeNode root;

	public static void insert(TreeNode root, int key) {
	 	 if (key < root.data) {
	 	 	 if (root.left != null)
	 	 	 	 insert(root.left, key);
	 	 	 else {
	 	 	 	 root.left = new TreeNode(key);
	 	 	 }
	 	 } else if (key > root.data) {
	 	 	 if (root.right != null)
	 	 	 	 insert(root.right, key);
	 	 	 else {
	 	 	 	 root.right = new TreeNode(key);
	 	 	 }
	 	 }
	 }

	 public static void main(String args[]) {

	 	 Scanner sc = new Scanner(System.in);
	 	 int n = sc.nextInt();
	 	 int a1 = sc.nextInt();
	 	 TreeNode root = new TreeNode(a1);

	 	 for (int i = 1; i < n; i++) {
	 	 	 int a = sc.nextInt();
	 	 	 insert(root, a);
	 	 }

	 	 int n1 = sc.nextInt();
	 	 int n2 = sc.nextInt();

	 	 BST bst = new BST();
	 	 TreeNode lca = bst.LCA(root, n1, n2);
	 	 System.out.println(lca.data);

	 }
}