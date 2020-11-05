package Queue;

/*
1. You are given an array of integers.
2. You have to find the sum of smallest and second smallest elements for all the subarrays(of size>=2),
and then return the maximum sum among them.

Example : 4 5 2 7
For[4,5] -> sum=9, For[4,5,2] -> sum=6, For[4,5,2,7] -> sum=6,
For[5,2] -> sum=7, For[5,2,7] -> sum=7,For[2,7] -> sum=9 
Answer : 9

Sub array of an array contains continuous elements while the subset of an array can have elements in 
any order.

So for an array of size n
No. of sub arrays = n(n+1)/2
No. of sub sets = 2^n

We have to find the sub array with highest value of smallest and second smallest element
So definitely we cannot consider sub arrays with one element
We can consider sub arrays with two elements

We can consider sub arrays with 3 elements
But it will be of no use 
Because on adding an element to the 2 element sub array
Either the sum of minimum+second minimum will decrease or remain same

Same is the case for all other higher element sub arrays
So we will only consider the sub arrays with size 2
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class LargestMinMaxPair {
    
	public static long findlargest(long arr[],int n)
	{
		long result = Long.MIN_VALUE;
		for(int i=0 ; i+1<arr.length ; i++)
		{
			long val = (long)(arr[i]+arr[i+1]);
			if(val>result)
			{
				result = val;
			}
		}
		
		return result;
    }
	  
	public static void main (String[] args)throws Exception 
	{
	  	  Scanner sc=new Scanner(System.in);
	  	  int n=sc.nextInt();
	      long arr[]=new long[n];
	          for(int i=0;i<n;i++)arr[i]=sc.nextLong();
	          System.out.println(findlargest(arr,n));
	  
	 }
}