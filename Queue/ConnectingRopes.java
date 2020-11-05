package Queue;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
1. There are given N ropes of different lengths, we need to connect these ropes into one rope. 
2. The cost to connect two ropes is equal to sum of their lengths. 
3. The task is to connect the ropes with minimum cost.

Sample Input
5
4 2 7 6 9
Sample Output
62

 */

/*
We should select the smallest ropes first
This is because the rope which is selected first will be added maximum no. of times

4 2 7 6 9
Cost1 = (2+4)

(2+4) 7 6 9
Cost2 = (2+4+6)

(2+4+6) 7  9
Cost3 = (7+9) 

(2+4+6) (7+9)
Cost4 = (2+4+6+7+9)

So at each point we require the minimum two elements in the array
We will stop when we are left with only one rope

So the best data structure for performing this task will be priority queue
It will give us the minimum element in O(log n) time complexity
 */

public class ConnectingRopes {
	 
	public static long minCostRopes(long[] arr) {
		
		if(arr.length==0)
		{
			return 0l;
		}
		
		if(arr.length==1)
		{
			return arr[0];
		}
		//we write L capital in long because Long is the wrapper class of long
		//like Integer is the wrapper class of int
		//like Double is the wrapper class of double
		PriorityQueue<Long> priorQueue = new PriorityQueue<>();
		
		//first we will put all the elements in the priority queue
		for(int i=0 ; i<arr.length ; i++)
		{
			priorQueue.add(arr[i]);
		}
		
		long result = 0l;
		while(priorQueue.size()>1)
		{
			long val1 = priorQueue.remove();
			long val2 = priorQueue.remove();
			priorQueue.add(val1+val2);
			result += val1+val2;
		}
		
		return result;
		
	 }

	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 	 int n = scn.nextInt();
	 	 	 long arr[] = new long[n];
	 	 	 for (int i = 0; i < n; i++) 
	 	 	 	 arr[i] = scn.nextLong();
	 	 	 System.out.println(minCostRopes(arr));
	 	 
	 }
}