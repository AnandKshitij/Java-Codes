package DynamicProgramming;

/*
Given a set of numbers, check whether it can be partitioned into two subsets such that the 
sum of elements in both subsets is same or not.

Variation of the subset sum problem we just have to find the array sum/2
If array sum is odd then our answer will be false
*/

import java.util.*;

public class SubsetDividedSum {
	
public static boolean isSubset(int input[], int K) {
		
		boolean dp[][] = new boolean [input.length+1][K+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = true;
		}
		
		for(int i=1; i<dp.length; i++) {
			int val = input[i-1];
			for(int j=1; j<dp[0].length; j++) {
				boolean val1 = dp[i-1][j];
				boolean val2 = false;
				
				if(j-val>=0) {
					val2 = dp[i-1][j-val];
				}
				
				dp[i][j] = val1||val2;
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int j=0; j<T; j++){
		    int n = s.nextInt();
		    
		    int input[] = new int [n];
		    int K=0;
		    for(int i=0; i<n; i++) {
			    input[i] = s.nextInt();
			    K += input[i];
		    }
		    
		    if(K%2!=0){
		        System.out.println("NO");
		        continue;
		    }
		
		    if(isSubset(input,K/2)){
		        System.out.println("YES");
		    }
		    else{
		        System.out.println("NO");
		    }
		}
	}

}
