package DynamicProgramming;

/*
Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from 
either end of the array followed by the player 2 and then player 1 and so on. Each time a player 
picks a number, that number will not be available for the next player. This continues until all 
the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player 
plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, 
then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
*/


/*
In first chance we can pick either the first element or the second element
*/

import java.util.*;

public class GameWinner {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        
        int dp[][] = new int [n][n];
        
        int totalSum = 0;
        
        for(int i=0; i<n; i++) {
        	totalSum += nums[i];
        }
        
        for(int i=0; i<n; i++) {
        	dp[i][i] = nums[i];
        }
        
        for(int i=1; i<n; i++) {
        	int row = 0;
        	int col = i;
        	
        	while(row<n && col<n) {
        		
        		//if we choose the element at start
        		//now he can choose the element at new start or end
        		int smallAns1 = nums[row];
        		int smallAns2 = nums[row];
        		
        		if(row+2<n && col<n) {
        			smallAns1 += dp[row+2][col];
        		}
        		if(row+1<n && col-1>=0) {
        			smallAns2 += dp[row+1][col-1];
        		}
        		
        		int ans1 = Math.min(smallAns1,smallAns2);
        		
        		//if we choose the end
*        		//now he can either choose the start or the new end
        		int smallAns3 = nums[col];
        		int smallAns4 = nums[col];
        		
        		if(row<n && col-2>=0) {
        			smallAns3 += dp[row][col-2];
        		}
        		if(row+1<n && col-1>=0) {
        			smallAns4 += dp[row+1][col-1];
        		}
        		
        		int ans2 = Math.min(smallAns3,smallAns4);
        		
        		dp[row][col] = Math.max(ans1,ans2);
        		
        		row++;
        		col++;
        	}
        }
        
        int ourValue = dp[0][n-1];
   
        int otherValue = totalSum-ourValue;
        int diff = ourValue-otherValue;
        System.out.println(ourValue);
        disp(dp);
        if(diff>=0) {
        	return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int [n];
		for(int i=0; i<n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(PredictTheWinner(input));
		s.close();
	}

}
