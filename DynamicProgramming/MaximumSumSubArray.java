package DynamicProgramming;

/*
Given an integer array, find the contiguous sub array (containing at least one number) which 
has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

import java.util.*;

public class MaximumSumSubArray {
	
	 public static int maxSumSubarray(int[] nums) {
	     int prevSum = 0;
	     int max = Integer.MIN_VALUE;
	     
	     for(int i=0; i<nums.length; i++) {
	    	 if(prevSum<0) {
	    		 prevSum = 0;
	    	 }
	    	 prevSum += nums[i];
	    	 if(prevSum>max) {
	    		 max = prevSum;
	    	 }
	     }
	     return max;
	 }

	 public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(maxSumSubarray(arr));
	}
}
