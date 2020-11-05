package DynamicProgramming;

import java.util.Scanner;

public class SubsetSum {

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
		int n = s.nextInt();
		int input[] = new int [n];
		for(int i=0; i<n; i++) {
			input[i] = s.nextInt();
		}
		int  K = s.nextInt();
		System.out.println(isSubset(input,K));
	}

}
