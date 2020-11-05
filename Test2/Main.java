package Test2;

//next smaller element

import java.util.*;

public class Main {
	
	public static int[] nextSmaller(int input[])
	{
		Stack<Integer> S  = new Stack<>();
		
		int result[] = new int [input.length];
		
		for(int i=0 ; i<input.length ; i++)
		{
			result[i] = -1;
		}
		
		for(int i=0 ; i<input.length ; i++)
		{
			int val = input[i];
			
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			if(val>=input[S.peek()])
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && val<input[S.peek()])
			{
				int index = S.pop();
				result[index] = val;
			}
			
			S.push(i);
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
		
		int result [] = nextSmaller(input);
		
		for(int i=0 ; i<n ; i++)
		{
			System.out.println(result[i]);
		}
	}

}
