package HashMapsAndHeaps;

/*
1.Given an array arr[] of size N containing 0s and 1s only.
2.The task is to count the sub arrays having equal number of 0s and 1s.
3.You have to complete the function countSubArrays() which should return the count of subarrays.
*/

/*
In this question we will treat 0 as -1
So for a sub array with equal no. of 0s and 1s the sub array sum will be 0
So this question then can be done in the same way as sub array sum to 0
*/


import java.util.HashMap;
import java.util.Scanner;

public class SubArrayEqual0And1 {

	 public static int countSubArrays(int[] a, int n) {
	 
		 int count = 0;
		 
		 for(int i=0; i<a.length; i++)
		 {
			 if(a[i]==0)
			 {
				 a[i] = -1;
			 }
		 }
		 
		 int prefixSum = 0;
		 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 H.put(0,1);
		 
		 for(int i=0; i<n; i++)
		 {
			 int val = a[i];
			 
			 prefixSum += val;
			 
			 if(!H.containsKey(prefixSum))
			 {
				 H.put(prefixSum,1);
			 }
			 
			 else
			 {
				 count += H.get(prefixSum);
				 H.put(prefixSum,H.get(prefixSum)+1);
			 }
		 }
		 
		 return count;
	 }
	 
	 //Don't make any changes here.
	 public static void main(String[] args) {
	 	 // code
	 	 Scanner in = new Scanner(System.in);
	 	 int n = in.nextInt();
	 	 int[] a = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 a[i] = in.nextInt();
	 	 }
	 	 System.out.println(countSubArrays(a, n));

	 }

}