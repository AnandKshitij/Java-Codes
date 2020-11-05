package HashMapsAndHeaps;

/*
1. You will be given two Arrays and their length.
2. You print count of their intersecting elements.
3. Input and is handled for you
4. It is a functional problem ,please do not modify main()
 */

import java.lang.*;
import java.io.*;
import java.util.*;

public class CountIntersectingElements
 {
	 public static void solve(int m,int n,int[] arr1,int[] arr2){
	    
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<arr1.length; i++)
		 {
			 int key = arr1[i];
			 
			 if(!H.containsKey(key))
			 {
				 H.put(key,1);
			 }
			 else
			 {
				 H.put(key,H.get(key)+1);
			 }
		 }
		 
		 int count = 0;
		 
		 for(int j=0; j<arr2.length; j++)
		 {
			 int key = arr2[j];
			 
			 if(H.containsKey(key))
			 {
				 count++;
				 int freq = H.get(key);
				 freq--;
				 H.put(key,freq);
				 if(freq==0)
				 {
					 H.remove(key);
				 }
			 }
			 
			 /*
			 If we have to calculate the one element only once irrespective of whether it comes 2 or 3 times in both the arrays
			 then our code will be
			 
			 if(H.containsKey(key))
			 {
				 count++;
				 H.remove(key);
			 }
			 
			 Only the if condition will change
			 
			 In that case we can do the question with hash set instead of hash map 
			 */
		 }
		 
		 System.out.println(count);
	     
	 }
	 public static void main (String[] args) throws IOException
	  {
	 	     Scanner scn= new Scanner(System.in);
	 	     int n = scn.nextInt();
	 	 	 int[] num = new int[n];
	 	 	 for (int i = 0; i < n; i++) {
	 	 	 	 num[i] = scn.nextInt();
	 	 	 }
	 	 	 int m = scn.nextInt();
	 	 	 int[] num2 = new int[m];
	 	 	 for (int i = 0; i < m; i++) {
	 	 	 	 num2[i] = scn.nextInt();
	 	 	 }
	 	 	 
	 	 	     solve(n,m,num,num2);
	  }
	  
	  
}