package DynamicProgramming;

/*
1. You will be given a convex polygon of N sides, in form of an array where each a[i] represents 
vertices labells
2. You need to form triangles from given vertices (triangulation), and return minimum score 
triangulation
3. Value of a triangle is product of all its vertices sum of all the triangles in a 
triangulation form its score
4. Return the smallest possible total score that can be achieved with some triangulation of 
the polygon. 
*/

import java.util.*;

public class MinScoreTriangulationOfPolygon {
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int minScoreTriangulation(int[] vertices) {
		
		int n = vertices.length;
		
		if(n<3) {
			return 0;
		}
		
		int dp[][] = new int [n][n];
		
		for(int i=2; i<n; i++) {
			int col = i;
			int row = 0;
			
			while(row<n && col<n) {
				int start = row;
				int end = col;
				int currCol = start+1;
				int currRow = start+1;
				
				int min = Integer.MAX_VALUE;
				
				while(currCol<col) {
					int val1 = vertices[start]*vertices[end]*vertices[currCol];
					int val2 = dp[row][currCol];
					int val3 = dp[currRow][col];
					int val = val1 + val2 + val3;
					min = Math.min(min,val);
					currCol++;
					currRow++;
				}
				
				dp[row][col] = min;
				row++;
				col++;
			}
		}
		
		disp(dp);
		return dp[0][n-1];
	}
	public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i]=scn.nextInt();
        }
	 	 System.out.println(minScoreTriangulation(a));
	 	 scn.close();
	 }
}
