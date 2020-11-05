package DynamicProgramming;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

import java.util.*;

public class PalindromicCuts {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int minCut(String str) {
		int n = str.length();
		
		if(n==0 || n==1) {
			return 0;
		}
		
		int dp[][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			dp[i][i] = 0;
		}
		
		for(int i=1; i<n; i++) {
			int col = i;
			int row = 0;
			
			while(row<n && col<n) {
				
				char ch1 = str.charAt(row);
				char ch2 = str.charAt(col);
				
				//if string is palindrome
				if(ch1==ch2 && row+1<n && col-1>=0 && dp[row+1][col-1]==0) {
					dp[row][col] = 0;
				}
				else {
					int startCol = col-i;
					int startRow = row+1;
					
					int min = Integer.MAX_VALUE;
					
					while(startCol<col) {
						int sum = dp[startRow][col] + dp[row][startCol];
						startRow++;
						startCol++;
						min = Math.min(min,sum);
					}
					
					dp[row][col] = min+1;
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
		System.out.println(minCut(str));
		s.close();
	}
}
