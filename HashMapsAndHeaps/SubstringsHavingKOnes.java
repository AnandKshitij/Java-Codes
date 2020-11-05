package HashMapsAndHeaps;

/*
1. You will be given a string
2. You will also be given an integer k
3. You need to find number of substrings possible in given string, with k 1's in them
4. Return this count
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main()
 */


import java.io.*;
import java.util.*;

public class SubstringsHavingKOnes { 
  
	static int countOfSubstringWithKOnes(String s, int K) 
    { 
		int input[] = new int [s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int val = ch-'0';
			
			if(val!=1)
			{
				val = 0;
			}
			
			input[i] = val;
		}
		
		HashMap<Integer,Integer> H = new HashMap<>();
		H.put(0,1);
		
		int prefixSum = 0;
		int count = 0;
		
		for(int i=0; i<input.length; i++)
		{
			prefixSum += input[i];
			int target = prefixSum-K;
			
			if(H.containsKey(target))
			{
				count += H.get(target);
			}
			
			if(!H.containsKey(prefixSum))
			{
				H.put(prefixSum,1);
			}
			else
			{
				H.put(prefixSum,H.get(prefixSum)+1);
			}
		}
		
		return count;
    }
	
    public static void main (String[] args) 
    { 
        Scanner scn = new Scanner(System.in);
        String s = scn.next(); 
        int K = scn.nextInt(); 
          
        System.out.println( 
            countOfSubstringWithKOnes(s, K)); 
    }  
      
}