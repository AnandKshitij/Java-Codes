package Brackets;

/*
1. Given an expression string exp. Examine whether the pairs and the orders of "{","}","(",")","[","]" are 
correct in exp.

Example
The program should print 'balanced' for exp = "[()]{}{[()()]()}" and 'not balanced' for exp = "[(])"
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class BracketsAreValid{
    
	public static void isbalanced(String str)
	{
		Stack<Character> S = new Stack<>();
		
		for(int i=0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			
			if(S.empty() || ch=='(' || ch=='{' || ch=='[')
			{
				S.push(ch);
				continue;
			}
			
			if(ch==')')
			{
				if(S.empty() || S.peek()!='(')
				{
					System.out.println("not balanced");
					return ;
				}
				S.pop();
			}
			
			else if(ch=='}')
			{
				if(S.empty() || S.peek()!='{')
				{
					System.out.println("not balanced");
					return ;
				}
				S.pop();
			}
			
			else if(ch==']')
			{
				if(S.empty() || S.peek()!='[')
				{
					System.out.println("not balanced");
					return ;
				}
				S.pop();
			}
		}
		
		if(!S.empty())
		{
			System.out.println("not balanced");
			return ;
		}
		System.out.println("balanced");
    	
    }
	 

	 public static void main (String[] args) 
	 {
	 	 Scanner s=new Scanner(System.in);
	  	 String Str = s.next();
	  	 isbalanced(Str);
	 
	 }
}
