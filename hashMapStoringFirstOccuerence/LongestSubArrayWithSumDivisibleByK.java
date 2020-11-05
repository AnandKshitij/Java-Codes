package hashMapStoringFirstOccuerence;

/*

1.Given an array containing N integers and a positive integer K.
2.The task is to find the length of the longest sub array with sum of the elements
divisible by the given value K.
3.You have to complete the function print() which should print the length of the longest sub array with sum of elements
divisible by the given value of K.

*/

import java.util.*;

public class LongestSubArrayWithSumDivisibleByK {
	
	public static int getLength(int input[], int k)
	{
		int prefixSum = 0;
		
		int maxLength = 0;
		
		HashMap<Integer,Integer> H = new HashMap<>();
		H.put(0,-1);
		
		for(int i=0; i<input.length; i++)
		{
			prefixSum += input[i];
			prefixSum = prefixSum%k;
			if(prefixSum<0)
			{
				prefixSum += k;
			}
			
			if(H.containsKey(prefixSum))
			{
				int length = i-H.get(prefixSum);
				if(length>maxLength)
				{
					maxLength = length;
				}
			}
			else
			{
				H.put(prefixSum,i);
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int input[] = new int [n];
		
		for(int i=0; i<n; i++)
		{
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		
		System.out.println(getLength(input,k));
	}

}
