package Stacks;

/*
You are playing a game.
A String array is given to you whose ith string can be used to calculate points scored in the ith round
If the string Si is an integer : it means the points scored in this round
'+' : it means the points scored in this round is the sum of the valid points in the previous two rounds
'D' : it means the points scored in this round is double the valid points scored in the previous round
'C' : makes the points scored in the pervious round as invalid and that score must be removed
You have to return the total points scored after completion of all the rounds.
*/
import java.util.*;
import java.util.Scanner;
public class PlayingTheGame
{
	  public static int calculatePoints(String[] ops) 
	  {
		  Stack<Integer> S = new Stack<>();
		  
		  for(int i=0 ; i<ops.length ; i++)
		  {
			  String str = ops[i];
			  
			  char ch = str.charAt(0);
			  
			  if(ch=='C')
			  {
				  S.pop();
			  }
			  else if(ch=='D')
			  {
				  int topElement = S.peek();
				  S.push(2*topElement);
			  }
			  else if(ch=='+')
			  {
				  int top1 = S.pop();
				  int top2 = S.peek();
				  S.push(top1);
				  S.push(top1+top2);
			  }
			  else 
			  {
				  int val = Integer.parseInt(str);
				  S.push(val);
			  }
			  
		  }
		  
		  int result = 0;
		  
		  while(!S.empty())
		  {
			  result += S.pop();
		  }
		  
		  return result;
	  }

	 public static void main(String[] args) 
	 {
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
		 String[] S=new String[n];
		 for(int i=0;i<n;i++)
		 {
			 S[i]=sc.next();
		 }
		 System.out.println(calculatePoints(S));
	 }
}
