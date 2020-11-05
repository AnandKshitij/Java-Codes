package DynamicProgramming;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get 
the maximum total value in the knapsack. 
Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and 
weights associated with N items respectively.
Also given an integer W which represents knapsack capacity, find out the maximum value subset 
of val[] such that sum of the weights of this 
subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or 
don’t pick it (0-1 property).

Input:
2
3
4
1 2 3
4 5 1
2
3
1 2 3
4 5 6
Output:
3
1
*/

import java.util.*;

public class KnapsackProblem {
	
	static class Node{
		int row;
		int col;
		String path;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
			this.path = "";
		}
	}
	
	public static int knapsack(int W, int val[], int weights[]) {
		
		int dp[][] = new int [weights.length+1][W+1];
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				//weight not included
				int ans1 = dp[i-1][j];
				int ans2 = Integer.MIN_VALUE;
				
				if(j-weights[i-1]>=0) {
					ans2 = dp[i-1][j-weights[i-1]];
				}
				
				ans2 += val[i-1];
				
				dp[i][j] = Math.max(ans1,ans2);
			}
		}
		
		System.out.println("Paths by BFS are : ");
		printKnapsackBFS(dp,val,weights);
		System.out.println("Paths by DFS are : ");
		printKnapsackDFS(dp,val,weights,dp.length-1,dp[0].length-1,"");
		
		return dp[dp.length-1][dp[0].length-1];
		
	}
	
	public static void printKnapsackDFS(int dp[][], int val[], int weights[],
										int row, int col, String path) {
		if(row==0 || col==0) {
			System.out.println(path);
			return ;
		}
		
		int val1 = Integer.MIN_VALUE;
		if(row-1>=0) {
			val1 = dp[row-1][col];
		}
		
		int val2 = Integer.MIN_VALUE;
		if(col-weights[row-1]>=0 && row-1>=0) {
			val2 = val[row-1] + dp[row-1][col-weights[row-1]];
		}
		
		if(val2>val1) {
			printKnapsackDFS(dp,val,weights,row-1,col-weights[row-1],path + " " + val[row-1]);
		}
		else if(val1>val2) {
			printKnapsackDFS(dp,val,weights,row-1,col,path);
		}
		else {
			printKnapsackDFS(dp,val,weights,row-1,col-weights[row-1],path + " " + val[row-1]);
			printKnapsackDFS(dp,val,weights,row-1,col,path);
		}
		
	}
	
	

	public static void printKnapsackBFS(int dp[][], int val[], int weights[]) {
		
		Node first = new Node(dp.length-1,dp[0].length-1);
		
		Queue<Node> Q = new LinkedList<>();
		Q.add(first);
		
		while(!Q.isEmpty()) {
			
			Node temp = Q.remove();
			
			if(temp.row==0 || temp.col==0) {
				System.out.println(temp.path);
				continue;
			}
			
			else {
				int val1 = Integer.MIN_VALUE;
				if(temp.row-1>=0)
				val1 = dp[temp.row-1][temp.col];
				
				int val2 = Integer.MIN_VALUE;
				
				int checkCol = temp.col-weights[temp.row-1];
				if(checkCol>=0) {
					val2 = dp[temp.row-1][checkCol];
					val2 += val[temp.row-1];
				}
				
				if(val2>val1) {
					Node temp1 = new Node(temp.row-1,temp.col-weights[temp.row-1]);
					temp1.path = temp.path + " " + val[temp.row-1];
					Q.add(temp1);
				}
				else if(val1>val2) {
					Node temp2 = new Node(temp.row-1,temp.col);
					temp2.path = temp.path;
					Q.add(temp2);
				}
				else {
					
					Node temp1 = new Node(temp.row-1,temp.col-weights[temp.row-1]);
					temp1.path = temp.path + " " + val[temp.row-1];
					Q.add(temp1);
					
					Node temp2 = new Node(temp.row-1,temp.col);
					temp2.path = temp.path;
					Q.add(temp2);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int k=0; k<T; k++) {
			int n = s.nextInt();
			int W = s.nextInt();
			int val[] = new int [n];
			
			for(int i=0; i<n; i++) {
				val[i] = s.nextInt();
			}
			
			int weights[] = new int [n];
			
			for(int i=0; i<n; i++) {
				weights[i] = s.nextInt();
			}
			
			System.out.println("Answer is " + knapsack(W,val,weights));
		}
	}

}
