package DynamicProgramming;

/*
Given two integer arrays A and B, return the maximum length of an sub array that appears in 
both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated sub array with maximum length is [3, 2, 1]
 */

import java.util.*;

public class LongestCommonArray {

	public static int findMaxLength(int[] A, int[] B) {
        
		int dp[][] = new int [A.length+1][B.length+1];
		
		if(A.length==0 || B.length==0) {
			return 0;
		}
		
		int max = 0;
		
		for(int i=A.length-1; i>=0; i--) {
			for(int j=B.length-1; j>=0; j--) {
				if(A[i]==B[j]) {
					dp[i][j] = 1+dp[i+1][j+1];
					if(dp[i][j]>max) {
						max = dp[i][j];
					}
				}
			}
		}
		
		return max;
    }
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n1 = s.nextInt();
		int arr1[] = new int [n1];
		for(int i=0; i<n1; i++) {
			arr1[i] = s.nextInt();
		}
		
		int n2 = s.nextInt();
		int arr2[] = new int [n2];
		for(int i=0; i<n2; i++) {
			arr2[i] = s.nextInt();
		}
		
		System.out.println(findMaxLength(arr1,arr2));
		s.close();
	}
	
	
}
