package Array;

/*
1. You are given an array A containing N positive integers.
2. A[i] represents the value of the i-th sight seeing spot, and two sight seeing spots i and j have distance j - i between them.
3. You have to find the maximum score of a pair of sight seeing spots.
4. The score of a pair (i < j) of sight seeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sight seeing spots, 
minus the distance between them.

5. For example,
Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
*/


import java.util.*;

public class BestPair {

    public static int maxScoreSightseeingPair(int[] A) {

        if(A.length<2) {
    		return 0;
    	}
        
        int pos = 1;
        int max = A[0]-1;
        
        int maxScore = Integer.MIN_VALUE;
        
        while(pos<A.length) {
        	
        	int val = A[pos];
        	int score = val+max;
        	
        	if(score>maxScore) {
        		maxScore = score;
        	}
        	
        	max = Integer.max(max,val)-1;
        	pos++;
        }
        
        return  maxScore;
    	
    	
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxScoreSightseeingPair(arr));

    }
    
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}