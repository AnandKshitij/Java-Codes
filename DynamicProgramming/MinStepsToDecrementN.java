package DynamicProgramming;

import java.util.Scanner;

/*
1. You will be given an Integer, return minimum steps needed to minimize n following the 
conditions:
a) If n is divisible by 2, you can reduce n to n/2.
b) If n is divisible by 3 then, you can n to n/3.
c) Decrement n by 1.

Sample Input
7
Sample Output
3
*/
public class MinStepsToDecrementN {
	
	public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 System.out.println(count_min(n));
	 	 scn.close();
	 }
	 
	
	 public static int count_min(int n) {
	 	int dp[] = new int [n+1];
	 	
	 	if(n==1 || n==0) {
	 		return 0;
	 	}
	 	dp[1] = 0;
	 	
	 	for(int i=2; i<n+1; i++) {
	 		int val1 = Integer.MAX_VALUE;
	 		if(i%2==0) {
	 			val1 = dp[i/2];
	 		}
	 		int val2 = Integer.MAX_VALUE;
	 		if(i%3==0) {
	 			val1 = dp[i/3];
	 		}
	 		int val3 = dp[i-1];
	 		
	 		dp[i] = Math.min(val1,Math.min(val2,val3))+1;
	 	}
	 	
	 	for(int i=0; i<n+1; i++) {
	 		System.out.print(dp[i] + " ");
	 	}
	 	System.out.println();
	 	
	 	return dp[n];
	 }

}
