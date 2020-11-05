package Array;

/*
1. A zero-indexed array A of length N contains all integers from 0 to N-1. 
2. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
2. Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], 
and then A[A[A[i]]]...
By that analogy, we stop adding right before a duplicate element occurs in S.
*/


import java.util.*;

public class NestingArray {

    public static int arrayNesting(int[] nums) {
    	int maxLength = 0;
    	
    	boolean visited[] = new boolean [nums.length];
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		if(!visited[i]) {
    			int val = nums[i];
    			visited[i] = true;
    			HashSet<Integer> H = new HashSet<>();
    			H.add(i);
    			while(!H.contains(val)) {
    				H.add(val);
    				visited[val] = true;
    				val = nums[val];
    			}
    			if(maxLength<H.size()) {
    				maxLength = H.size();
    			}
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
        System.out.println(arrayNesting(arr));
    }
}
