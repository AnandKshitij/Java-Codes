package Array;

/*
1. You are given a sorted array of integers of length N. 
2. You have to return an array of the squares of each number, also in sorted non-decreasing order.
3. For example, 
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
*/


import java.util.*;

public class SortedSquares {
	
    public static int[] sortedSquares(int[] A) {
       
    	int n = A.length;
    	
    	int sorted[] = new int [n];
    	
    	
    	int start = 0;
    	int end = n-1;
    	
    	int k = n-1;
    	
    	while(start<=end && k>=0) {
    		
    		int t1 = A[start]*A[start];
    		int t2 = A[end]*A[end];
    		
    		if(t1>=t2) {
    			sorted[k] = t1;
    			start++;
    		}
    		else {
    			sorted[k] = t2;
    			end--;
    		}
    		k--;
    	}
    	
    	return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of array.
        int length = sc.nextInt();

        int[] arr = new int[length];

        // Input for elements of array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = sortedSquares(arr);
        display(result);

    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}
