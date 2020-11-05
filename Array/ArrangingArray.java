package Array;

/*
1. You are given two integers N and K.
2. You have to construct a list which contains N different positive integers ranging from 1 to N and obeys the following requirement: 
Suppose you construct the list [a1, a2, a3, ... , an], then the list [ |a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an| ] 
should have exactly K distinct integers.
3. Example 1:
Input: N = 3, K = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
4. Example 2:
Input: N = 3, K = 2
Output: [1, 3, 2]
Explanation:The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers:1 and 2. 
*/

import java.util.*;

public class ArrangingArray {
	
    public static int[] constructArray(int n, int k) {
        
    	int result [] = new int [n];
    	
    	int startIndex = 0;
    	int endIndex = n-k;
    	
    	while(startIndex<endIndex) {
    		int val = startIndex+1;
    		result[startIndex] = val;
    		startIndex++;
    	}
    	
    	int startVal = startIndex+1;
    	int endVal = n;
    	
    	while(startIndex<n) {
    		
    		result[startIndex] = endVal;
    		endVal--;
    		startIndex++;
    		if(startIndex<n) {
    			result[startIndex] = startVal;
    			startVal++;
    			startIndex++;
    		}
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] result = constructArray(N, K);
        if (verify(result, N, K)) {
            System.out.println("Nice Arrangement");
        } else {
            System.out.println("Try Harder");
        }
    }
    
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    private static boolean verify(int[] arr, int N, int K) {
        if (arr.length < N) {
            return false;
        }
        boolean[] a = new boolean[N + 1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (a[arr[i]]) {
                return false;
            } else {
                a[arr[i]] = true;
            }
            if (i == N - 1) {
                break;
            } else {
                if (set.contains(Math.abs(arr[i] - arr[i + 1])) == false) {
                    set.add(Math.abs(arr[i] - arr[i + 1]));
                }
            }
        }
        if (set.size() != K) {
            return false;
        }
        return true;
    }
}