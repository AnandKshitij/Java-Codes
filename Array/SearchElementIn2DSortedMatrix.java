package Array;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
*/

import java.util.*;

public class SearchElementIn2DSortedMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        
        if(rows==0){
            return false;
        }
        
        int cols = matrix[0].length;
        
        if(cols==0){
            return false;
        }
        
        int elements = rows*cols;
        
        int start = 0;
        int end = elements-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            int midRow = mid/cols; 
            int midCol = mid%cols;
            
            if(matrix[midRow][midCol] == target){
                return true;
            }
            else if(target<matrix[midRow][midCol]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		int input[][] = new int [n][m];
		
		for (int i = 0; i <n; i++) {
			for(int j=0; j<m; j++) {
				input[i][j] = s.nextInt();
			}
		}
		
		int target = s.nextInt();
		
		System.out.println(searchMatrix(input,target));
	}

}
