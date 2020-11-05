package DynamicProgramming;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price. 
*/

import java.util.*;

public class SellStockOneTransaction {
	public static int maxProfit(int[] prices) {
        int n = prices.length;
        
        int min = Integer.MAX_VALUE;
        
        int maxAns = 0;
        
        for(int i=0; i<n; i++) {
        	int sellPrice = prices[i];
        	if(prices[i]<min) {
        		min = prices[i];
        	}
        	int buyPrice = min;
        	
        	if(sellPrice-buyPrice>maxAns) {
        		maxAns = sellPrice-buyPrice;
        	}
        }
        
        return maxAns;
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
