package Stacks;

/*
1. You have got sequences of n words to manipulate. 
2. If in a sequence, two same words come together then he'll destroy each other. 
3. Return the number of words left in the sequence after this pairwise destruction.
4. Words are contiguous stretches of printable characters delimited by white space.

Input Format
 First line of input contains an integer n denoting the number of words in a sequence. 
Second line are n space separated words of the sequence.
output Format
 Return the number of words left for the sequence.
 
 Sample Input
"4
tom jerry jerry tom"
Sample Output
0
 */

import java.util.*;

public class RepeatedStringDeletion {
	
	public static int findElementsLeft(String[] str)
	{
		Stack<String> S = new Stack<>();
		
		for(int i=0 ; i<str.length ; i++)
		{
			String curr = str[i];
			
			if(S.empty())
			{
				S.add(curr);
				continue;
			}
			
			String topString = S.peek();
			
			if(topString.equals(curr))
			{
				S.pop();
			}
			else
			{
				S.push(curr);
			}
		}
		
		return S.size();
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		String[] str = new String [n];
		
		for(int i=0 ; i<n ; i++)
		{
			str[i] = s.next();
		}
		
		int result = findElementsLeft(str);
		System.out.println(result);
	}

}
