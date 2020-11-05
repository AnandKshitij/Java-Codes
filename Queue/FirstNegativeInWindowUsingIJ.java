package Queue;

/*
Now we will solve the same question using i and j.
Moving i forward will work as dequeue and moving j forward will work as enqueue 
This approach is better because its space complexity is O(1)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNegativeInWindowUsingIJ  {
	 
	 public  static void window (int[] arr, int k)
	 {
		 // Write your code here
		 int N = arr.length;
		 
		 int index = N-k;
		 
		 if(index>=N)
		 {
			 index = N-1;
		 }
		 
		 int i=0; 
		 int j=0;
		 
		 while(i<=index && j<N)
		 {
			 if(arr[j]<0)
			 {
				 int nIndex = j;
				 int diff = nIndex-i;
				 
				 if(diff<k)
				 {
					 System.out.print(arr[nIndex]+" ");
				 }
				 else
				 {
					 System.out.print("0 ");
				 }
				 
				 i++;
				 if(i>j)
				 {
					 j=i;
				 }
			 }
			 else
			 {
				 j++;
			 }
		 }
		 
		 while(i<=index)
		 {
			 System.out.print("0 ");
			 i++;
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

