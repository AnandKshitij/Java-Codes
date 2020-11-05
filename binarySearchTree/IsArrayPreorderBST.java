package binarySearchTree;

/*
1. You are given an array of size N.
2. You have to find whether the given array can represent preorder traversal of a BST or not.
3. For example:
Input: arr = {4,2,1,3,5}

Output: Yes

Explanation: The array can represent this BST:
4
/ 
2 5
/ 
1 3

Sample Input
5 
4 2 1 3 5
Sample Output
Yes
*/


import java.util.*;

public class IsArrayPreorderBST {
	static int index = 0;
	
	 public static int[] nextLarger(int arr[]) {
		 Stack<Integer> S = new Stack<>();
		 S.push(0);
		 int result[] = new int [arr.length];
		 
		 for(int i=0; i<result.length; i++) {
			 result[i] = -1;
		 }
		 
		 for(int i=1; i<arr.length; i++) {
			 if(S.isEmpty()) {
				 S.push(i);
			 }
			 
			 while(!S.isEmpty() && arr[i]>arr[S.peek()]) {
				 result[S.pop()] = i;
			 }
			 
			 S.push(i);
		 }
		
		 return result;
	 }
	 
	 public static boolean helperCheck(int pre[], int nextLarger[], int preStart, int preEnd, int rangeStart, int rangeEnd) {
		 if(preStart>preEnd) {
			 return true;
		 }
		 
		 if(preStart==preEnd) {
			 int start = pre[preStart];
			 if(start>rangeEnd || start<rangeStart) {
				 return false;
			 }
			 return true;
		 }
		 int start = pre[preStart];
		 
		 if(start>rangeEnd || start<rangeStart) {
			 return false;
		 }
		 
		 int nextLargerIndex = nextLarger[preStart];
		 
		 if(nextLargerIndex==-1 || nextLargerIndex>preEnd) {
			 return helperCheck(pre,nextLarger,preStart+1,preEnd,rangeStart,start);
		 }
		 else if(nextLargerIndex==preStart+1) {
			 return helperCheck(pre,nextLarger,preStart+1,preEnd,start,rangeEnd);
		 }
		 else {
			 boolean b1 = helperCheck(pre,nextLarger,preStart+1,nextLargerIndex-1,rangeStart,start);
			 boolean b2 = helperCheck(pre,nextLarger,nextLargerIndex,preEnd,start,rangeEnd);
			 
			 return b1 && b2;
		 }
	 }
	 
	 public static boolean preOrder(int[] pre) {
	 	 int nextLarger[] = nextLarger(pre);
	 	 return helperCheck(pre, nextLarger, 0, pre.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
	 }


	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int N = sc.nextInt();
	 	 int[] arr = new int[N];
	 	 for(int i=0; i<arr.length; i++){
	 	 	 arr[i] = sc.nextInt();
	 	 }

	 	 if(preOrder(arr)){
	 	 	 System.out.println("Yes");
	 	 } else{
	 	 	 System.out.println("No");
	 	 }

	 }
}
