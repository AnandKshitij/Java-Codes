package Array;

/*
1. You will be given an Array
2. Algorithim is to break it into chunks and sort them separately, and then combine these chunks to receive a sorted array
3. You need to return the maximum possible chunks for a given array
*/

/*
For making two chunks it is important that the left max is less than the right minimum
Then only the two separately sorted LL will merge to give one sorted LL
So we will calculate the left maximum and right minimum at every point
The point itself can either be part of left maximum or right minimum
In our case we are taking it to be the part of the right array
So right minimum will be inclusive and left maximum will be exclusive
*/


import java.util.*;

public class MaxChunksToSortLL {

	 public static int maxChunksToSorted(int[] arr) {
	 	 
		 int leftMax = Integer.MIN_VALUE;
		 int left[] = new int [arr.length];
		 
		 for(int i=0; i<arr.length; i++) {
			 left[i] = leftMax;
			 if(arr[i]>leftMax) {
				 leftMax = arr[i];
			 }
		 }
		 
		 int rightMin = Integer.MAX_VALUE;
		 int right[] = new int [arr.length];
		 
		 for(int i=arr.length-1; i>=0; i--) {
			 if(arr[i]<rightMin) {
				 rightMin = arr[i];
			 }
			 right[i] = rightMin;
		 }
		 
		 int count = 0;
		 
		 for(int i=0; i<arr.length; i++){
			 if(right[i]>=left[i]) {
				 count++;
			 }
		 }
		 
		 return count;
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int[] a = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 a[i] = scn.nextInt();
	 	 }
	 	 System.out.println(maxChunksToSorted(a));
	 }

}