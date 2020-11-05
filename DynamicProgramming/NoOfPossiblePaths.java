package DynamicProgramming;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to 
reach the bottom-right corner of the grid 

How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
*/

/*
Variation-
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to 
reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
 */

import java.util.*;

public class NoOfPossiblePaths {
	
	public static int uniquePaths(int rows, int cols) {
        if(rows==0 || cols==0) {
        	return 0;
        }
        
        int dp[][] = new int [rows][cols];
        
        for(int j=0; j<cols; j++) {
        	dp[rows-1][j] = 1;
        }
        for(int i=0; i<rows; i++) {
        	dp[i][cols-1] = 1;
        }
        
        for(int i=rows-2; i>=0; i--) {
        	for(int j=cols-2; j>=0; j--) {
        		dp[i][j] = dp[i+1][j] + dp[i][j+1];
        	}
        }
        
        return dp[0][0];
    }
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    	int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        
        int dp[][] = new int [rows][cols];
        
        for(int j=cols-1; j>=0; j--) {
        	if(obstacleGrid[rows-1][j]==0)
            dp[rows-1][j] = 1;
            else{
                dp[rows-1][j] = 0;
                break;
            }
        }
        for(int i=rows-1; i>=0; i--) {
            if(obstacleGrid[i][cols-1]==0)
        	dp[i][cols-1] = 1;
            else{
                dp[i][cols-1] = 0;
                break;
            }
        }
        
        for(int i=rows-2; i>=0; i--) {
        	for(int j=cols-2; j>=0; j--) {
                
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
        		dp[i][j] = dp[i+1][j] + dp[i][j+1];
        	}
        }
        
        if(dp[rows-1][cols-1]==0){
            return 0;
        }
        
        return dp[0][0];
        
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();
		int cols = s.nextInt();
		int result = uniquePaths(rows,cols);
		System.out.println(result);
		
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[][] = new int [n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m ; j++) {
				arr[i][j] =s.nextInt();
			}
		}
		
		System.out.println(uniquePathsWithObstacles(arr));
		s.close();
	}
}
