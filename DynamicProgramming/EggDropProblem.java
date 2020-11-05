package DynamicProgramming;

/*
You are given K eggs, and you have access to a building with N floors from 1 to N. 

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor 
higher than F will break, and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X 
(with 1 <= X <= N). 

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, 
regardless of the initial value of F?
 

Example 1:

Input: K = 1, N = 2
Output: 2
Explanation: 
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.
*/


/*
In this dp we only need the current row and the previous row so we can make an 2D array of 
two rows with columns equal to floors In this way we will reduce the space complexity to 
O(n) from O(n^2)  
*/


import java.util.*;

public class EggDropProblem {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int eggDrop(int eggs, int N) {
        
		int dp[][] = new int [2][N+1];
		
		if(eggs==0) {
			return -1;
		}
		
		if(eggs==1) {
			return N;
		}
		
		if(N==0 || N==1) {
			return N;
		}
		
		//if there is only one egg
		for(int j=0; j<N+1; j++) {
			dp[0][j] = j;
		}
		
		
		
		//if there is only one floor
		for(int i=0; i<2; i++) {
			dp[i][1] = 1;
		}
		
		for(int i=2; i<eggs+1; i++) {
			
			dp[0] = dp[1];
			
			for(int j=2; j<N+1; j++) {
				
				int min = Integer.MAX_VALUE;
				
				//if egg breaks
				int breakRow = 0;
				int breakCol = 0;
				
				//if egg does not break
				int Row = 1;
				int Col = j-1;
				
				while(breakCol<j) {
					
					int val1 = dp[breakRow][breakCol];
					int val2 = dp[Row][Col];
					
					int max = Integer.max(val1,val2);
					min = Math.min(min,max);
					
					breakCol++;
					Col--;
				}
				
				dp[1][j] = min+1;
			}
		}
		
		disp(dp);
		
		return dp[1][N];
    }
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int n = s.nextInt();
		System.out.println(eggDrop(k,n));
		s.close();
	}
}
