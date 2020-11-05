package Array;

/*
1. You will be given a grid as 2d array
2. You need to return count of all 3x3 magic squares present in the given grid

Sample Input
4 4
7 8 1 6
2 3 5 7
3 4 9 2
1 6 4 5
Sample Output
1
*/

import java.util.*;

public class MagicSquares {
	
      public static boolean isMagicSquare(int grid[][], int row, int col){
    	  
    	  if(row<1 || col<1 || row>=grid.length-1 || col>=grid[0].length-1) {
    		  return false;
    	  }
    	  
    	  int startRow = row-1;
    	  int startCol = col-1;
    	  
    	  int rowSum = 0;
    	  boolean check = false;
    	  for (int i=startRow; i<startRow+3; i++) {
    		  int sum = 0;
    		  for(int j=startCol; j<startCol+3; j++) {
    			  sum = sum + grid[i][j];
    		  }
    		  if(!check) {
    			  rowSum = sum;
    			  check = true;
    		  }
    		  else {
    			  if(rowSum!=sum) {
    				  return false;
    			  }
    		  }
			
    	  }
    	  
    	  for (int j=startCol; j<startCol+3; j++) {
    		  int sum = 0;
    		  for(int i=startRow; i<startRow+3; i++) {
    			  sum = sum + grid[i][j];
    		  }
    		  if(rowSum!=sum) {
    				return false;
    		  }
			
    	  }
    	  
    	  int s = 0;
    	  for(int i=0; i<3; i++) {
    		  
    		  s += grid[startRow+i][startCol+i];
    	  }
    	  
    	  if(s!=rowSum) {
    		  return false;
    	  }
    	  
    	  int t=0;
    	  
    	  for(int i=startRow+2,j=startCol; i>=startRow&&j<startCol+3; i--,j++) {
    		  t += grid[i][j];
    	  }
    	  
    	  if(t!=rowSum) {
    		  return false;
    	  }
    	  
    	  return true;
    	  
      }
	
	  public static int numMagicSquaresInside(int[][] grid) {
	  	  
		  int count = 0;
		  
		  for(int i=0; i<grid.length-1; i++) {
			  for(int j=0; j<grid[0].length-1; j++) {
				  
				  if(i+1<grid.length && j+1<grid[0].length && grid[i+1][j+1] == 5) {
					  if(isMagicSquare(grid,i+1,j+1)) {
						  count++;
					  }
				  }
			  }
		  }
		  
		  return count;
		  
		  
	  }
	  public static void main(String[] args) {
	  	  Scanner scn = new Scanner(System.in);
	  	  int r = scn.nextInt();
	  	  int c = scn.nextInt();
	  	  int[][] Input = new int[r][c];
	  	  for (int i = 0; i < r; i++) {
	  	  	  for (int j = 0; j < c; j++) {
	  	  	  	  Input[i][j] = scn.nextInt();
	  	  	  }
	  	  }
	  	  System.out.print(numMagicSquaresInside(Input));
	  }
}