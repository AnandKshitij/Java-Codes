package Stacks;

import java.util.*;
import java.util.Scanner;

public class NextWarmerDay 
{
	/*
	You are given an array having temperatures on various days.
	For each day you need to find out the number of days you have to wait for the next warmer day.
	You have to return the array containing the value for each day. 
	
	Solution in notebook
	 */
	
	public static int[] findWarmerTemp(int T[])
	{
		// Write your code here only
		int L = T.length;
		int result[] = new int[L];
		
		Stack<Integer> S = new Stack<>();
		S.push(0);
		
		for(int i=1 ; i<T.length ; i++)
		{
			int val = T[i];
			
			while(!S.empty())
			{
				int top = S.peek();
				int comp = T[top];
				
				if(comp>=val)
				{
					break;
				}
				else
				{
					S.pop();
					result[top] = i-top;
				}
			}
			
			S.push(i);
		}
		return result;
	}

	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);  
		int n=sc.nextInt();
		int temp[]=new int[n];
		for(int i=0;i<n;i++)temp[i]=sc.nextInt();
		int res[]=findWarmerTemp(temp);
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i]);
		}	
	}
}