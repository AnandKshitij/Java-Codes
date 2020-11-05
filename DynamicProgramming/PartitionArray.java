package DynamicProgramming;

/*
1. You will be given an Array
2. You need to partition it in a way, such that the absolute difference between sum of the 
elements of two subsets is minimum
*/

import java.util.*;

public class PartitionArray {
	
	public static void disp(boolean[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int findMinSumPartition(int arr[], int n) {
	 	int totalSum = 0;
	 	for(int i=0; i<n; i++) {
	 		totalSum += arr[i];
	 	}
	 	
	 	int target = totalSum/2;
	 	
	 	int diff = 0;
	 	
	 	if(totalSum%2!=0) {
	 		diff += 1;
	 	}
	 	
	 	boolean dp[][] = new boolean [arr.length+1][target+1];
	 	
	 	for(int i=0; i<arr.length+1; i++) {
	 		dp[i][0] = true;
	 	}
	 	
	 	int lastTrueCol = 0;
	 	
	 	for(int i=1; i<arr.length+1; i++) {
	 		for(int j=1; j<target+1; j++) {
	 			boolean temp = false;
	 			int val = arr[i-1];
	 			int checkRow = i-1;
	 			int checkCol = j-val;
	 			
	 			temp = dp[checkRow][j];
	 			if(checkCol>=0) {
	 				temp = temp || dp[checkRow][checkCol];
	 			}
	 			dp[i][j] = temp;
	 			
	 			if(temp && lastTrueCol<j) {
	 				lastTrueCol = j;
	 			}
	 		}
	 	}
	 	
	 	diff += (target-lastTrueCol)*2;
	 	return diff;
	}
	
	public static void main(String[] args) {
 	 	 Scanner scn = new Scanner(System.in);
 	 	 	 int n = scn.nextInt();
 	 	 	 int a[] = new int[n];
 	 	 	 for (int i = 0; i < n; i++)
 	 	 	 	 a[i] = scn.nextInt();
 	 	 	 System.out.println(findMinSumPartition(a, n));
 	 	 	 scn.close();
 	 }
}
