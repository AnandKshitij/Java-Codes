package Strings;

/*
1. Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
*/


import java.util.*;

public class ToLower {

    public static String toLowerCase(String str) {
        
    	String result = "";
    	
    	for(int i=0; i<str.length(); i++) {
    		char ch = str.charAt(i);
    		
    		if(ch>='A' && ch<='Z') {
    			result += (char)(ch-'A'+'a');
    		}
    		else {
    			result += ch;
    		}
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(toLowerCase(sc.next()));
    }

}
