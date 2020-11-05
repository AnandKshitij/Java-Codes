package Array;

/*
1.Given an array, rotate the array to the right by k steps, where k is non-negative.
2.You have to complete the function rotate() which should rotate the array.

Sample Input
7
3
1 2 3 4 5 6 7
Sample Output
5 6 7 1 2 3 4
*/

/*
In this question we will roate the array in three parts

1)We will rotate the entire array
2)Then we will rotate the first K elements 
3)Then we will rotate the remaining elements
 */


import java.util.Scanner;

public class RotateArrayByKSteps {
	
	 public static void rotate(int arr[], int start, int end) {
		 
		 int mid = (start+end)/2;
		 
		 for(int i=start; i<=mid; i++) {
			 int j= end-i+start;
			 int temp = arr[i];
			 arr[i] = arr[j];
			 arr[j] = temp;
		 }
	 }
	 
	
	 public static void rotateK(int[] a, int k) {
	
		 int start= 0;
		 int end = a.length-1;
		 
		 rotate(a,start,end);
		 
		 end = k-1;
		 rotate(a,start,end);
		 
		 start = k;
		 end = a.length-1;
		 rotate(a,start,end);
	 }

	 public static void main(String[] args) {
	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 int k=s.nextInt();
	 	 int[] ar = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 ar[i] = s.nextInt();
	 	 }
	 	 rotateK(ar, k);
	 	 for (int v : ar)
	 	 	 System.out.print(v + " ");
	 }

}