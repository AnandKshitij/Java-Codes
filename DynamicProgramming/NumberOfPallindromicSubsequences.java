package DynamicProgramming;

/*
Given a string A, 
find the total number of palindromic subsequences in A % 10^9+7.Palindromic subsequences need 
not to be distinct. You may assume that the maximum length of A is 1000.



Input Format

The only argument given is string A.
Output Format

find the total number of palindromic subsequences in A % 10^9+7.Palindromic subsequences 
need not to be distinct.

Input 1 : 
    "babad"
    Output 1: 
    9
    All possible palindromic subsequences :- {"b", "a", "b", "a", "d", "bb", "aa", "bab", "aba"}

 */

import java.util.*;

public class NumberOfPallindromicSubsequences {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int getPalindromicSubsequences(String str) {
		
		int n = str.length();
		int dp[][] = new int [n][n];
		
		int mod = (int)Math.pow(10,9)+7;
		
		for(int i=0; i<n; i++) {
			dp[i][i] = 1;
		}
		
		for(int i=1; i<n; i++) {
			int col = i;
			int row = 0;
			
			while(col<n && row<n) {
				
				if(str.charAt(row)==str.charAt(col)) {
					int val1 = 0;
					if(col-1>=0) {
						val1 = dp[row][col-1];
					}
					
					int val2 = 0;
					if(row+1<n) {
						val2 = dp[row+1][col];
					}
					
					dp[row][col] = (val1+val2+1)%mod;
				}
				
				else {	
					int val1 = 0;
					if(col-1>=0) {
						val1 = dp[row][col-1];
					}
					
					int val2 = 0;
					if(row+1<n) {
						val2 = dp[row+1][col];
					}
					
					int val3 = 0;
					if(row+1<n && col-1>=0) {
						val3 = dp[row+1][col-1];
					}
					
					dp[row][col] = (val1+val2-val3)%mod;
				}
				
				row++;
				col++;
			}
		}
		
		disp(dp);
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(getPalindromicSubsequences(str));
		s.close();
	}
}
