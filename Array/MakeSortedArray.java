package Array;

/*
1. You are given an integer array of length N.
2. You have to find the length of one shortest continuous subarray, such that if you only sort this sub array in ascending order, 
then the whole array will be sorted in ascending order.
3. For example, 
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */


import java.util.*;

public class MakeSortedArray {
	
	 // the length of the shortest continuous sub array.
	 public static int findUnsortedSubarray(int[] a) {
	 	 
		 int n = a.length;
		 
		 int leftMax[] = new int [n];
		 int rightMin[] = new int [n];
		 
		 int max  = Integer.MIN_VALUE;
		 
		 for(int i=0; i<n; i++) {
			 if(a[i]>max) {
				 max = a[i];
			 }
			 leftMax[i] = max;
		 }
		 
		 int min = Integer.MAX_VALUE;
		 
		 for(int i=n-1; i>=0; i--) {
			 if(a[i]<min) {
				 min = a[i];
			 }
			 rightMin[i] = min;
		 }
		 
		 int first = -1;
		 int last = -1;
		 
		 for(int i=0; i<n; i++) {
			 if(leftMax[i]!=rightMin[i]) {
				 if(first==-1) {
					 first = i;
				 }
				 last = i;
			 }
		 }
		 
		 if(first==-1) {
			 return 0;
		 }
		 
		 int length = last-first+1;
		 
		 return length;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 // Input for length of array.
	 	 int length = sc.nextInt();

	 	 int[] arr = new int[length];

	 	 // Input for elements of array.
	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 arr[i] = sc.nextInt();
	 	 }

	 	 System.out.println(findUnsortedSubarray(arr));

	 }

	 // function to display an array.
	 public static void display(int[] arr) {

	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 System.out.print(arr[i] + " ");
	 	 }

	 	 System.out.println();
	 }

}