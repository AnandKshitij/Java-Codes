package Brackets;
/*
You are given a string containing only curly brackets '{' and '}'
You can perform reversals on any bracket
Reversal means '{' --> '}' or '}' --> '{'
Perform the minimum reversals so that the string becomes balanced.
 */
import java.util.Scanner;
import java.util.Stack;

public class ReverseBracketToBalanceExpression {
	
	public static int reverseBracket(String str)
	{
		Stack<Character> S = new Stack<>();
		
		int op = 0;
		int cl = 0;
		
		for(int i=0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);

			if(ch=='{')
			{
				S.push(ch);
			}
			if(ch=='}')
			{
				if(S.empty())
				{
					S.push(ch);
					continue;
				}
				char temp = S.peek();
				if(temp=='{')
				{
					S.pop();
				}
				if(temp=='}')
				{
					S.push(ch);
				}
			}
		}
		
		while(!S.empty())
		{
			char ch = S.pop();
			if(ch=='{')
			{
				op++;
			}
			if(ch=='}')
			{
				cl++;
			}
		}
		
		
		//if no. of brackets left unsettled (op+cl) is odd
		//then this means the brackets cannot be settles by reversals
		//in this case we will return -1
		if((op+cl)%2!=0)
		{
			return -1;
		}
		
		int result = 0;
		
		if(op%2==0)
		{
			result = op/2 + cl/2;
		}
		if(op%2!=0)
		{
			result = op/2 + cl/2 + 2;
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int result = reverseBracket(str);
		System.out.println(result);
	}

}
