package Queue;

/*
Now we will solve the same question using i and j.
Moving i forward will work as dequeue and moving j forward will work as enqueue 
This approach is better because its space complexity is O(1)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class LargestValueInWindow  {
	
	public static int[] nextGreaterElement(int[] arr)
	{
		Stack<Integer> S = new Stack<>();
		
		int result[] = new int [arr.length];
		S.push(0);
		
		for(int i=1 ; i<arr.length ; i++)
		{
			int currVal = arr[i];
			
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && currVal>arr[S.peek()])
			{
				result[S.pop()] = i;
			}
			S.push(i);
		}
		
		while(!S.empty())
		{
			result[S.pop()] = arr.length;
		}
		
		return result;
	}
	 
	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		if(nums.length==0 || k==0)
		{
			int result[] = new int [0];
			return result;
		}
		
		int nextLarger[] = nextGreaterElement(nums);
		
		int result[] = new int [nums.length-k+1];
		
		for(int i=0 ; i+k<=nums.length ; i++)
		{
			int range = i+k;
			int j=i;
			
			while(j<range)
			{
				int index = nextLarger[j];
				
				if(index<range && index!=nums.length)
				{
					j = index;
				}
				else
				{
					break;
				}
			}
			
			result[i] = nums[j];
		}
		return result;
    }
	 public static void main (String[] args) {
	      	  Scanner s=new Scanner(System.in);
	 	      int size=s.nextInt();

	 	      int k=s.nextInt();
	 	      
	 	      
	 	      int[] arr=new int[size];
	 	 
	 	      for(int i=0;i<size;i++)
	 	      {
	 	          arr[i]=s.nextInt();
	 	      }
	 	     int[] result = new int[size-k+1];
	 	     result = maxSlidingWindow(arr, k);
	 	    
	 	     for(int i=0 ; i<result.length ; i++)
	 	     {
	 	    	 System.out.println(result[i]+" ");
	 	     }
	 	     System.out.println();
	 	  
	 }
}

