package PriorityQueue;

/*
1. Given an array A[] of integers, sort the array according to frequency of elements. 
2. Elements that have higher frequency come first. 
3. If frequencies of two elements are same, then smaller number comes first.
*/

import java.util.*;

public class SortArrayByFrequency {
	
	static class Pair
	{
		int freq;
		int element;
	}
	
	static class freqComparator implements Comparator<Pair>
	{
		public int compare(Pair P1, Pair P2)
		{
			if(P1.freq!=P2.freq)
			{
				//descending order
				return P2.freq-P1.freq;
			}
			else
			{
				//ascending order
				return P1.element-P2.element;
			}
		}
	}
	
	public static int[] getSorted(int input[])
	{
		HashMap<Integer,Integer> H = new HashMap<>();
		
		for(int i=0; i<input.length; i++)
		{
			int val = input[i];
			
			if(!H.containsKey(val))
			{
				H.put(val,1);
			}
			else
			{
				H.put(val,H.get(val)+1);
			}
		}
		
		Pair arr[] = new Pair[H.size()];
		int i=0;
		
		for(int element : H.keySet())
		{
			int freq = H.get(element);
			Pair P = new Pair();
			P.element = element;
			P.freq = freq;
			arr[i] = P;
			i++;
		}
		
		PriorityQueue<Pair> P = new PriorityQueue<>(new freqComparator());
		
		for(i=0 ; i<arr.length ; i++)
		{
			P.add(arr[i]);
		}
		
		int result[] = new int [input.length];
		int j=0;
		
		while(!P.isEmpty())
		{
			Pair temp = P.remove();
			int element = temp.element;
			int freq = temp.freq;
			
			for(int k=0 ; k<freq ; k++)
			{
				result[j] = element;
				j++;
			}
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			input[i] = s.nextInt();
		}
		
		int result[] = getSorted(input);
		
		for(int i=0; i<n ; i++)
		{
			System.out.print(result[i]+" ");
		}
		System.out.println();
		s.close();
	}
}
