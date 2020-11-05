package DynamicProgramming;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before 
you buy again). After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

*/

import java.util.*;

public class BuyAndSellWithCoolingTime {
	
	public static void disp(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int maxProfit(int[] prices) {
        if(prices.length==0) {
        	return 0;
        }
        
        int n = prices.length;
        
        int buy[] = new int [n];
        int sell[] = new int [n];
        int cool[] = new int [n];
        
        buy[0] = -1*prices[0];
        sell[0] = 0;
        cool[0] = 0;
        
        for(int i=1; i<n; i++) {
        	cool[i] = sell[i-1];
        	
        	int buy1 = buy[i-1];
        	int buy2 = cool[i-1]-prices[i];
        	buy[i] = Math.max(buy1,buy2);
        	
        	int sell1 = sell[i-1];
        	int sell2 = buy[i-1]+prices[i];
        	sell[i] = Math.max(sell1,sell2);
        }
        
        return sell[n-1];
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
