package Test3;

import java.util.*;

public class CollectingGrains {
	
	public static int[] findNextGreater(int arr[])
	{
		Stack<Integer> S = new Stack<>();
		int result[] = new int [arr.length];
		
		S.push(0);
		
		for(int i=1; i<arr.length; i++)
		{
			int curr = arr[i];
			
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			int topIndex = S.peek();
			int topValue = arr[topIndex];
			
			if(curr<topValue)
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && curr>=arr[S.peek()])
			{
				int index = S.pop();
				result[index] = i;
			}
			
			S.push(i);
		}
		
		while(!S.empty())
		{
			int index = S.pop();
			result[index] = -1;
		}
		
		return result;
	}
	
	public static int[] findNextGreaterToLeft(int arr[])
	{
		Stack<Integer> S = new Stack<>();
		int result[] = new int [arr.length];
		
		S.push(arr.length-1);
		
		for(int i=arr.length-2; i>=0; i--)
		{
			int curr = arr[i];
			
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			int topIndex = S.peek();
			int topValue = arr[topIndex];
			
			if(curr<topValue)
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && curr>=arr[S.peek()])
			{
				int index = S.pop();
				result[index] = i;
			}
			
			S.push(i);
		}
		
		while(!S.empty())
		{
			int index = S.pop();
			result[index] = -1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int arr[] = new int [n];
		
		for(int i=0; i<n; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int nextGreater[] = findNextGreater(arr);
		int nextGreaterLeft[] = findNextGreaterToLeft(arr);
		
		//index vs prefixSum
		HashMap<Integer,Integer> H = new HashMap<Integer,Integer>();
		
		int prefixSum = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			prefixSum += arr[i];
			H.put(i,prefixSum);
		}
		
		int maxGrain = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			int element = arr[i];
		}
		System.out.println(maxGrain);
	}

}
