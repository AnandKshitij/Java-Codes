package Array;

/*
1. A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
2. Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Sample Input
3 4
1 2 3 4 
5 1 2 3 
9 5 1 2

Sample Output
true
 */


import java.util.*;

public class ToeplitzMatrix {
	
	public static boolean helperCheck(int[][] matrix, int startRow, int startCol) {
		
		if(startRow>=matrix.length-1 || startCol>=matrix[0].length-1) {
			return true;
		}
		
		for(int j=startCol; j<matrix[0].length; j++) {
			int i = startRow;
			
			if(i+1<matrix.length && j+1<matrix[0].length && matrix[i][j]!=matrix[i+1][j+1]) {
				return false;
			}
		}
		
		for(int i=startRow; i<matrix.length; i++) {
			int j = startCol;
			
			if(i+1<matrix.length && j+1<matrix[0].length && matrix[i][j]!=matrix[i+1][j+1]) {
				return false;
			}
		}
		
		boolean temp1 = helperCheck(matrix,startRow+1,startCol+1);
		
		return temp1;
	}

    public static boolean isToeplitzMatrix(int[][] matrix) {
    	
    	return helperCheck(matrix,0,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(isToeplitzMatrix(arr));
    }
}