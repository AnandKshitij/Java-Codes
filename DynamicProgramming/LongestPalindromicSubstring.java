package DynamicProgramming;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum 
length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

import java.util.*;

public class LongestPalindromicSubstring {
	
	 public static String longestPalindrome(String str) {
	      
		 int n = str.length();
		 
		 if(n==0 || n==1) {
	    	  return str;
	     }
	      
	     boolean dp[][] = new boolean [n][n];
	     
	     int ansLength = 1;
	     int ansIndex = 0;
	     
	     for(int i=0; i<n; i++) {
	    	 dp[i][i] = true;
	     }
	     
	     for(int i=1; i<n; i++) {
	    	 
	    	 int col = i;
	    	 int row = 0;
	    	 
	    	 while(col<n && row<n) {
	    		 char ch1 = str.charAt(row);
	    		 char ch2 = str.charAt(col);
	    		 
	    		 if(i==1) {
	    			 if(ch1==ch2) {
		    			 dp[row][col] = true;
		    			 int length = col-row+1;
		    			 if(length>ansLength) {
		    				 ansLength = length;
		    				 ansIndex = row;
		    			 }
		    		 }
	    		 }
	    		 else {
	    			 if(ch1==ch2 && row+1<n && col-1>=0 && dp[row+1][col-1]) {
	    				 dp[row][col] = true;
		    			 int length = col-row+1;
		    			 if(length>ansLength) {
		    				 ansLength = length;
		    				 ansIndex = row;
		    			 }
	    			 }
	    		 }
	    		 col++;
	    		 row++;
	    	 }
	     }
	     
	     String result = "";
	     
	     for(int i=0; i<ansLength; i++) {
	    	 int index = i+ansIndex;
	    	 result += str.charAt(index);
	     }
	     
	     int count = 0;
	     
	     for(int i=0; i<dp.length; i++){
             for(int j=0; j<dp[i].length; j++){
                 if(dp[i][j]){
                     count++;
                 }
             }
         }
	     
	     System.out.println("No. of palindromic substrings:" + count);
	     
	     return result;
	 }
	 
	 public static void main(String[] args) {
		 
		 Scanner s = new Scanner(System.in);
		 String str = s.next();
		 String result = longestPalindrome(str);
		 System.out.println("Longest Palindromic Substring:" + result);
		 s.close();
	 }

}
