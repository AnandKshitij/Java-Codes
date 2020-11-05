package Brackets;

/*

1. Given a balanced parentheses string S, compute the score of the string based on the following rule:
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Sample Input
"(()(()))"
Sample Output
6

*/

/*
()->1
(A)->2*A
(A+B)->A+B

(()(()))

for this string we start moving from the left

We get (
Stack - (

We get (
Stack - ((

We get )
We see the top
It is a opening bracket
So we pop that and push 1
Stack - ( 1

We get (
Stack - ( 1 (


We get (
Stack - ( 1 ( (

We get )
We see the top
It is a opening bracket
So we pop that and push 1
Stack - ( 1 ( 1

We get )
We see the top
It is not an opening bracket
So we pop all elements till we encounter an opening bracket
We add them up
Then we pop the opening bracket
And push twice the sum 
Stack - ( 1 2

We get )
We see the top
It is not an opening bracket
So we pop all elements till we encounter an opening bracket
We add them up
Then we pop the opening bracket
And push twice the sum 
Stack - 3

Now value on the top of the stack is our answer

*/

import java.util.*;
public class ScoreOfAString{ 

   public static int scoreOfParentheses(String s) {
	 
	   int score = 0;
	   
	   Stack<String> S = new Stack<>();
	   
	   for(int i=0 ; i<s.length() ; i++)
	   {
		   char ch = s.charAt(i);
		   
		   if(S.empty())
		   {
			   S.push(ch+"");
			   System.out.println(S);
			   continue;
		   }
		   
		   if(ch=='(')
		   {
			   S.push(ch+"");
			   System.out.println(S);
			   continue;
		   }
		   
		   String top = S.peek();
		   
		   if(top.equals("("))
		   {
			   S.pop();
			   S.push(1+"");
			   System.out.println(S);
			   continue;
		   }
		   
		   int currSum = 0;
		   
		   while(!S.empty() && !S.peek().equals("("))
		   {
			   currSum += Integer.parseInt(S.pop());
		   }
		   
		   if(!S.empty())
		   {
			   S.pop();
			   S.push(Integer.toString(2*currSum));
		   }
		   
		   System.out.println(S);
		   
	   }
	   
	   while(!S.empty())
	   {
		   score += Integer.parseInt(S.pop());
	   }
	   
	   return score;
    }
    
    








    // Dont make changes here
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(scoreOfParentheses(s));
    }
    

}