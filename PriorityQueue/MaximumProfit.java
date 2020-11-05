package PriorityQueue;

/*
Suppose PepCoding will start its IPO soon. In order to sell a good price of its shares to Venture Capital, 
PepCoding would like to work on some projects to increase its capital before the IPO. Since it has limited 
resources, it can only finish at most k distinct projects before the IPO. Help PepCoding design the best way 
to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is 
needed to start the corresponding project. Initially, you have W capital. When you finish a project, you
 will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, 
and output your final maximized capital.

Input Format
 k: number of projects you can take
w: starting capital
n: number of projects
profits of all projects
capital requirement of all projects 

Input is handled for you.
output Format
 Your Maximized Capital
 
6
100
4
Profits - 40	60		50		70		50		300
Capital - 80	150		90		200		250		350

We will first make an array which is sorted in increasing order of capital

Profits - 40	50		60		70		50		300
Capital - 80	90		150		200		250		350

Now all the elements which have capital requirement less than or equal to our present capital
will be added in the priority queue

The priority queue will give us the element with the maximum profit

After completing task we decrement K 

And add new elements in the priority queue whose elements have less or equal capital to 
present capital

 */

import java.util.*; 

class Pair
{
	int profit;
	int capital;
}
public class MaximumProfit {
	
	static class CapitalComparator implements Comparator<Pair>
	{
		public int compare(Pair P1, Pair P2)
		{
			//to sort in ascending order
			return P1.capital-P2.capital;
		}
	}
	
	static class ProfitComparator implements Comparator<Pair>
	{
		public int compare(Pair P1, Pair P2)
		{
			return P2.profit-P1.profit;
		}
	}
	public static int getProfit(int profit[] , int capital[] , int k, int startCapital)
	{
		Pair arr[] = new Pair[profit.length];
		
		for(int i=0 ; i<arr.length ; i++)
		{
			Pair P = new Pair();
			P.profit = profit[i];
			P.capital = capital[i];
			arr[i] = P;
		}
		
		Arrays.sort(arr, new CapitalComparator());
		PriorityQueue<Pair> P = new PriorityQueue<>(new ProfitComparator());
		
		int i=0 ; 
		for(; i<arr.length ; i++)
		{
			int temp = arr[i].capital;
			if(temp>startCapital)
			{
				break ; 
			}
			P.add(arr[i]);
		}
		while(k>0)
		{
			Pair temp = P.remove();
			startCapital += temp.profit;
			k--;
			
			while(i<arr.length)
			{
				int val = arr[i].capital;
				if(val>startCapital)
				{
					break ; 
				}
				P.add(arr[i]);
				i++;
			}
		}
		
		return startCapital;
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int k = s.nextInt();
		int w = s.nextInt();
		int n = s.nextInt();
		
		int profit[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			profit[i] = s.nextInt();
		}
		
		int capital[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			capital[i] = s.nextInt();
		}
		
		int maxProfit = getProfit(profit,capital,k,w);
		
		System.out.println(maxProfit);
		
	}
}
