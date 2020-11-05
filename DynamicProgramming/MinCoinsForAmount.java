package DynamicProgramming;

/*
You are given coins of different denominations and a total amount of money amount. Write a 
function to compute the fewest number of coins that you need to make up that amount. If that 
amount of money cannot be made up by any combination of the coins, return -1.

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
*/

import java.util.*;

public class MinCoinsForAmount {	
	public static int coinChange(int[] coins, int amount) {
		int dp[] = new int [amount+1];
		if(amount==0) {
			return 0;
		}
		dp[0] = 0;
		
		for(int i=0; i<coins.length; i++) {
			int val = coins[i];
			if(val<=amount) {
				dp[val] = 1;
			}
		}
		
		for(int i=1; i<dp.length; i++) {
			if(dp[i]!=0) {
				continue;
			}
			
			int min = amount+1;
			
			for(int j=0; j<coins.length; j++) {
				int coin = coins[j];
				int find = i-coin;
				
				if(find>=0) {
					int temp = dp[find];
					if(temp<min) {
						min = temp;
					}
				}
			}
			
			dp[i] = min+1;
		}
		
		if(dp[amount]>amount) {
			dp[amount] = -1;
		}
		return dp[amount];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int amount = s.nextInt();
		int n = s.nextInt();
		
		int coins[] = new int [n];
		for(int i=0; i<coins.length; i++) {
			coins[i] = s.nextInt();
		}
		System.out.println(coinChange(coins,amount));
	}
}
