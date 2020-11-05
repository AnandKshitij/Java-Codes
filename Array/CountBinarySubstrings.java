package Array;

/*
1. You will be given a string
2. You need to return count of the number of non-empty (contiguous) substrings that have the same number of 0's, such that all 
the 1's and 0's are grouped consecutively 
3. Return your answer as an integer
*/

import java.util.*;

public class CountBinarySubstrings{
	
     public static void main(String[] args){
        Scanner scn= new Scanner (System.in);
        String s=scn.next();
	 	 System.out.print(countBinarySubstrings(s));
	 }

     public static int countBinarySubstrings(String s) {
	 	 //write code here
    	 
    	 int prev = 1;
    	 int curr = 0;
    	 int count = 0;
    	 
    	 int i=1;
    	 for(; i<s.length(); i++) {
    		 if(s.charAt(i)==s.charAt(i-1)) {
    			 prev++;
    		 }
    		 else {
    			 break;
    		 }
    	 }
    	 
    	 if(i==s.length()) {
    		 return 0;
    	 }
    	 
    	 for(; i<s.length(); i++) {
    		 if(s.charAt(i)==s.charAt(i-1)) {
    			 curr++;
    			 if(curr<=prev) {
    				 count++;
    			 }
    		 }
    		 else {
    			 if(curr==0) {
    				 curr++;
    				 count++;
    			 }
    			 else {
    				 prev = curr;
    				 curr = 1;
    				 count++;
    			 }
    		 }
    	 }
    	 
    	 return count;
	 }

}