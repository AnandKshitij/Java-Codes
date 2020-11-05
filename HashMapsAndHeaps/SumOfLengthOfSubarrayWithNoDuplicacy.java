package HashMapsAndHeaps;

/*
1. Given an array. 
2. Return the sum of lengths of contiguous subarrays having all distinct elements.

Sample Input
4
1 2 3 4
Sample Output
20
 */

import java.util.*;

public class SumOfLengthOfSubarrayWithNoDuplicacy {

    public static int sumLength(int[] arr) {
        //Write your code here
       int start = 0;
		int end = 1;
		 
		int length = 0;
		
		HashSet<Integer> H = new HashSet<>();
		H.add(arr[start]);
		
		while(start<arr.length && end<=arr.length)
		{
			while(end<arr.length && !H.contains(arr[end]))
			{
				H.add(arr[end]);
				end++;
			}
			int n = end-start;
			length += (n*(n+1))/2;
			H.remove(arr[start]);
			start++;
		}
		
		return length;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(sumLength(arr));
    }
}