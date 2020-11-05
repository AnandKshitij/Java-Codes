package DynamicProgramming;

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 
to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/

import java.util.*;

public class EditDistance {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int minDistance(String str1, String str2) {
		int dp[][] = new int [str1.length()+1][str2.length()+1];
        
        if(str1.length()==0) {
        	return str2.length();
        }
        if(str2.length()==0) {
        	return str1.length();
        }
        
        int count = 0;
        
        for(int j=str2.length(); j>=0; j--) {
        	dp[str1.length()][j] = count;
        	count++;
        }
       
        count = 0;
        
        for(int i=str1.length(); i>=0; i--) {
        	dp[i][str2.length()] = count;
        	count++;
        }
        
        for(int i=str1.length()-1; i>=0; i--) {
        	for(int j=str2.length()-1; j>=0; j--) {
        		char ch1 = str1.charAt(i);
        		char ch2 = str2.charAt(j);
        		
        		if(ch1==ch2) {
        			dp[i][j] = dp[i+1][j+1];
        		}
        		else {
        			dp[i][j] = Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]))+1;
        		}
        	}
        }
        
        return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		System.out.println(minDistance(str1,str2));
		s.close();
	}

}
