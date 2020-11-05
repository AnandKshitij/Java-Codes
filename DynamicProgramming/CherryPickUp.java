package DynamicProgramming;

/*
In a N x N grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.

Your task is to collect maximum number of cherries possible by following the rules below:

Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path 
cells (cells with value 0 or 1); After reaching (N-1, N-1), returning to (0, 0) by moving left or 
up through valid path cells; When passing through a path cell containing a cherry, you pick it up 
and the cell becomes an empty cell (0); If there is no valid path between (0, 0) and (N-1, N-1), 
then no cherries can be collected.

Example 1:

Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
Explanation: 
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
*/

import java.util.*;

public class CherryPickUp {
	
	static int ret = -100000;
	static HashMap<String,Integer> H = new HashMap<>();
	
	public static int helperCherry(int grid[][], int row1, int col1, int row2, int col2) {
		
		int n = grid.length;
		
		if(row1>=n || row2>=n || col1>=n || col2>=n) {
			return ret;
		}
		
		String temp = row1 + "/" + row2 + "/" + col1;
		
		if(H.containsKey(temp)) {
			return H.get(temp);
		}
		
		
		if(grid[row1][col1]==-1 || grid[row2][col2]==-1) {
			String str = row1 + "/" + row2 + "/" + col1;
			H.put(str,ret);
			return ret;
		}
		
		if(row1==n-1 && col1==n-1) {
			if(grid[row1][col1]==1) {
				String str = row1 + "/" + row2 + "/" + col1;
				H.put(str,1);
				return 1;
			}
			else if(grid[row1][col1]==0) {
				String str = row1 + "/" + row2 + "/" + col1;
				H.put(str,0);
				return 0;
			}
			else {
				String str = row1 + "/" + row2 + "/" + col1;
				H.put(str,ret);
				return ret;
			}
		}
		
		int smallAns1 = helperCherry(grid,row1+1,col1,row2+1,col2);
		if(row1==row2) {
			smallAns1 += grid[row1][col1];
		}
		else {
			smallAns1 += grid[row1][col1]+grid[row2][col2];
		}
		
		int smallAns2 = helperCherry(grid,row1+1,col1,row2,col2+1);
		if(row1==row2) {
			smallAns2 += grid[row1][col1];
		}
		else {
			smallAns2 += grid[row1][col1]+grid[row2][col2];
		}
		
		int smallAns3 = helperCherry(grid,row1,col1+1,row2+1,col2);
		if(row1==row2) {
			smallAns3 += grid[row1][col1];
		}
		else {
			smallAns3 += grid[row1][col1]+grid[row2][col2];
		}
		
		int smallAns4 = helperCherry(grid,row1,col1+1,row2,col2+1);
		if(row1==row2) {
			smallAns4 += grid[row1][col1];
		}
		else {
			smallAns4 += grid[row1][col1]+grid[row2][col2];
		}
		
		int ans =  Math.max(smallAns1,Math.max(smallAns2,Math.max(smallAns3,smallAns4)));
		String str = row1 + "/" + row2 + "/" + col1;
		H.put(str,ans);
		return ans;
	}
	
	public static int cherryPickup(int[][] grid) {
		int n = grid.length;
		
		if(grid[0][0]==-1 || grid[n-1][n-1]==-1) {
			return 0;
		}
		
		int ans = helperCherry(grid,0,0,0,0);
		if(ans<0) {
			return 0;
		}
		return ans;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		
		System.out.println(cherryPickup(input));
		s.close();
	}	
}
