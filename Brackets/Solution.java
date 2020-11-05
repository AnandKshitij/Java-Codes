package Brackets;

import java.util.Scanner;

public class Solution {
    public static String longestPalindrome(String A) {
        int n = A.length();
        
        if(n==0){
            return "";
        }
        
        boolean dp[][] = new boolean [n][n];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		dp[i][j] = true;
        	}
        }
        
        int startIndex = 0;
        int endIndex = 0;
        
        for(int i=1; i<n; i++){
            int col = i;
            int row = 0;
            
            boolean flag = false;
            
            while(row<n && col<n){
               char ch1 = A.charAt(row);
               char ch2 = A.charAt(col);
               
               if(ch1 == ch2){
                   boolean check = dp[row+1][col-1];
                   
                   if(check) {
                	   dp[row][col] = true;
                	   if(!flag) {
                		   startIndex = row;
                    	   endIndex = col;
                    	   flag = true;
                	   }
                   }
                   else {
                	   dp[row][col] = false;
                   }
               }
               else {
            	   dp[row][col] = false;
               }
               row++;
               col++;
            }
        }
        
        String pallindrome = "";
        
        for(int i=startIndex; i<=endIndex; i++){
            pallindrome += A.charAt(i);
        }
        
        return pallindrome;
    }
    
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String str = s.next();
    	String res = longestPalindrome(str);
    	System.out.println(res);
    }
}
