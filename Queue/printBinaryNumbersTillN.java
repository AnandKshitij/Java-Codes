package Queue;

import java.util.*;
import java.util.Scanner;

/*
 Given a positive integer N.
 Print all the numbers from 1 to N in binary form.
 This is a functional problem.
 You should code only the function.
 */

/*
If we know the binary form of n(Let it be a string s) 
Then the binary form of 2n is (string s + "0")
And the binary form of 2n+1 is (string s + "1")

So from binary form of 1 we can calculate the binary form of 2 & 3
From 2 we can get the binary form of 4 and 5
From 3 we can get the binary form of 6 and 7
and so on

So what we will do is we will print the binary form of the given no. and 
then we will add 2n and (2n+1) in the queue
 */

class Pair
{
	int num;
	String binary;
}

public class printBinaryNumbersTillN {
      
	  public static void getBinary(int n){
	        //write your code here
		  
		  Queue<Pair> Q = new LinkedList<>();
	      
		  Pair P = new Pair();
		  
		  P.num = 1;
		  P.binary = "1";
		  Q.add(P);
		  
		    while(!Q.isEmpty())
			{
		    	Pair P1 = Q.remove();
				int val = P1.num;
				String S = P1.binary;
				
				System.out.print(S + " ");
				
				if((2*val)<=n)
				{
					Pair P2 = new Pair();
					P2.num = 2*val;
					P2.binary = S+"0";
					Q.add(P2);
				}
				if(((2*val)+1)<=n)
				{
					Pair P2 = new Pair();
					P2.num = (2*val)+1;
					P2.binary = S+"1";
					Q.add(P2);
				}
			}
		    
	     }
	 	 public static void main (String[] args)  {
	 	     
	 	 Scanner scn=new Scanner(System.in);
	 	  int n = scn.nextInt();
	 	  getBinary(n);
	 	         
	 	     
	 	 }
}
