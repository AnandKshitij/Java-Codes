package DynamicProgramming;

/*
Your are given an array of integers prices, for which the i-th element is the price of a given 
stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for
each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell 
the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8
*/

import java.util.Scanner;

public class SellStockTransactionFee {
	public static void disp(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int maxProfit(int[] prices, int fee) {
        if(prices.length==0) {
        	return 0;
        }
        
        int n = prices.length;
        
        int buy[] = new int [n];
        int sell[] = new int [n];
        
        buy[0] = -1*prices[0];
        sell[0] = 0;
        
        for(int i=1; i<n; i++) {
        	int buy1 = buy[i-1];
        	int buy2 = sell[i-1]-prices[i];
        	buy[i] = Math.max(buy1,buy2);
        	
        	int sell1 = sell[i-1];
        	int sell2 = buy[i-1]+prices[i]-fee;
        	sell[i] = Math.max(sell1,sell2);
        }
        
        disp(buy);
        disp(sell);
        
        return Math.max(buy[n-1],sell[n-1]);
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prices[] = new int [n];
		
		for(int i=0; i<n; i++) {
			prices[i] = s.nextInt();
		}
		int fee = s.nextInt();
		System.out.println(maxProfit(prices,fee));
		s.close();
	}
}
