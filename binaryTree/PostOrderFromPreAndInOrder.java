package binaryTree;

/*
1. You are given two arrays containing the Preorder and Inorder traversals of a binary tree.
2. You have to write a function to print the Postorder traversal of the tree.
3. For example,
Input: inorder = {1,2,4,5,6,8,7} ; preorder = {1,2,4,5,6,7,8}

Output: postorder = {8,7,6,5,4,2,1}

Sample Input
7 
1 2 4 5 6 8 7 
1 2 4 5 6 7 8
Sample Output
8 7 6 5 4 2 1

 */

import java.util.*;

public class PostOrderFromPreAndInOrder {
	
	 public static void helperPostPrint(int in[], int pre[], int inStart, int inEnd, int preStart, int preEnd) {
		 if(inStart>inEnd || preStart>preEnd) {
			 return ;
		 }
		 int find = pre[preStart];
		 int index = inOrder.get(find);
		 int lhs = index-inStart;
		 
		 helperPostPrint(in, pre, inStart, index-1, preStart+1, preStart+lhs);
		 helperPostPrint(in, pre, index+1, inEnd, preStart+lhs+1, preEnd);
		 System.out.print(in[index] + " ");
	 }
	
	 static HashMap<Integer,Integer> inOrder = new HashMap<>();
	 
	 public static void printPostOrder(int in[], int pre[], int n) {
		 for(int i=0; i<in.length; i++) {
			 inOrder.put(in[i],i);
		 }
		 helperPostPrint(in, pre, 0, in.length-1, 0, pre.length-1);
	 	 
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int N = sc.nextInt();
	 	 
	 	 int[] inorder = new int[N];
	 	 for(int i=0; i<inorder.length; i++){
	 	 	 inorder[i] = sc.nextInt();
	 	 }

	 	 int[] preorder = new int[N];
	 	 for(int i=0; i<preorder.length; i++){
	 	 	 preorder[i] = sc.nextInt();
	 	 }

	 	 printPostOrder(inorder, preorder, N);

	 }
}
