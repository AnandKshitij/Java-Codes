package Random;

import java.util.Scanner;
import java.util.*;

class Triplet
{
	int row;
	int col;
	int time;
	
	public Triplet(int row, int col, int time)
	{
		this.row  = row;
		this.col = col;
		this.time = time;
	}
}

public class RottenOranges {
	
	public static int findMinTime(int matrix[][])
	{
		Queue<Triplet> rotten = new LinkedList<>();
		
		for(int i=0 ; i<matrix.length ; i++)
		{
			for(int j=0 ; j<matrix[0].length ; j++)
			{
				if(matrix[i][j]==2)
				{
					Triplet rot = new Triplet(i,j,0);
					rotten.add(rot);
				}
			}
		}
		
		
		int time = -1;
		
		while(!rotten.isEmpty())
		{
			Triplet removed = rotten.remove();
			
			int currRow = removed.row;
			int currCol = removed.col;
			int currTime = removed.time;
			
			matrix[currRow][currCol] = 2;
			
			time = currTime;
			
			if(isSafe(currRow+1,currCol,matrix))
			{
				Triplet addToQueue = new Triplet(currRow+1,currCol,currTime+1);
				rotten.add(addToQueue);
			}
			if(isSafe(currRow-1,currCol,matrix))
			{
				Triplet addToQueue = new Triplet(currRow-1,currCol,currTime+1);
				rotten.add(addToQueue);
			}
			if(isSafe(currRow,currCol+1,matrix))
			{
				Triplet addToQueue = new Triplet(currRow,currCol+1,currTime+1);
				rotten.add(addToQueue);
			}
			if(isSafe(currRow,currCol-1,matrix))
			{
				Triplet addToQueue = new Triplet(currRow,currCol-1,currTime+1);
				rotten.add(addToQueue);
			}
			
		}
		
		for(int i=0 ; i<matrix.length ; i++)
		{
			for(int j=0 ; j<matrix[0].length ; j++)
			{
				if(matrix[i][j]==1)
				{
					return -1;
				}
			}
		}
		
		return time;
	}
	
	public static boolean isSafe(int row, int col, int matrix[][])
	{
		if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length)
		{
			return false;
		}
		if(matrix[row][col]==0 || matrix[row][col]==2)
		{
			return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int matrix[][] = new int [n][m];
		for(int i=0 ; i<n ; i++)
		{
			for(int j=0 ; j<m ; j++)
			{
				matrix[i][j] = s.nextInt();
			}
		}
		
		//0 is empty
		//1 is fresh
		//2 is rotten
		int result = findMinTime(matrix);
		System.out.println(result);
	}
}
