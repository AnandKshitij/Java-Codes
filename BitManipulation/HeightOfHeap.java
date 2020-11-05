package BitManipulation;

/*
1. You will be given a binary heap of size N.
2. You need to find height of the heap.
4. Return this size
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main()
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class HeightOfHeap
{
	//this is to get the ceil value of log base 2
	public static int getCeilLog(int n)
	{
		 int x=0;
		 while((1<<x)<n)
		 {
			 x++;
		 }
		 return x;
	}
	 
	 //this is to get the float value of log base 32
	public static int getFloatValue(int n)
	{
		 int x=0;
		 while((1<<x)<=n)
		 {
			 x++;
		 }
		 return (x-1);
	}
	
	private static int solve(int N) 
	{
		 int height = getCeilLog(N+1)-1;
		 return height;
	}
	 
	public static void main (String[] args) throws IOException
	{
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	 int n = Integer.parseInt(br.readLine());
	 	 String[] s = br.readLine().split(" ");
	 	 int x=solve(n);
	 	 System.out.println(x);
	}
	
}