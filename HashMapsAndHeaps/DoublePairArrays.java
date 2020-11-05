package HashMapsAndHeaps;

/*
1. Given an array of integers A with even length, return true if and only if it is possible to 
reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < length(A) / 2.
 */

/*
We will be using hash maps to solve this problem

Suppose we have
2 4 2 6 6 8 3 3 4 4


HashMap

2 -> 2
3 -> 2
4 -> 3
6 -> 2 
8 -> 1

We will also store the keys in ascending order

Keys = [2 3 4 6 8]

For 2 we will try to find 4
2 has frequency 2 
4 has frequency 3
So 2 will be balanced

HashMap

3 -> 2
4 -> 1
6 -> 2
8 -> 1

Now for 3 we will find 6
Both have frequency 2 so both will be balanced

HashMap

4 -> 1
8 -> 1

Now for 4 we will find 8
Both have frequency 1 so both will be balanced

HashMap
Empty

So we return true


Another example
-96 -48 -72 -48 -48 -36 -24 -96 -24 0 -12 0

HashMap

-96 -> 2
-72 -> 1
-48 -> 3
-36 -> 1
-24 -> 2
-12 -> 1
0 -> 2

keys = [-96 -72 -48 - 36 -24 -12 0]

For negative no.'s we find the half of the no.
This is because we have keys in sorted order
And for negative no.'s the half of the no. is greater than the no.
There is no point checking for a negative value if its odd
Because its half cannot be present in the array
As we have integer array

Here we also have zero which is a special case
Twice of zero is also zero
Zero should always have even frequency

The rest working is same
 
 */


import java.util.*;

public class DoublePairArrays
{
	public static boolean canReorder(int[] A) {
        
    	HashMap<Integer,Integer> H = new HashMap<>();
    	
    	for(int i=0; i<A.length; i++)
    	{
    		int val = A[i];
    		
    		if(!H.containsKey(val))
    		{
    			H.put(val,1);
    		}
    		else
    		{
    			H.put(val,H.get(val)+1);
    		}
    	}
    	
    	int size = H.size();
    	
    	int keys[] = new int [size];
    	
    	int j=0;
    	for(int i : H.keySet())
    	{
    		keys[j] = i;
    		j++;
    	}
    	
    	Arrays.sort(keys);
    	
    	for(int i=0 ; i<keys.length ; i++)
    	{
    		int ourVal = keys[i];
    		int findVal = 0;
    		
    		if(!H.containsKey(ourVal))
    		{
    			H.remove(0);
    			continue;
    		}
    		
    		if(ourVal==0)
    		{
    			if(H.get(0)%2==0)
    			{
    				continue;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		else if(ourVal>0)
    		{
    			findVal = 2*ourVal;
    		}
    		else
    		{
    			//we cannot find half of negative integer value
    			//as we have got integer array
    			if(ourVal%2!=0)
    			{
    				return false;
    			}
    			findVal = ourVal/2;
    		}
    		
    		if(!H.containsKey(findVal))
    		{
    			return false;
    		}
    		int findFreq = H.get(findVal);
    		int ourFreq = H.get(ourVal);
    		
    		if(ourFreq>findFreq)
    		{
    			return false;
    		}
    		
    		findFreq = findFreq-ourFreq;
    		
    		H.remove(ourVal);
    		
    		H.put(findVal,findFreq);
    		
    		if(findFreq==0)
    		{
    			H.remove(findVal);
    		}
    	}
    	
    	if(H.isEmpty())
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[] a = new int[sc.nextInt()];
        for(int i=0;i<a.length;i++)a[i]=sc.nextInt();
        System.out.println(canReorder(a));
    }
}