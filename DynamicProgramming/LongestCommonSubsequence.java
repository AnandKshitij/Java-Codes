package DynamicProgramming;

/*
Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 
the same, where in each step you can delete one character in either string.

Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
import java.util.*;

public class LongestCommonSubsequence {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int minDeletions(String word1, String word2) {
        int Lcs = lcs(word1,word2);
        
        int result = word1.length()+word2.length()-Lcs-Lcs;
        return result;
        
    }
	public static int lcs(String str1,String str2) {
		
		if(str1.length()==0 || str2.length()==0) {
			return 0;
		}
		
		int dp[][] = new int [str1.length()+1][str2.length()+1];
		
		for(int i=str1.length()-1; i>=0; i--) {
			for(int j=str2.length()-1; j>=0; j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j] = dp[i+1][j+1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str1 = s.next();
		String str2 = s.next();
		
		System.out.println("lcs" + ":" + lcs(str1,str2));
		System.out.println("min deletions:" + minDeletions(str1,str2));
		
		s.close();
		
	}

}
