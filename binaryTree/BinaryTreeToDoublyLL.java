package binaryTree;

/*
1.Given a Binary Tree (BT)
2.Convert it to a Doubly Linked List(DLL) In-Place.The left and right pointers in nodes are to be used as previous
and next pointers respectively in converted DLL.
3.The order of nodes in DLL must be same as Inorder of the given Binary Tree.
4.The first node of Inorder traversal (left most node in BT) must be head node of the DLL
5.You have to complete the function BT2DLL() which should return the root.
*/

import java.util.*;
import java.io.*;



public class BinaryTreeToDoublyLL{
	
	static class TreeNode {
	 	 TreeNode left, right;
	 	 int data;

	 	 TreeNode(int d) {
	 	 	 data = d;
	 	 	 left = right = null;
	 	 }

	 }


static class BinaryTree {
	 
	 static class Pair{
		 TreeNode head;
		 TreeNode tail;
	 }
	 
	 TreeNode head;
	 
	 public Pair helperDoublyLL(TreeNode root) {
		 if(root==null) {
			 Pair P = new Pair();
			 return P;
		 }
		 else if(root.left==null && root.right==null) {
			 Pair Ans = new Pair();
			 Ans.head = root;
			 Ans.tail = root;
			 return Ans;
		 }
		 else if(root.left==null) {
			 Pair rightAns = helperDoublyLL(root.right);
			 TreeNode rightHead = rightAns.head;
			 root.right = rightHead;
			 root.left = null;
			 rightHead.left = root;
			 rightAns.head = root;
			 return rightAns;
		 }
		 else if(root.right==null) {
			 Pair leftAns = helperDoublyLL(root.left);
			 TreeNode leftTail = leftAns.tail;
			 leftTail.right = root;
			 root.left = leftTail;
			 leftAns.tail = root;
			 return leftAns;
		 }
		 else {
			 Pair leftAns = helperDoublyLL(root.left);
			 TreeNode leftHead = leftAns.head;
			 TreeNode leftTail = leftAns.tail;
			 leftTail.right = root;
			 root.left = leftTail;
			 leftAns.tail = root;
			 Pair rightAns = helperDoublyLL(root.right);
			 TreeNode rightHead = rightAns.head;
			 TreeNode rightTail = rightAns.tail;
			 root.right = rightHead;
			 rightHead.left = root;
			 Pair P = new Pair();
			 P.head = leftHead;
			 P.tail = rightTail;
			 return P;
		 }
	 }

	 public TreeNode BT2DLL(TreeNode root) {
		 Pair P = helperDoublyLL(root);
	 	 return P.head;
	 }
	 
	 void inorder(TreeNode node)
	 {
	 	 if(node==null)
	 	 	 return ;
	 	 else
	 	 	 inorder(node.left);
	 	 	 System.out.print(node.data + " ");
	 	 	 inorder(node.right);
	 }
	 void printList(TreeNode head) 
   {
	 	 TreeNode prev = head;
       while (head != null) 
       {
           System.out.print(head.data + " ");
	 	 	 prev = head;
           head = head.right;
       }
	 	 
	 	 System.out.println();
	 	 while(prev != null)
	 	 {
	 	 	 System.out.print(prev.data+" ");
	 	 	 prev = prev.left;
	 	 }
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

	 	 BinaryTree bt=new BinaryTree();
	 	 TreeNode newRoot=bt.BT2DLL(root);
	 	 
	 	 bt.printList(newRoot);
	 	 
	 	 
//	 	 String out = String.valueOf(ret);

//	 	 System.out.print(out);
	 }

	 
	 
	 
}
