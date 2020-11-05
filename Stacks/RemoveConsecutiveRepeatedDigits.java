package Stacks;

/*
1. Given an number N, remove consecutive repeated digits from it.
2. Return the number after deletions.

Input Format
 First line of each test case contains the integer N.
output Format
 Print the number after removing consecutive digits.
 
Sample Input
"12224"
Sample Output
124
 */


import java.util.*;

public class RemoveConsecutiveRepeatedDigits {
	
	public static int findNonRepeating(int n)
	{
		Stack<Integer> S = new Stack<>();
		
		while(n>0)
		{
			int digit = n%10;
			
			if(S.empty())
			{
				S.push(digit);
			}
			else
			{
				if(S.peek()!=digit)
				{
					S.push(digit);
				}
			}
			
			n = n/10;
		}
		
		int result = 0;
		
		while(!S.empty())
		{
			result = result*10 + S.pop();
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int result = findNonRepeating(n);
		System.out.println(result);
	}

}
