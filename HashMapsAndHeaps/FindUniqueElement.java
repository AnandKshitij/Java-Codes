package HashMapsAndHeaps;

/*
1. You will be given an Array and its length.
2. You will also be given k, the number of times each element repeats in that array, except ONE element.
3. You need to find that ONE unique element, which does not repeat and return it
4. Input and output is handled for you
5. It is a functional problem ,please do not modify main()

Sample Input
7 2
2 8 2 9 0 9 0
Sample Output
8
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class FindUniqueElement
 {
	 public static void main (String[] args)
	  {
	     Scanner s = new Scanner(System.in);
	     int n = s.nextInt();
	     int k = s.nextInt();
	     
	     int input[] = new int [n];
	     
	     for(int i=0; i<n; i++)
	     {
	    	 input[i] = s.nextInt();
	     }
	     
	     solve(input,k);
	  }
	 
	  public static void solve(int [] arr,int k)
	  {
	
		  HashMap<Integer,Integer> H = new HashMap<>();
		  
		  for(int i=0; i<arr.length; i++)
		  {
			  int val = arr[i];
			  
			  if(!H.containsKey(val))
			  {
				  H.put(val,1);
			  }
			  else
			  {
				  H.put(val,H.get(val)+1);
			  }
		  }
		  
		  for(int i : H.keySet())
		  {
			  if(H.get(i)==1)
			  {
				  System.out.println(i);
			  }
		  }
	  }
}
