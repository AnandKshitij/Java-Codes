package DynamicProgramming;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
*/

import java.util.*;

public class LongestIncreasingSubsequence {
	
	public static int lengthOfLIS(int[] nums) {
        
		int dp[] = new int [nums.length];
		
		if(nums.length==0) {
			return 0;
		}
		
		dp[0] = 1;
		
		int highest = 1;
		
		for(int i=1; i<dp.length; i++) {
			int max = 0;
			
			for(int j=0; j<i; j++) {
				if(nums[j]<nums[i]) {
					int temp = dp[j];
					if(temp>max) {
						max = temp;
					}
				}
			}
			
			dp[i] = max+1;
			
			if(dp[i]>highest) {
				highest = dp[i];
			}
		}
		
		return highest;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(lengthOfLIS(arr));
	}

}
