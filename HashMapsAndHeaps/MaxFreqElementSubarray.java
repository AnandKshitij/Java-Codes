package HashMapsAndHeaps;

/*
1. Given an array A. Let X be an element in the array which has the maximum frequency. 
2. The task is to find the smallest sub array of the array which also has X as the maximum frequency element.
3. If two or more elements have the same frequency (i.e., maximum frequency) and the same sub array size then print the sub 
segment which occurs first in the array.
*/

import java.util.*;

public class MaxFreqElementSubarray{

	static class Triplet
	{
		int freq;
		int startIndex;
		int endIndex;
	}
	
    public static void subarrAllOcc(int[] arr) 
    {
    	HashMap<Integer,Triplet> H = new HashMap<>();
    	
    	int highFreq = 0;
    	int bestStart=0;
    	int bestEnd=0;
    	
    	for(int i=0; i<arr.length; i++)
    	{
    		int val = arr[i];
    		
    		if(!H.containsKey(val))
    		{
    			Triplet T = new Triplet();
    			T.freq = 1;
    			T.startIndex = i;
    			T.endIndex = i;
    			
    			if(highFreq<1)
    			{
    				highFreq = 1;
    				bestStart = i;
    				bestEnd = i;
    			}
    			
    			H.put(val,T);
    		}
    		
    		else
    		{
    			Triplet T = H.get(val);
    			T.freq = T.freq+1;
    			T.endIndex = i;
    			
    			if(T.freq>highFreq)
    			{
    				highFreq = T.freq;
    				bestStart = T.startIndex;
    				bestEnd = T.endIndex;
    			}
    			
    			else if(T.freq==highFreq)
    			{
    				if((T.endIndex-T.startIndex)<(bestStart-bestEnd))
    				{
    					highFreq = T.freq;
        				bestStart = T.startIndex;
        				bestEnd = T.endIndex;
    				}
    			}
    			
    			H.put(val,T);
    			
    		}
    	}
    	
    	for(int i=bestStart; i<=bestEnd; i++)
    	{
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    	
    	
    }

   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        subarrAllOcc(arr);
    }
}
