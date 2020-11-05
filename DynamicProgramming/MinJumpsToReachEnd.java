package DynamicProgramming;

/*
Given an array of integers where each element represents the max number of steps that can be 
made forward from that element. The task is to find the minimum number of jumps to reach the end
of the array (starting from the first element). If an element is 0, then cannot move through 
that element.
*/

import java.util.*;
import java.io.*; 

public class MinJumpsToReachEnd {
	
	public static int getMinSteps(int input[]) {		
		int n = input.length;
		int dp[] = new int [n];
		
		dp[n-1] = 0;
		
		for(int i=n-2; i>=0; i--) {
			int val = input[i];
			if(val==0) {
				dp[i] = n+1;
				continue;
			}
			
			int min = n+1;
			
			for(int j=i+1; j<i+1+val && j<n; j++) {
				if(dp[j]<min) {
					min = dp[j];
				}
			}
			
			dp[i] = min+1;
		}
		
		return dp[0];
	}

	public static void main(String[] args) throws IOException{
		
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		
		for(int j=0; j<T; j++) {
			int n = s.nextInt();
			int input[] = new int [n];
			for(int i=0; i<n; i++) {
				input[i] = s.nextInt();
			}
		
			int result = getMinSteps(input);
		
			if(result>input.length) {
				result = -1;
			}
		
			System.out.println(result);
		}
		
		s.close();
	}
}
