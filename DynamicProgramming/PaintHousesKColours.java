package DynamicProgramming;

/*
1. You are given N houses and each house can be coloured with any one of the k colours
2. Each colour costs different for different house, find the minimum amount spent on 
colouring all the houses such that no 2 adjacent houses have same colour

Sample Input
5 3
8 9 7 
4 5 6 
4 1 2 
1 7 5 
4 2 1
Sample Output
14

*/


import java.util.*;

public class PaintHousesKColours {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int minCost(int[][] costs) {
 	 	 int n = costs.length;
 	 	 
 	 	 if(n==0) {
 	 		 return 0;
 	 	 }
 	 	 int k = costs[0].length;
 	 	 if(k==0) {
 	 		 return 0;
 	 	 }
 	 	 
 	 	 int dp[][] = new int [k][n+1];
 	 	 
 	 	 for(int j=1; j<n+1; j++) {
 	 		
 	 		int min = 0;
 	 		int second_min = 0;
 	 		 
 	 		if(n>1) {
 	 			if(dp[0][j-1]<=dp[1][j-1]) {
 	 				min = 0;
 	 				second_min = 1;
 	 			}
 	 			else {
 	 				min = 1;
 	 				second_min = 0;
 	 			}
 	 		}
 	 		 
 	 		for(int i=2; i<k; i++) {
 	 			if(dp[i][j-1]<=dp[min][j-1]) {
 	 				 second_min = min;
 	 				 min = i;
 	 			}
 	 			else if(dp[i][j-1]<dp[second_min][j-1]) {
 	 				 second_min = i;
 	 			}
 	 		}
 	 		 
 	 		int curr[] = costs[j-1];
 	 		 
 	 		for(int i=0; i<k; i++) {
 	 			 if(i!=min) {
 	 				 dp[i][j] = dp[min][j-1] + curr[i];
 	 			 }
 	 			 else {
 	 				 dp[i][j] = dp[second_min][j-1] + curr[i];
 	 			 }
 	 		}
 	 	 }
 	 	 
 	 	 disp(dp);
 	 	 
 	 	 int j = n;
 	 	 
 	 	 int min = Integer.MAX_VALUE;
 	 	 
 	 	 for(int i=0; i<k; i++) {
 	 		 min = Math.min(min,dp[i][j]);
 	 	 }
 	 	 
 	 	 return min;
 	 	 
 	}
	 
	public static void main(String[] args) {
		 
	     Scanner scn= new Scanner(System.in);
	     int n=scn.nextInt();
	     int k=scn.nextInt();
	     int[][] costs = new int[n][k];
	     for(int i=0;i<n;i++){
	         for(int j=0;j<k;j++){
	             costs[i][j]=scn.nextInt();
	         }
	     }
	     System.out.println(minCost(costs));
	}
}
