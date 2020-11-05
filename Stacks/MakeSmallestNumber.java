package Stacks;

import java.util.*;

/*
1. Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Example
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 */

public class MakeSmallestNumber {
	
	public static String getMinNo(String num , int K)
	{
		Stack<Integer> S = new Stack<>();
		
		String input = num;
		
		for(int i=0 ; i<input.length() ; i++)
		{
			char ch = input.charAt(i);
			int digit = ch-'0';
			
			if(S.empty())
			{
				S.push(digit);
				continue;
			}
			
			while(!S.empty() && K>0 && S.peek()>digit)
			{
				S.pop();
				K--;
			}
		
			S.push(digit);
		}
		
		while(!S.empty() && K>0)
		{
			S.pop();
			K--;
		}
		
		String result = "";
		
		while(!S.empty())
		{
			result = S.pop()+result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int K = s.nextInt();
		String num = s.next();
		
		String Ans = getMinNo(num,K);
		
		String result = "";
		
		int i=0;
	    for( ; i<Ans.length() ; i++)
	    {
	        if(Ans.charAt(i)!='0')
	        {
	            break;
	        }
	    }
	    
	    for( ; i<Ans.length() ; i++)
	    {
	        result = result + Ans.charAt(i);
	    }
	    
	    System.out.println(result);
	}

}

