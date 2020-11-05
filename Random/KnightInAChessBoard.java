package Random;

/*
1. Given a square chessboard of N x N size, the position of Knight and position of a target is given. 
2. You need to find out minimum steps a Knight will take to reach the target position.
3. Return the answer.
 */

/*
In this problem we have to find the minimum no. of steps required by the knight to move from source
to destination

So this is a graph problem we have to move from source to destination

Whenever we have to calculate the minimum no. of steps to move from one node to another we use 
breadth first search

This is because in breadth first search first all the nodes at distance 1 from the source node are visited.
Then all the nodes at distance 2 are visited and so on.

 So the nodes are visited in increasing order of distance. So the shortest distance is encountered first.
 And we return from there.
 
 Breadth first traversal is done with the help of a queue.
 
 We enter the source node in the queue.
 
 Then we remove nodes one by one, perform our operations on them and then add their children.
 
 We also have to maintain which nodes have been visited by us.
 
 There are two ways of maintaining the visited array.
 
 1st way is to mark the element as visited while inserting it into the queue
 
  2nd way is to mark the element as visited while removing it from the queue. This method
  is more efficient. But the 1st method is required for some specific questions like detecting the 
  cycle in a graph,etc.
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class PairBoard
{
	int row;
	int col;
	int level;
	
	public PairBoard()
	{
		this.level = 0;
	}
}

public class KnightInAChessBoard {
	
	public static int minSteps(PairBoard src, PairBoard dest, int chessboard[][])
	{
		Queue<PairBoard> Q = new LinkedList<>();
		
		Q.add(src);
		
		chessboard[src.row][src.col] = 1;
		
		while(!Q.isEmpty())
		{
			PairBoard curr = Q.remove();
			int currRow = curr.row;
			int currCol = curr.col;
			
			if(currRow==dest.row && currCol==dest.col)
			{
				return curr.level;
			}
			
			if(isSafe(chessboard,currRow-1,currCol+2))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow-1;
				newNode.col = currCol+2;
				newNode.level = curr.level+1;
				
				chessboard[currRow-1][currCol+2] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow-2,currCol+1))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow-2;
				newNode.col = currCol+1;
				newNode.level = curr.level+1;
				chessboard[currRow-2][currCol+1] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow-1,currCol-2))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow-1;
				newNode.col = currCol-2;
				newNode.level = curr.level+1;
				chessboard[currRow-1][currCol-2] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow-2,currCol-1))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow-2;
				newNode.col = currCol-1;
				newNode.level = curr.level+1;
				chessboard[currRow-2][currCol-1] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow+1,currCol+2))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow+1;
				newNode.col = currCol+2;
				newNode.level = curr.level+1;
				chessboard[currRow+1][currCol+2] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow+2,currCol+1))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow+2;
				newNode.col = currCol+1;
				newNode.level = curr.level+1;
				chessboard[currRow+2][currCol+1] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow+1,currCol-2))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow+1;
				newNode.col = currCol-2;
				newNode.level = curr.level+1;
				chessboard[currRow+1][currCol-2] = 1;
				Q.add(newNode);
			}
			
			if(isSafe(chessboard,currRow+2,currCol-1))
			{
				PairBoard newNode = new PairBoard();
				newNode.row = currRow+2;
				newNode.col = currCol-1;
				newNode.level = curr.level+1;
				chessboard[currRow+2][currCol-1] = 1;
				Q.add(newNode);
			}
			
			
		}
		
		//shows that value was not found
		//so knght cannot reach there
		return Integer.MAX_VALUE;
	}
	
	public static boolean isSafe(int chessboard[][], int row, int col)
	{
		if(row<0 || col<0 || row>=chessboard.length || col>=chessboard.length)
		{
			return false;
		}
		if(chessboard[row][col]!=0)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		PairBoard src = new PairBoard();
		
		//user enters the position and we want index
		//so we subtract 1 from the position entered by the user
		src.row = s.nextInt()-1;
		src.col = s.nextInt()-1;
		
		PairBoard dest = new PairBoard();
		dest.row = s.nextInt()-1;
		dest.col = s.nextInt()-1;
		
		int chessBoard[][] = new int [n][n];
		
		int steps = minSteps(src, dest, chessBoard);
		System.out.println(steps);
	}

}
