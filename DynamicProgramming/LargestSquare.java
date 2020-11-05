package DynamicProgramming;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and 
return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

import java.util.*;

public class LargestSquare {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int maximalSquare(char[][] matrix) {
		
		if(matrix.length==0) {
			return 0;
		}
        
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int dp[][] = new int [rows][cols];
		
		int max = 0;
		
		for(int j=0; j<cols; j++) {
			char ch = matrix[rows-1][j];
			dp[rows-1][j] = 0;
			if(ch=='1') {
				dp[rows-1][j] = 1;
				max = 1;
			}
		}
		
		for(int i=0; i<rows; i++) {
			char ch = matrix[i][cols-1];
			dp[i][cols-1] = 0;
			if(ch=='1') {
				dp[i][cols-1] = 1;
				max = 1;
			}
		}
		
		
		for(int i=rows-2; i>=0; i--) {
			for(int j=cols-2; j>=0; j--) {
				dp[i][j] = 0;
				
				if(matrix[i][j]=='1') {
					int min = Math.min(dp[i+1][j+1], Math.min(dp[i][j+1],dp[i+1][j]));
					dp[i][j] = min+1;
				}
				
				max = Math.max(max,dp[i][j]);
			}
		}
		disp(dp);
		return max*max;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		char input[][] = new char [n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				input[i][j] = s.next().charAt(0);
			}
		}
		
		System.out.println(maximalSquare(input));
		s.close();
	}
}
