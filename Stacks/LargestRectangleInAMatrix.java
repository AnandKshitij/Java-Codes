package Stacks;

/*
You are given a matrix of '0' and '1'
You have to return the area of the largest rectangle formed by '1's in the mat
 */


/*
Sample Input
4 5
1 0 1 0 0 
1 0 1 1 1 
1 1 1 1 1 
1 0 0 1 0
Sample Output
6

First we will make the height array for the given array
If we have 0 then height will be 0
If we have 1 then height will be height of above element+1

1		0		1		0		0
1+1 	0 		1+1 	0+1 	0+1
2+1		0+1		2+1		1+1		1+1
3+1		0		0		2+1		0

Now we will send each row one by one to find the maximum histogram area 
And from this we will calculate the maximum rectangle area for entire matrix
 */
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInAMatrix {
 
	
	public static int maxHistogramArea(int A[])
	{
		Stack<Integer> S = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0 ; i<A.length ; i++)
		{
			if(S.empty())
			{
				S.push(i);
				continue;
			}
			
			while(!S.empty() && A[S.peek()]>A[i])
			{
				int rightIndex = i;
				int height = A[S.pop()];
				int leftIndex = -1;
				if(!S.empty())
				{
					leftIndex = S.peek();
				}
				int width = rightIndex-leftIndex-1;
				int Area = height*width;
				if(Area>maxArea)
				{
					maxArea = Area;
				}
			}
			
			S.push(i);
		}
		
		int rightIndex = A.length;
		
		while(!S.empty())
		{
			int height = A[S.pop()];
			int leftIndex = -1;
			if(!S.empty())
			{
				leftIndex = S.peek();
			}
			int width = rightIndex-leftIndex-1;
			int Area = height*width;
			if(Area>maxArea)
			{
				maxArea = Area;
			}
		}
		
		return maxArea;
	}
	
	public static int maxrect(int arr[][])
	{
		
		int height[][] = new int [arr.length][arr[0].length];
		height[0] = arr[0];
		
		for(int i=1 ; i<arr.length ; i++)
		{
			for(int j=0 ; j<arr[i].length ; j++)
			{
				if(arr[i][j]==0)
				{
					height[i][j] = 0;
				}
				else
				{
					height[i][j] = height[i-1][j]+1;
				}
			}
		}
		
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0 ; i<height.length ; i++)
		{
			int Area = maxHistogramArea(height[i]);
			if(Area>maxArea)
			{
				maxArea = Area;
			}
		}
		
		return maxArea;
	}
	
	 //Dont make changes
	 public static void main(String[] args) {
	 	 Scanner sc=new Scanner(System.in);	 
	 	 int row=sc.nextInt();
	 	 int col=sc.nextInt();
	 	 int[][] A=new int[row][col];
	 	 for(int i=0;i<row;i++)
	 	 	 for(int j=0;j<col;j++)
	 	 	 	 A[i][j]=sc.nextInt();
          System.out.println(maxrect(A));
    
	 }

}