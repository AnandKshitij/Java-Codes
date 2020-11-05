package Array;

/*
1. You are given an array A containing N elements.
2. A[i] represents the price of a given stock on day i.
3. You have to design an algorithm to find the maximum profit.
4. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
5. Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price = 3) and sell on 
day 5 (price = 6), profit = 6-3 = 3.

*/


import java.util.*;

public class BuyAndSellStocks {
	
    public static int maxProfit(int[] A) {

    	int profit = 0;
    	
    	for (int i = 0; i < A.length-1; i++) {
			if(A[i]<A[i+1]) {
				profit += A[i+1]-A[i];
			}
		}
    	
    	return profit;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProfit(arr));
    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}