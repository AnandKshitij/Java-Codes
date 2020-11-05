package DynamicProgramming;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

import java.util.*;

public class MinCostPath {
	
	public static int minPathSum(int[][] grid) {
        
		int n = grid.length;
		int m = grid[0].length;
		int dp[][] = new int [n][m];
		
		int temp = 0;
		for(int j=m-1; j>=0; j--) {
			temp += grid[n-1][j];
			dp[n-1][j] = temp;
		}
		
		temp = 0;
		for(int i=n-1; i>=0; i--) {
			temp += grid[i][m-1];
			dp[i][m-1] = temp;
		}
		
		
		for(int i=n-2; i>=0; i--) {
			for(int j=m-2; j>=0; j--) {
				int min = Math.min(dp[i][j+1], dp[i+1][j]);
				dp[i][j] = min+grid[i][j];
			}
		}
		
		return dp[0][0];
    }

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		int input[][] = new int [n][m];
		
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				input[i][j] = s.nextInt();
			}
		}
		
		System.out.println(minPathSum(input));
	}
}
