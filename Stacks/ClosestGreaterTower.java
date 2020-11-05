package Stacks;

/*
1. All the towers in a city are in straight line.
2. You are given no of towers 'n' followed by height of 'n' towers.
3. For every tower(p), find the height of the closest tower (towards the right), greater than the
 height of tower(p).
4. Now , Print sum of all such heights (mod 1000000001).

Note : If for a tower(k) , no such tower exits then take its height as 0.
 */

import java.util.Scanner;
import java.util.Stack;

public class ClosestGreaterTower {
	
	public static int towerSum(int arr[])
	{
		int result = 0;
		int mod = (int)Math.pow(10,9)+1;
		
		Stack<Integer> S = new Stack<>();
		
		for(int i=0 ; i<arr.length ; i++)
		{
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			int val = arr[i];
			
			while(!S.empty() && val>arr[S.peek()])
			{
				result += val;
				result = result%mod;
				S.pop();
			}
			
			S.push(i);
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int towerHeight[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			towerHeight[i] = s.nextInt();
		}
		
		int result = towerSum(towerHeight);
		System.out.println(result);
	}

}
