package Stacks;

/*
1. Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. 
2. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, 
T and F (T and F represent True and False respectively).
Note:
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).

EXAMPLE
Input: "F?1:T?4:5"
Output: "4"
 */

/*
The most imp thing to know for solving this question is that the ternary operators are solved
from right to left

Ex:
F?1:T?4:5

(condition)?(if true):(if false)

First condition which will be solved is T?4:5
This will evaluate to be 4

Now we are left with
F?1:4

This will evaluate to be 4

We will solve this using stack
We will move left to right

We get 5
Push to stack
Stack = 5

We get :
Move forward

We get 4
Push to stack
Stack = 4 5

We get ?
So we see next element
We get T
Pop two values from stack
val1 = 4
val2 = 5
Select val1
So push it back to stack
Stack = 4

We get :
Move forward

We get 1
Push to stack
Stack = 1 4

We get ?
We get F
Pop two values from stack
val1 = 1
val2 = 4
Select val2
So push it back to stack
Stack = 4


So the rule is : -> continue
			   ? -> move ahead in string(move ahead here means index--)
			   				pop val1 and val2
			   				then check if that element is true or false
			   					if true add val1
			   					if false add val2
			   any other thing -> push to stack
 */


import java.util.*;

import java.util.*;

public class EvaluationOfTernaryExp {

    public static String parseTernary(String expression) {
        // Write your code here
    	
    	Stack<Character> S = new Stack<>();
    	
    	for(int i=expression.length()-1 ; i>=0 ; i--)
    	{
    		char ch = expression.charAt(i);
    		
    		if(ch==':')
    		{
    			continue;
    		}
    		if(ch=='?')
    		{
    			i--;
    			char val1 = S.pop();
    			char val2 = S.pop();
    			
    			if(expression.charAt(i)=='T')
    			{
    				S.push(val1);
    			}
    			else
    			{
    				S.push(val2);
    			}
    		}
    		else
    		{
    			S.push(ch);
    		}
    	}
    	
    	return (S.peek()+"");
    }

    // Dont make chsnges here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(parseTernary(sc.next()));
    }
}