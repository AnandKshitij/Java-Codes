package HashMapsAndHeaps;

/*

1.You are given an array.Two variables A and B are defined as minimum and maximum in the array respectively.
Your task is to find how many number should be added to the given array such that all the element in the 
range [A,B] occurs at least once in the array.
2.Return integer. 
3.Input and output is handled for you
4.It is a functional problem ,please do not modify main()
*/

/*
No. of elements in the range of A&B are
B-A+1

Example no.'s between 10&15 are
10 11 12 13 14 15
No.'s are 15-10+1=6

We will add all the no.'s in the array in a hash set
In the end we will subtract the the size of hash set from no. of elements required
This will give us the no. of elements required

 */

import java.util.*;

public class IncompleteArray {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		HashSet<Integer> H = new HashSet<>();
		
		for(int i=0 ; i<n ; i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
			if(arr[i]<min)
			{
				min = arr[i];
			}
			
			if(H.isEmpty())
			{
				H.add(arr[i]);
			}
			else
			{
				if(!H.contains(arr[i]))
				{
					H.add(arr[i]);
				}
			}
		}

		int total = max-min+1;
		int present = H.size();
		
		System.out.println((total-present));
		
		
		
	}
}