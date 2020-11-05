package Stacks;

import java.util.*;

/*

1. Implement the functions of class StockSpanner.
2. next() collects daily price quotes for the stock, and returns the span of that stock's price 
for the current day.
3. The span of the stock's price today is defined as the maximum number of consecutive days 
(starting from today and going backwards) for which the price of the stock was less than or 
equal to today's price.

 */
class Pair1
{
	int index;
	int val;
}


public class StockSpanProblem{
	
	static class StockSpanner 
	{
		Stack<Pair1> S;
		int index;
		
		public StockSpanner() 
		{
			index = 0;
			S = new Stack<>();
		}

		public int next(int price) 
		{
			int result = 0;
			Pair1 P = new Pair1();
			P.val = price;
			P.index = index;
			
			if(S.empty())
			{
				result = index+1;
				S.push(P);
				index++;
			}
			else
			{
				while(!S.empty() && S.peek().val<price)
				{
					S.pop();
				}
				
				if(S.empty())
				{
					result = index+1;
					S.push(P);
					index++;
				}
				else
				{
					int leftIndex = S.peek().index;
					result = index-leftIndex;
					S.push(P);
					index++;
				}
				
			}
			
			return result;
		}

	}

	 public static void main(String[] args)
	 {
	 	 StockSpanner ss=new StockSpanner();
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 for(int i=0;i<n;i++)
	 	 {
	 	 	 System.out.println(ss.next(sc.nextInt()));
	 	 }
	 }
}