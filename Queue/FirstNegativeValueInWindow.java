package Queue;

/*
Given an array and a positive integer k
Print the earliest(first) negative integer for each and every window(contiguous subarray) of size k. 
If there is no negative number in a window print 0.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNegativeValueInWindow  {
	 
	 public  static void window (int[] arr, int k)
	 {
		 // Write your code here
		 int N = arr.length;
		 
		 int index = N-k;
		 
		 if(index>=N)
		 {
			 index = N-1;
		 }
		 
		 Queue<Integer> Q = new LinkedList<>();
		 
		 for(int i=0 ; i<N ; i++)
		 {
			 if(arr[i]<0)
			 {
				 Q.add(i);
			 }
		 }
		 
		 for(int i=0 ; i<=index ; i++)
		 {
			 int nIndex = 0;
			 
			 if(!Q.isEmpty())
			 nIndex = Q.peek();
			 else
			 {
				 System.out.print("0 ");
				 continue;
			 }
			 int diff = nIndex-i;
			 
			 if(diff<k)
			 {
				 System.out.print(arr[nIndex]+" ");
				 if(diff==0)
				 Q.remove();
			 }
			 else
			 {
				 System.out.print("0 ");
			 }
			 
		 }
	 }

	 public static void main (String[] args) {
	      	  Scanner s=new Scanner(System.in);
	 	      int size=s.nextInt();
	 	      int[]arr=new int[size];
	 	      for(int i=0;i<size;i++)
	 	      {
	 	          arr[i]=s.nextInt();
	 	      }
	 	     int k=s.nextInt();
	 	     window(arr, k);
	 	  
	 }
}
