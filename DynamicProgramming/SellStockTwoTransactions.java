package DynamicProgramming;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the 
stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
*/

import java.util.*;

public class SellStockTwoTransactions {
	
	public static int maxProfit(int[] prices) {
        
		int n = prices.length;
		
		int leftAns[] = new int [n];
		int rightAns[] = new int [n];
		
		int leftMaxAns = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			int sellPrice = prices[i];
			min = Math.min(min,prices[i]);
			int buyPrice = min;
			int temp = sellPrice-buyPrice;
			leftMaxAns = Math.max(leftMaxAns,temp);
			leftAns[i] = leftMaxAns;
		}
		
		int rightMaxAns = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		
		int totalAns = 0;
		
		for(int i=n-1; i>=0; i--) {
			int buyPrice = prices[i];
			max = Math.max(max,buyPrice);
			int sellPrice = max;
			int temp = sellPrice-buyPrice;
			rightMaxAns = Math.max(rightMaxAns,temp);
			rightAns[i] = rightMaxAns;
            totalAns = Math.max((rightAns[i]+leftAns[i]),totalAns);
		}
		
		return totalAns;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prices[] = new int [n];
		
		for(int i=0; i<n; i++) {
			prices[i] = s.nextInt();
		}
		System.out.println(maxProfit(prices));
		s.close();	
	}
}
