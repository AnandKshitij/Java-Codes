package Stacks;

import java.util.*;
import java.util.Scanner;

public class MaxAreaRectangle
{
	public static int maxRectArea(int[] ht) 
	{
        //write your code here
		Stack<Integer> S = new Stack<>();
		
		S.push(0);
		
		int rectArea = Integer.MIN_VALUE;
		
		for(int i=1 ; i<ht.length ; i++)
		{
			int val = ht[i];
			
			while(!S.empty())
			{
				int topIndex = S.peek();
				int topValue = ht[topIndex];
				
				if(topValue>val)
				{
					int rightIndex = i;
					S.pop();
					int leftIndex = -1;
					if(!S.empty())
					{
						leftIndex = S.peek();
					}
					int Area = topValue*(rightIndex-leftIndex-1);
					if(Area>rectArea)
					{
						rectArea = Area;
					}
				}
				else
				{
					break;
				}
			}
			
			S.push(i);
		}
		
		int rightIndex = ht.length;
		while(!S.empty())
		{
			int topIndex = S.peek();
			S.pop();
			int height = ht[topIndex];
			int leftIndex = -1;
			if(!S.empty())
			{
				leftIndex = S.peek();
			}
			int Area = height*(rightIndex-leftIndex-1);
			if(Area>rectArea)
			{
				rectArea = Area;
			}
		}
		
		return rectArea;

	}

    

	public static void main(String[] args) 
	{
	 	 Scanner scn = new Scanner(System.in);
	 	 
	 	 int h=scn.nextInt();
	 	 int height[]=new int[h];
	 	 for(int i=0;i<h;i++){
	 	 	 height[i]=scn.nextInt();
	 	 }
	 	 System.out.println(maxRectArea(height));
	 }
}
