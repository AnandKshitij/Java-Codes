package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Compare the two strings s and t
Strings contain lower case letters and '#' character
'#' deletes the previous one character
After deletions compare the strings and return true if they are equal and return false if not.
*/
public class CompareStringsAfterDeletion {
	 
	public static boolean compareString(String S, String T) 
	{
	 	//write your code here
		Stack<Character> S1 = new Stack<>();
		Stack<Character> S2 = new Stack<>();
		
		for(int i=0 ; i<S.length() ; i++)
		{
			char ch = S.charAt(i);
			
			if(ch=='#')
			{
				if(!S1.empty())
				{
					S1.pop();
				}
			}
			else
			{
				S1.push(ch);
			}
		}
		
		for(int i=0 ; i<T.length() ; i++)
		{
			char ch = T.charAt(i);
			
			if(ch=='#')
			{
				if(!S2.empty())
				{
					S2.pop();
				}
			}
			else
			{
				S2.push(ch);
			}
		}
		
		
		while(!S1.empty() && !S2.empty())
		{
			char ch1 = S1.pop();
			char ch2 = S2.pop();
			
			if(ch1 != ch2)
			{
				return false;
			}
		}
		
		if(!S1.empty() || !S2.empty())
		{
			return false;
		}
		
		return true;
	}

//Driver program
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s1 = scn.next();
	 	 String s2 = scn.next();

	 	 System.out.println(compareString(s1, s2));
	 }
}