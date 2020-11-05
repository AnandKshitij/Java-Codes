package DynamicProgramming;

/*
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
*/

import java.util.*;

public class NoOfLIS {
	public static int findNumberOfLIS(int[] nums) {
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
		
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=0; i<dp.length; i++) {
			if(dp[i]==highest) {
				Q.add(i);
			}
		}
		
		int result = Q.size();
		
		while(!Q.isEmpty()) {
			int index = Q.remove();
			int val = dp[index];
			
			int temp = 0;
			for(int j=0; j<index; j++) {
				if(nums[j]<nums[index] && dp[j]==val-1) {
					temp++;
					Q.add(j);
				}
			}
			
			if(temp>1) {
				result += temp-1; 
			}
		}
		
		return result;
    }
	
	/*
	 Alternate And Faster Approach
	 
	 public static int findNumberOfLIS(int[] nums) {
        
        int dp[] = new int [nums.length];
        int count[] = new int [nums.length];
		
		if(nums.length==0) {
			return 0;
		}
		
		dp[0] = 1;
        count[0] = 1;
		
		int highest = 1;
        
		for(int i=1; i<dp.length; i++) {
			int max = 0;
			int tempCount = 0;
            
			for(int j=0; j<i; j++) {
				if(nums[j]<nums[i]) {
					int temp = dp[j];
					
                    if(temp>max) {
						max = temp;
                        tempCount = count[j];
					}
                    else if(temp==max){
                        tempCount += count[j];
                    }
				}
			}
			
			dp[i] = max+1;
            
            if(tempCount<1){
                tempCount = 1;
            }
            count[i] = tempCount;
			
			if(dp[i]>highest) {
				highest = dp[i];
			}
		}
		
		int result = 0;
        
		for(int i=0; i<dp.length; i++) {
			if(dp[i]==highest) {
				result += count[i];
			}
		}
		
		
		return result;

        
    }
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(findNumberOfLIS(arr));
	}


}
