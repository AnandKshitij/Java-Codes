package DynamicProgramming;

/*
Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to 
multiply these matrices i.e. determine where to place parentheses to minimise the number of 
multiplications. You will be given an array p[] of size n + 1. Dimension of matrix Ai is 
p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.

Input Format :
Line 1 : Integer n i.e. number of matrices
Line 2 : n + 1 integers i.e. elements of array p[] 
*/

import java.util.*;

public class MatrixChainMultiplication {
	
	static class Pair{
		int row;
		int col;
	}
	
	public static void disp(int[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int mcm(int[] p){
		
		Pair[] arr = new Pair[p.length-1];
		
		for(int i=0; i<p.length-1; i++) {
			Pair P = new Pair();
			P.row = p[i];
			P.col = p[i+1];
			arr[i] = P;
		}
		
		int n = arr.length;
		
		int dp[][] = new int [n][n];
		
		for(int j=1,i=0; j<n && i<n; j++,i++) {
			dp[i][j] = arr[i].row*arr[i].col*arr[j].col;
		}
		
		for(int i=2; i<n; i++) {
			int row = 0;
			int col = i;
			
			while(row<n && col<n) {
				int startCol = col-i;
				int startRow = row+1;
				

				int min = Integer.MAX_VALUE;
				
				while(startCol<col) {
					
					int factor1 = dp[row][startCol];
					int factor2 = dp[startRow][col];
					
					int f1 = arr[row].row;
					int f2 = arr[startCol].col;
					int f3 = arr[col].col;
					int factor3 = f1*f2*f3;
					
					int temp = factor1+factor2+factor3;
					
					min = Math.min(min,(temp));
					
					startCol++;
					startRow++;
				}
				
				dp[row][col] = min;
				
				row++;
				col++;
			}
		}
		System.out.println();
		disp(dp);
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n+1];
		
		for(int i=0; i<n+1; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(mcm(arr));
		s.close();
	}

}
