package binarySearchTree;

import java.util.*;

public class MorrisTraversal {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
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
	
	public static Node findPred(Node root) {
		Node block = root;
		Node pred = root.left;
		while(pred.right!=null && pred.right!=block) {
			pred = pred.right;
		}	
		return pred;
	}
	
	public static void printMorrisInorder(Node root) {
		if(root==null) {
			return ;
		}
		
		Node curr = root;
		
		while(curr!=null) {
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr = curr.right;
			}
			else {
				Node pred = findPred(curr);
				
				if(pred.right==curr) {
					System.out.print(curr.data+ " ");
					pred.right = null;
					curr = curr.right;
				}
				else {
					pred.right = curr;
					curr = curr.left;
				}
			}
		}
		System.out.println();
	}
	
	public static void printMorrisPreorder(Node root) {
		if(root==null) {
			return ;
		}
		
		Node curr = root;
		
		while(curr!=null) {
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr = curr.right;
			}
			else {
				Node pred = findPred(curr);
				
				if(pred.right==curr) {
					pred.right = null;
					curr = curr.right;
				}
				else {
					System.out.print(curr.data+ " ");
					pred.right = curr;
					curr = curr.left;
				}
			}
		}
		
		System.out.println();
	}
	
	public static void BSTFormation(int[] arr, int i, int j) {
		Node root = getBST(arr,i,j);
		printMorrisInorde r(root);
		printMorrisPreorder(root);
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
