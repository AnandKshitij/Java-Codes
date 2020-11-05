package DynamicProgramming;


/*
Given an integer array, find the contiguous sub array within an array (containing at least one 
number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a sub array.
*/

import java.util.Scanner;

public class MaximumProductSubArray {
	 public static int maxProduct(int[] nums) {
	     int minValue = Integer.MAX_VALUE;
	     int maxValue = Integer.MIN_VALUE;
	     
	     if(nums.length==0) {
	    	 return maxValue;
	     }
	     if(nums.length==1) {
	    	 return nums[0];
	     }
	     
	     int n = nums.length;
	     
	     int min[] = new int [n];
	     int max[] = new int [n];
	     
	     for(int i=0; i<nums.length; i++) {
	    	 if(i==0) {
	    		 min[i] = nums[i];
	    		 max[i] = nums[i];
	    	 }
	    	 
	    	 else {
	    		 int val1 = min[i-1]*nums[i];
	    		 int val2 = max[i-1]*nums[i];
	    		 
	    		 max[i] = Math.max(nums[i],Math.max(val1,val2));
	    		 min[i] = Math.min(nums[i],Math.min(val1,val2));
	    	 }
	    	 
	    	 maxValue = Math.max(maxValue,max[i]);
	    	 minValue = Math.min(minValue,min[i]);
	     }
	     
	     return maxValue;
	 }
	 
	 public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(maxProduct(arr));
		
		s.close();
	}
	 
}
