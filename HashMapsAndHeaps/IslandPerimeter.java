package HashMapsAndHeaps;

/*
1. You will be given a matrix, 2d Array and number of its columns and rows.
2. Matrix represents a grid, where 1 is land and 0 is water. 
3. Each tile/element has 1 as width and height.
4. You need to find perimeter of the island formed by land.

Sample Input
4 3
1 0 0 
1 1 1 
0 1 0 
0 1 0
Sample Output
14
*/


import java.util.*;
public class IslandPerimeter
{
	public static int islandPerimeter(int[][] grid) {
		
		int perimeter = 0;
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(grid[i][j]==1)
				{
					perimeter += 4;
					if(i>0 && grid[i-1][j]==1)
					{
						perimeter -= 2;
					}
					if(j>0 && grid[i][j-1]==1)
					{
						perimeter -= 2;
					}
				}
			}
		}
		
		return perimeter;
    }
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int row=scn.nextInt();
        int col=scn.nextInt();
        int[][] grid= new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=scn.nextInt();
            }
        }
        System.out.print(islandPerimeter(grid));
    }
}