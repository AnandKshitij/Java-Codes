package Stacks;

/*
1. Given an expression exp of length n consisting of some brackets. 
2. The task is to print the bracket numbers when the expression is being parsed. 
3. Bracket number is position of bracket pair to which the current bracket belongs.

Sample Input
"(a+(b*c))+(d/e)"
Sample Output
1 2 2 1 3 3
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class BracketPosition 
{
     public static void printBracketsPos(String s)
     {
    	int pos = 1;
    	Stack<Integer> S = new Stack<>();
    	
    	int result[] = new int [s.length()];
    	
    	for(int i=0 ; i<s.length() ; i++)
    	{
    		char ch = s.charAt(i);
    		
    		if(ch=='(')
    		{
    			S.push(pos);		
    			result[i] = pos;
    			pos++;
    		}
    		else if(ch==')')
    		{
    			int val = S.pop();
    			result[i] = val;
    		}
    	}
    	
    	for(int i=0 ; i<result.length ; i++)
    	{
    		if(result[i]!=0)
    		System.out.print(result[i]+" ");
    	}
     }
        
	 public static void main (String[] args) 
	 {
	     Scanner scn=new Scanner(System.in);
	     String s=scn.next();
	     printBracketsPos(s);
	 }
}
