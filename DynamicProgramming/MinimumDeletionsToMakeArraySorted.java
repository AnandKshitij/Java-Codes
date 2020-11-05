package DynamicProgramming;

/*
1. You will be given an Array alongwith its length
2. You need to print count of minimum number of deletions needed to make given array sorted
*/

import java.util.*;

public class MinimumDeletionsToMakeArraySorted {
	
	public static int LIS(int a[]) {
		if(a.length==0 || a.length==1) {
			return a.length;
		}
		
		int dp[] = new int [a.length];
		
		dp[0] = 1;
		
		int ans = 1;
		
		for(int i=1; i<a.length; i++) {
			int max = 0;
			
			for(int j=0; j<i; j++) {
				if(a[j]<a[i]) {
					max = Math.max(dp[j],max);
				}
			}
			
			dp[i] = max+1;
			ans = Math.max(ans,dp[i]);
		}
		return ans;
	}
	
	public static void mindeletions(int[] a, int n)
	{
		int lis = LIS(a);
		System.out.println((n-lis));
	}
	
	public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int a[] = new int[n];
	 	 for(int i = 0; i < n; i++)
	 	 	a[i] = scn.nextInt();
	 	 mindeletions(a, n);
	 }
}
