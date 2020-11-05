package binarySearchTree;

/*
1. Given a sorted array. 
2. Create a Balanced Binary Search Tree using array elements. 
3. If there are N elements in array, then floor(n/2)'th element should be chosen as root and same should be followed recursively.

Input Format
 First line of each test case is N(size of array). 
Second line contains N aray elements.
output Format
Print the preorder traversal of constructed BST.

Sample Input
1 2 3 4 5 6 7
Sample Output
4 2 1 3 6 5 7

*/

import java.util.*;

public class BSTFromSortedArray {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printPreorder(Node root) {
		if(root==null) {
			return ;
		}
		

		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public static void printInorder(Node root) {
		if(root==null) {
			return ;
		}
		
		printPreorder(root.left);
		System.out.print(root.data + " ");
		printPreorder(root.right);
	}
	
	public static Node getBST(int arr[], int start, int end) {
		int mid = (start+end)/2;
		
		if(start>end) {
			return null;
		}
		
		Node root = new Node(arr[mid]);
		root.left = getBST(arr,start,mid-1);
		root.right = getBST(arr,mid+1,end);
		return root;
	}
	
	public static void BSTFormation(int[] arr, int i, int j) {
		Node root = getBST(arr,i,j);
		printPreorder(root);
		System.out.println();
		printInorder(root);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        BSTFormation(arr, 0, arr.length - 1);
        scn.close();
    }

}
