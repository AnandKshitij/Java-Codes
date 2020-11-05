package DynamicProgramming;

/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented 
by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get 
nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After 
the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

import java.util.*;

public class BurstBallons {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int maxCoins(int[] ballons) {
		
		int n = ballons.length;
		int dp[][] = new int [n][n];
		
		for(int i=2; i<n; i++) {
			int row = 0;
			int col = i;
			
			while(row<n && col<n) {
				int start = row;
				int end = col;
				int currCol = start+1;
				int currRow = row+1;
				
				int max = Integer.MIN_VALUE;
				
				while(currCol<end) {
					int val1 = ballons[start]*ballons[end]*ballons[currCol];
					int val2 = dp[row][currCol];
					int val3 = dp[currRow][col];
					int val  = val1+val2+val3;
					max = Math.max(max,val);
					currCol++;
					currRow++;
				}
				
				dp[row][col] = max;
				row++;
				col++;
			}
		}

		disp(dp);
		
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ballons[] = new int [n+2];
		ballons[0] = 1;
		
		for(int i=0; i<n; i++) {
			ballons[i+1] = s.nextInt();
		}
		ballons[n+1] = 1;
		
		System.out.println(maxCoins(ballons));
		s.close();
	}
}
