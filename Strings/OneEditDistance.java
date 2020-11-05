package Strings;

/*
1. You are given two Strings S and T.
2. You have to find if the strings are one edit distance apart or not.
3. S and T are one edit distance apart if you can:
a) Insert a character into S to get T
b) Delete a character from S to get T
c) Replace a character of S to get T
4. For example:
Input: S = "ab", T = "acb"
Output: true
Explanation: We can insert 'c' into S to get T.
*/


import java.util.Scanner;

public class OneEditDistance {
	
    public static boolean isOneEditDistance(String s, String t) {
    	
    	int L1 = s.length();
    	int L2 = t.length();
    	
    	int type = 0;
    	
    	if(L1==L2+1) {
    		type = 1;
    	}
    	else if(L1==L2-1) {
    		type = -1;
    	}
    	else if(L1==L2) {
    		type = 0;
    	}
    	else {
    		return false;
    	}
    	
    	int i=0, j=0;
    	boolean edit = false;
    	
    	while(i<s.length() && j<t.length()) {
    		
    		char ch1 = s.charAt(i);
    		char ch2 = t.charAt(i);
    		
    		if(ch1==ch2) {
    			i++;
    			j++;
    		}
    		else {
    			if(edit) {
    				return false;
    			}
    			else {
    				if(type==0) {
    					i++;
    					j++;
    				}
    				else if(type==1) {
    					i++;
    				}
    				else if(type==-1) {
    					j++;
    				}
    				edit = true;
    			}
    		}
    	}
    	
    	if(i<s.length()) {
    		if(type==1 && !edit) {
    			if(i==s.length()-1) {
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	if(j<t.length()) {
    		if(type==-1 && !edit) {
    			if(j==t.length()-1) {
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	//if these strings are completely equal
    	if(!edit){
    	    return false;
    	}
    	return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        if (isOneEditDistance(s, t)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}