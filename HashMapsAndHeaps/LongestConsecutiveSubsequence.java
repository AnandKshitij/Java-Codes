package HashMapsAndHeaps;

/*
1. Given an array arr[] of positive integers. 
2. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the 
consecutive numbers can be in any order. 

Sample Input
7
2 6 1 9 4 5 3
Sample Output
6
*/

import java.util.*;

public class LongestConsecutiveSubsequence {

	public static int getLength(int input[])
	{
		boolean isStart[] = new boolean[input.length];
		HashSet<Integer> H = new HashSet<>();
		
		for (int i = 0; i < isStart.length; i++) {
			isStart[i] = true;
			H.add(input[i]);
		}
		
		
		for(int i=0; i<input.length; i++){
			int val = input[i];
			if(H.contains(val-1))
			{
				isStart[i] = false;
			}
		}
		
		int maxLength = 0;
		
		for(int i=0; i<input.length; i++)
		{
			int val = input[i];
			
			if(isStart[i])
			{
				int length = 1;
				
				while(H.contains(val+1))
				{
					length++;
					val++;
				}
				
				if(length>maxLength)
				{
					maxLength = length;
				}
			}
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int [n];
		
		for(int i=0; i<n; i++) {
			input[i] = s.nextInt();
		}
		
		System.out.println(getLength(input));
	}
}
