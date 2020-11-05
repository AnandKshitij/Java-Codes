package hashMapStoringFirstOccuerence;

/*
1.Given a binary string, the task is to find maximum substring length with equal number of 0's and 1's.
2.You have to complete the function print() which should print the maximum length of such substring.

Sample Input
1100011
Sample Output
6
*/

import java.util.*;

public class LongestSubArrayWithEqual0sAnd1s {

	 public static void print(char[] A) 
	 {
		 int arr[] = new int [A.length];
		 
		 for(int i=0; i<A.length; i++)
		 {
			 if(A[i]=='0')
			 {
				 arr[i] = -1;
			 }
			 else if(A[i]=='1')
			 {
				 arr[i] = 1;
			 }
		 }
		 
		 System.out.println(maxLen(arr,arr.length));
	 }
	 
	 static int maxLen(int arr[], int n) 
	 {
		 int prefixSum = 0;
	     HashMap<Integer,Integer> H = new HashMap<>();
	     H.put(0,-1);
	    	
	     int maxLength = 0;
	    	
	     for(int i=0; i<arr.length; i++)
	     {
	    	prefixSum += arr[i];
	    		
	    	if(H.containsKey(prefixSum))
	    	{
	    		int length = i-H.get(prefixSum);
	    		if(length>maxLength)
	    		{
	    			maxLength = length;
	    		}
	    		}
	    		else
	    		{
	    			H.put(prefixSum,i);
	    		}
	    	}
	    	
	    	return maxLength;
	 }

	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 String str = s.next();
	 	 char[] ans = str.toCharArray();
	 	 print(ans);
	 }

}