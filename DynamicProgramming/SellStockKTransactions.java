package DynamicProgramming;

import java.util.Scanner;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock 
before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
*/

public class SellStockKTransactions {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int maxProfit(int k, int[] prices) {
        
		if(k==0 || prices.length==0) {
			return 0;
		}
		
		//all the values for 1st row and first column will be zero
		//this is because when transactions is equal to 0 we cannot earn
		//also when we have got only one day we cannot process transaction
		
		
		
		//If done by 2D array 
		
		int dp[][] = new int [k+1][prices.length];
		
		for(int i=1; i<k+1; i++) {
			int max = dp[i-1][0]-prices[0];
			for(int j=1; j<prices.length; j++) {
				int val = dp[i][j-1];
				dp[i][j] = Math.max(max+prices[j],val);
				int temp = dp[i-1][j] - prices[j];
				max = Math.max(max,temp);
			}
		}
		
		disp(dp);
		
		return dp[k][prices.length-1];
		
		/*
		
		//if done by 1D array
		int dp[][] = new int [2][prices.length];
		
		for(int i=1; i<k+1; i++) {
			for(int ctr=0; ctr<prices.length; ctr++) {
				dp[1][ctr] = 0;
			}
			
			int max = dp[0][0]-prices[0];
			for(int j=1; j<prices.length; j++) {
				int val = dp[1][j-1];
				dp[1][j] = Math.max(max+prices[j],val);
				int temp = dp[0][j] - prices[j];
				max = Math.max(max,temp);
			}
			
			for(int ctr=0; ctr<prices.length; ctr++) {
				dp[0][ctr] = dp[1][ctr];
			}
			
		}
		
		return dp[1][prices.length-1];
		*/
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prices[] = new int [n];
		
		for(int i=0; i<n; i++) {
			prices[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(maxProfit(k,prices));
		s.close();
	}
}
