package test1;
import java.util.*;

public class NoOfWays {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int row=sc.nextInt(), 
			col=sc.nextInt();
		
		int[][] matrix=new int[row][col];
		
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				matrix[i][j]=sc.nextInt();
		
		System.out.println(countWays(matrix));
	}
	
	public static int HelperWays(int[][] matrix, boolean[][] visited, int row, int col)
	{
		visited[row][col] = true;
		
		if(matrix[row][col]==0)
		{
			return 0;
		}
		if(row==matrix.length-1 && col==matrix[0].length-1)
		{
			visited[row][col] = false;
			return 1;
		}
		
		int smallAns1 = 0;
		if(row+1<matrix.length && matrix[row+1][col]==1 && !visited[row+1][col])
		{
			smallAns1 = HelperWays(matrix,visited,row+1,col);
		}
		
		int smallAns2 = 0;
		if(row-1>=0 && matrix[row-1][col]==1 && !visited[row-1][col])
		{
			smallAns2 = HelperWays(matrix,visited,row-1,col);
		}
		
		int smallAns3 = 0;
		if(col+1<matrix[0].length && matrix[row][col+1]==1 && !visited[row][col+1])
		{
			smallAns3 = HelperWays(matrix,visited,row,col+1);
		}
		
		int smallAns4 = 0;
		if(col-1>=0 && matrix[row][col-1]==1 && !visited[row][col-1])
		{
			smallAns4 = HelperWays(matrix,visited,row,col-1);
		}
		
		visited[row][col] = false;
		
		int Ans = smallAns1 + smallAns2 + smallAns3 + smallAns4;
		return Ans;
	}

	public static int countWays(int[][] matrix){
		int i=0,j=0;
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		int result = HelperWays(matrix,visited,i,j);
		return result;
	}
}