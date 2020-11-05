package PriorityQueue;

/*
1. You will be given an Array with its length
2. You will also be given an integral value k
3. You need to find k largest elements from the given array
4. Input is handled for you
5. It is a functional problem ,please do not modify main()

output Format
 Output MUST be in descending order
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class KLargestElements
{
	public static void solve(int n,int[] arr,int k)
	{
		PriorityQueue<Integer> P = new PriorityQueue<>();
		
		for(int i=0; i<k; i++)
		{
			P.add(arr[i]);
		}
		
		int min = P.peek();
		
		for(int i=k; i<n ; i++)
		{
			int val = arr[i];
			
			if(arr[i]<=min)
			{
				continue;
			}
			else
			{
				P.remove();
				P.add(val);
				min = P.peek();
			}
			
		}
		
		int result[] = new int [P.size()];
		
		for(int i=result.length-1; i>=0 ; i--)
		{
			result[i] = P.remove();
		}
		
		for(int i=0; i<result.length; i++)
		{
			System.out.print(result[i]+" ");
		}
    }
	 public static void main (String[] args) throws IOException
	 {
	 	 Scanner scn= new Scanner(System.in);
	     int n = scn.nextInt();
	 	 int[] num = new int[n];
	 	 for (int i = 0; i < n; i++) 
	 	 {
	 	 	 	 num[i] = scn.nextInt();
	 	 }
	 	 int k = scn.nextInt();
	 	 solve(n,num,k);
	 }
}
