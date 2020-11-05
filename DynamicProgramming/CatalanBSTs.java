package DynamicProgramming;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

import java.util.*;

public class CatalanBSTs {

	public static int numTrees(int n) {
        if(n==0 || n==1) {
        	return 1;
        }
        
        int dp[] = new int [n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<n+1; i++) {
        	int start = 0;
        	int end = i-1;
        	
        	int sum = 0;
        	
        	while(start<i) {
        		sum += dp[start]*dp[end];
        		start++;
        		end--;
        	}
        	
        	dp[i] = sum;
        }
        
        return dp[n];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(numTrees(n));
		s.close();
	}
}
