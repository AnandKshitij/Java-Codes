package Stacks;

/*
1. We are given an array asteroids of integers representing asteroids in a row.
2. For each asteroid, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). 
3. Each asteroid moves at the same speed.
4. Find out the state of the asteroids after all collisions. If two asteroids meet, 
the smaller one will explode. If both are the same size, both will explode. Two asteroids 
moving in the same direction will never meet.
 */


import java.util.*;
import java.io.*;
public class AsteroidsCollision
{
	  public static int[] asteroidCollision(int[] asteroids) 
	  {
		  Stack<Integer> S = new Stack<Integer>();
		  int size = 0;
		  
		  for(int i=0 ; i<asteroids.length ; i++)
		  {
			  int val = asteroids[i];
			  
			  if(val>=0)
			  {
				  S.push(val);
				  size++;
				  continue;
			  }
			  
			  if(val<0)
			  {
				  if(S.empty())
				  {
					  S.push(val);
					  size++;
					  continue;
				  }
				  if(S.peek()<0)
				  {
					  S.push(val);
					  size++;
					  continue;
				  }
				  
				  boolean enter = true;
				  while(!S.empty() && S.peek()>0)
				  {
					  if(S.peek()<-1*val)
					  {
						  S.pop();
						  size--;
					  }
					  else
					  {
						  enter = false;
						  break;
					  }
				  }
				  
				  if(enter)
				  {
					  S.push(val);
					  size++;
				  }
			  }
		  }
		  int result[] = new int [size];
		  
		  int index = size-1;
		  
		  while(!S.empty() && index>=0)
		  {
			  result[index] = S.pop();
			  index--;
		  }
	
		  return result;
		  
		  
	  }
	 
	 public static void main(String[] args) 
	 {
	     Scanner sc=new Scanner(System.in);
	     int n=sc.nextInt();
	     int ast[]=new int[n];
	     for(int i=0;i<n;i++)ast[i]=sc.nextInt();
	     int res[]=asteroidCollision(ast);
	     for(int v:res)
	     {
	     	 System.out.println(v);
	     }
	 }

}