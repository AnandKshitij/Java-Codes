package Stacks;

import java.util.ArrayList;

/*
1. Given an array of integers, find the nearest smaller number for every element such that 
the smaller element is on left side.
2. If no small element present on the left print -1.
 */

/*
Here it is very difficult to handle the case of equality of elements
All the no.'s which are same are on top of each other will have the same answer
For that we need to pop all the same elements and see the answer below them
We have solved this question using this approach

An alternate approach could have been moving from right to left instead of left to right
 */

import java.util.Scanner;
import java.util.Stack;

public class SmallerElementOnLeft{
	
	public static int[] smallerOnLeft(int input[])
	{
		Stack<Integer> S = new Stack<Integer>();
		
		int result[] = new int [input.length];
		
		for(int i=0 ; i<input.length ; i++)
		{
			int val = input[i];
			
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && val<input[S.peek()])
			{
				int leftSmaller = -1;
				int index = S.pop();
				int popped = input[index];
				
				if(!S.empty())
				{
					if(input[S.peek()]!=popped)
					{
						leftSmaller = input[S.peek()];
					}
					else
					{
						ArrayList<Integer> indexes = new ArrayList<>();
						while(!S.empty() && input[S.peek()]==popped)
						{
							indexes.add(S.pop());
						}
						if(!S.empty())
						{
							leftSmaller = input[S.peek()];
						}
						for(int ct=0 ; ct<indexes.size() ; ct++)
						{
							S.push(indexes.get(ct));
						}
					}
				}
				result[index] = leftSmaller;
			}
			
			S.push(i);
		}
		
		while(!S.empty())
		{
			int leftSmaller = -1;
			int index = S.pop();
			int popped = input[index];
			if(!S.empty())
			{
				if(input[S.peek()]!=popped)
				{
					leftSmaller = input[S.peek()];
				}
				else
				{
					ArrayList<Integer> indexes = new ArrayList<>();
					while(!S.empty() && input[S.peek()]==popped)
					{
						indexes.add(S.pop());
					}
					if(!S.empty())
					{
						leftSmaller = input[S.peek()];
					}
					for(int ct=0 ; ct<indexes.size() ; ct++)
					{
						S.push(indexes.get(ct));
					}
				}
			}
		
			result[index] = leftSmaller;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int input[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			input[i] = s.nextInt();
		}
		
		int result[] = smallerOnLeft(input);
		
		for(int i=0 ; i<n ; i++)
		{
			System.out.print(result[i]+" ");
		}
 	}

}