package Array;

/*
1. You are given a number N.
2. Assume you have an array of length N initialised with all 0's.
3. You are also given K update operations.
4. Each operation contain 3 numbers: startIndex, endIndex and inc and updates each element of the subarray arr[startIndex, endIndex]
(both inclusive) with inc.
5. You have to find the resultant array when all K operations are executed.

Sample Input
5
3
1 3 2
2 4 3
0 2 -2
Sample Output
-2 0 3 5 3

*/


import java.util.*;

public class RangeAddition {
	
    public static int[] getModifiedArray(int length, int[][] updates) {
        
    	int arr [] = new int [length];
    	
    	for(int i=0; i<updates.length; i++) {
    		int start = updates[i][0];
    		int end = updates[i][1];
    		int inc = updates[i][2];
    		
    		arr[start] += inc;
    		
    		if(end+1<arr.length) {
    			arr[end+1] -= inc;
    		}
    	}
    	
    	int prefixSum[] = new int [length];
    	
    	int sum = 0;
    	
    	for(int i=0; i<length; i++) {
    		sum += arr[i];
    		prefixSum[i] = sum;
    	}
    	
    	return prefixSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int length = sc.nextInt();

        int K = sc.nextInt();

        int[][] updates = new int[K][3];

        for (int i = 0; i < updates.length; i++) {
            for (int j = 0; j < updates[0].length; j++) {
                updates[i][j] = sc.nextInt();
            }
        }

        int[] result = getModifiedArray(length, updates);
        display(result);
    }
    
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}