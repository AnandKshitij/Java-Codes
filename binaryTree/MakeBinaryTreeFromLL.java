package binaryTree;

/*
1.Given a Linked List Representation of Complete Binary Tree.
2.The task is to construct the Binary tree.
3.You have to complete the function construct() which should return the root node of the newly constructed tree.

Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i, its leftand right 
children are stored at position 2*i+1, 2*i+2 respectively.

Sample Input
5
1 2 3 4 5
Sample Output
1 2 3 4 5
*/



import java.util.*;

public class MakeBinaryTreeFromLL {
	
	static class TreeNode {
		 int data;
		 TreeNode left;
		 TreeNode right;

		 TreeNode(int d) {
		 	 data = d;
		 	 left = null;
		 	 right = null;
		 }
	}

	static class LinkedListNode {
		 int data;
		 LinkedListNode next;

		 LinkedListNode(int d) {
		 	 data = d;
		 	 next = null;
		 }
	}

	static class BinaryTree {
		
		 public TreeNode helperConvert(LinkedListNode head) {
			 if(head==null) {
				 return null;
			 }
			 
			 TreeNode root = new TreeNode(head.data);
			 Queue<TreeNode> Q = new LinkedList<>();
			 Q.add(root);
			 head = head.next;
			 
			 while(head!=null) {
				 TreeNode temp = Q.remove();
				 if(temp.left==null) {
					 TreeNode add1 = new TreeNode(head.data);
					 temp.left = add1;
					 Q.add(add1);
					 head = head.next;
				 }
				 if(temp.right==null && head!=null) {
					 TreeNode add2 = new TreeNode(head.data);
					 temp.right = add2;
					 Q.add(add2);
					 head = head.next;
				 }
			 }
			 
			 return root;
		 }

		 public TreeNode convert(LinkedListNode head, TreeNode node) {
			 return helperConvert(head);
		 }

	}
	 static LinkedListNode lhead;
	 static Queue<TreeNode> queue = new LinkedList<TreeNode>();

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 TreeNode node = null;
	 	 lhead = null;
	 	 LinkedListNode head = null;
	 	 while (!queue.isEmpty()) {
	 	 	 queue.poll();
	 	 }
	 	 int n = sc.nextInt();
	 	 if (n != 0) {
	 		MakeBinaryTreeFromLL llist = new MakeBinaryTreeFromLL();
	 	 	 int a1 = sc.nextInt();
	 	 	 head = new LinkedListNode(a1);
	 	 	 llist.addToTheLast(head);
	 	 	 lhead = head;
	 	 	 for (int i = 1; i < n; i++) {
	 	 	 	 int a = sc.nextInt();
	 	 	 	 llist.addToTheLast(new LinkedListNode(a));
	 	 	 }
	 	 }
	 	 BinaryTree bt = new BinaryTree();
	 	 TreeNode root = bt.convert(lhead, node);
	 	 levelOrder(root, n);
	 }

	 public static void levelOrder(TreeNode root, int n) {
	 	 queue.add(root);
	 	 while (!queue.isEmpty() && n-- > 0) {
	 	 	 TreeNode proot = queue.remove();
	 	 	 if (proot.left != null) {
	 	 	 	 queue.add(proot.left);
	 	 	 }
	 	 	 if (proot.right != null) {
	 	 	 	 queue.add(proot.right);
	 	 	 }
	 	 	 System.out.print(proot.data + " ");
	 	 }
	 }

	 public void addToTheLast(LinkedListNode head) {
	 	 if (lhead == null)
	 	 	 lhead = head;
	 	 else {
	 	 	 LinkedListNode temp = lhead;
	 	 	 while (temp.next != null)
	 	 	 	 temp = temp.next;
	 	 	 temp.next = head;
	 	 }
	 }
}