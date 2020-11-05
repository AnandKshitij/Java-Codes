package Stacks;

import java.util.*;

/*
package Stacks;

import java.util.*;
import java.lang.*;
import java.io.*;

Given a string S consisting of opening and closing parenthesis '(' and ')'. 
Find length of the longest valid parenthesis substring.

Sample Input
)()())
Sample Output
4

*/

public class longestValidParenthesis
{
    public static int longestParenthesis(String s)
    {
    	Stack<Integer> S = new Stack<Integer>();
    	S.push(-1);
    	int result = 0;
    	
    	for(int i=0 ; i<s.length() ; i++)
    	{
    		char ch = s.charAt(i);
    		
    		if(ch=='(')
    		{
    			S.push(i);
    			continue;
    		}
    		int topIndex = S.peek();
    		
    		char topChar = ch;
    		
    		if(topIndex!=-1)
    		{
    			topChar = s.charAt(topIndex);
    		}
    			
    		if(topChar==')')
    		{
    			S.push(i);
    			continue;
    		}
    		
    		S.pop();
    		
    		int nextTop = S.peek();
    		
    		char nextT = ')';
    		
    		if(nextTop!=-1)
    		{
    			nextT = s.charAt(S.peek());
    		}
    		
    		int Ans = i-nextTop;
    		
    		if(Ans>result)
    		{
    			result = Ans;
    		}
    	}
    	
    	return result;
    }

	public static void main (String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		String s=scn.next();
		System.out.println(longestParenthesis(s));
	}
}

