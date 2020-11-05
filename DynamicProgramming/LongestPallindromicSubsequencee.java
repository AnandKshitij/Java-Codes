package DynamicProgramming;

/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the 
maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
*/

import java.util.*;

public class LongestPallindromicSubsequencee {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int getLongestPallindrome(String s) {
        if(s.length()==0 || s.length()==1) {
        	return s.length();
        }
        
        int dp[][] = new int [s.length()][s.length()];
        
        for(int i=0; i<s.length(); i++) {
        	dp[i][i] = 1;
        }
        
        for(int i=1; i<s.length(); i++) {
        	int startCol=i;
        	int startRow=0;
        	
        	while(startRow<s.length() && startCol<s.length()) {
        		char ch1 = s.charAt(startRow);
        		char ch2 = s.charAt(startCol);
        		
        		if(ch1==ch2) {
        			int temp  = 0;
        			
        			if(startRow+1<s.length() && startCol-1>=0)
        			temp = dp[startRow+1][startCol-1];
        			
        			dp[startRow][startCol] = temp+2;
        		}
        		else {
        			
        			int val1 = Integer.MIN_VALUE;
        			int val2 = Integer.MIN_VALUE;
        			
        			if(startRow+1<s.length()) {
        				val1 = dp[startRow+1][startCol];
        			}
        			if(startCol-1>=0) {
        				val2 = dp[startRow][startCol-1];
        			}
        			dp[startRow][startCol] = Math.max(val1,val2);
        		}
        		
        		startRow++;
        		startCol++;
        	}
        }        
        disp(dp);
    	return dp[0][s.length()-1];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int result = getLongestPallindrome(str);
		System.out.println(result);
		s.close();
	}
}