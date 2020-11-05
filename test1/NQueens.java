package test1;

import java.util.*;

public class NQueens {

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
		nQueen(new boolean[n][n], 0, "");
	}
	
	public static boolean isSafe(int Queens[],int currRow,int currCol)
	{
		for(int i=0 ; i<Queens.length && Queens[i]!=-1 ; i++)
		{
			int row = i;
			int col = Queens[i];
			
			if(currCol==col)
			{
				return false;
			}
			
			if(row+col==currRow+currCol)
			{
				return false;
			}
			
			if(row-col==currRow-currCol)
			{
				return false;
			}
		}
		
		return true;
	}
	public static void nQueenHelper(int Queens[] , int currRow)
	{
		if(currRow==Queens.length)
		{
			for(int i=0 ; i<Queens.length ; i++)
			{
				System.out.print("["+i+"-"+Queens[i]+"]");
			}
			System.out.println();
			return ;
		}
		for(int currCol=0 ; currCol<Queens.length ; currCol++)
		{
			boolean check = isSafe(Queens,currRow,currCol);
			if(check)
			{
				Queens[currRow] = currCol;
				nQueenHelper(Queens,currRow+1);
				Queens[currRow] = -1;
			}
		}
	}

	public static void nQueen(boolean[][] board, int currRow, String ans) {
		
		int Queens[] = new int [board.length];
		for(int i=0 ; i<board.length ; i++)
		{
			Queens[i] = -1;
		}
		nQueenHelper(Queens,currRow);
    }

		
	
}