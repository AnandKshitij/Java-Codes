package hashMapStoringFirstOccuerence;

/*
1. Given an array having both positive and negative integers. 
2. The task is to complete the function maxSum_0() which returns the length of maximum subarray with 0 sum. 
3. The function takes two arguments an array A and n where n is the size of the array A.

Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
5
 */


import java.util.*;

public class LongestSubArrayWithSum0 {

    static int maxLen(int arr[], int n) {
	 
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxLen(arr, n));
    }
}