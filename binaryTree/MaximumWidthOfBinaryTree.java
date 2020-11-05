package binaryTree;

/*
1.Given a Binary Tree
2.You have to find the maximum width of it. 
3.Maximum width is defined as the maximum number of nodes in any level
*/

import java.util.*;

public class MaximumWidthOfBinaryTree{
	static class Node {
		 int data;
		 Node left, right;

		 Node(int item) {
		 	 data = item;
		 	 left = right = null;
		 }
	}

	static class BinaryTree {

		static int maxWidth = 0;
		
		void helperWidth(Node root) {
			Queue<Node> Q = new LinkedList<>();
			Q.add(root);
			
			while(Q.size()>0) {
				int count = Q.size();
				maxWidth = Math.max(maxWidth,count);
				
				while(count>0) {
					Node temp = Q.remove();
					if(temp.left!=null){
					    Q.add(temp.left);
					}
					if(temp.right!=null){
					    Q.add(temp.right);
					}
					count--;
				}
			}
		}
		
		int getMaxWidth(Node root) {
			if(root==null) {
				return 0;
			}
			
			helperWidth(root);
			return maxWidth;
		}

		 
	}
	
	 public static void insert(Node root, int a, int a1, char lr) {
	 	 if (root == null) {
	 	 	 return;
	 	 }
	 	 if (root.data == a) {
	 	 	 switch (lr) {
	 	 	 case 'L':
	 	 	 	 root.left = new Node(a1);
	 	 	 	 break;
	 	 	 case 'R':
	 	 	 	 root.right = new Node(a1);
	 	 	 	 break;
	 	 	 }
	 	 	 return;
	 	 }
	 	 insert(root.left, a, a1, lr);
	 	 insert(root.right, a, a1, lr);
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int n = sc.nextInt();
	 	 if (n == 0) {
	 	 	 System.out.println(0);
	 	 	 
	 	 }
	 	 Node root = null;
	 	 for (int i = 0; i < n; i++) {

	 	 	 int a = sc.nextInt();
	 	 	 int a1 = sc.nextInt();

	 	 	 char lr = sc.next().charAt(0);

	 	 	 if (i == 0) {

	 	 	 	 root = new Node(a);

	 	 	 	 switch (lr) {

	 	 	 	 case 'L':
	 	 	 	 	 root.left = new Node(a1);
	 	 	 	 	 break;
	 	 	 	 case 'R':
	 	 	 	 	 root.right = new Node(a1);
	 	 	 	 	 break;
	 	 	 	 }
	 	 	 } else {
	 	 	 	 insert(root, a, a1, lr);
	 	 	 }
	 	 }

	 	 BinaryTree g = new BinaryTree();
	 	 System.out.println(g.getMaxWidth(root));

	 }
}