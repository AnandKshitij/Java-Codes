package Stacks;

/*
We will be given a string input expression
We have to return the integer output
 */

/*
For implementing this approach we will be using two stacks
One operator stack and other data stack
In operator stack we will add operators and brackets
In data stack we will be adding no.'s

Expression-

7+8/4+(6-2)^3

We will put an opening bracket initially in the operator stack
We are showing stack assuming stack top is on the left

result=0
op Stack = (
data Stack = empty

We get 7
We push it to the data stack
result=0
op stack = (
data stack = 7

We get +
We see the top of op stack. Since it is opening bracket we push it
result = 0
op stack = + (
data stack = 7

We get 8
We push it to the data stack
result=0
op stack = + (
data stack = 8 7

We get / 
We see top of of stack. Since it is + and + has lower priority then /
So / will be pushed
This is because / has to performed before +(it has higher priority)
op stack = / + (
data stack = 8 7

We get 4
We push it to the data stack
result=0
op stack = / + (
data stack = 4 8 7

We get +
We see the top of op stack. It is / 
/ has higher priority than +
S / will be popped along with elements two elements of data stack

First element popped from data stack(data1) = 4
Second element popped from data stack(data2) = 8
result += data2 op data1
Because data2 was on the left

Now element on top of stack is +
+ has same priority as +
So + will be popped. As associativity is from left to right
And so on the process will continue

 */

import java.util.*;

public class InfixEvaluation {
	
	public static int priorityCompare(char ch1, char ch2)
	{
		HashMap<Character,Integer> H = new HashMap<>();
		H.put('+',1);
		H.put('-',1);
		H.put('*',2);
		H.put('/',2);
		
		int prior1 = H.get(ch1);
		int prior2 = H.get(ch2);
		
		return prior1-prior2;
	}
	
	public static int evaluate(char op, int val1, int val2)
	{
		int ourValue = 0;
		if(op=='+')
		{
			ourValue = val2+val1;
		}
		else if(op=='-')
		{
			ourValue = val2-val1;
		}
		else if(op=='*')
		{
			ourValue = val2*val1;
		}
		else if(op=='/')
		{
			ourValue = val2/val1;
		}
		return ourValue;
	}
	
	public static int evaluateInfix(String str)
	{
		Stack<Character> opStack = new Stack<>();
		Stack<Integer> dataStack = new Stack<>();
		
		opStack.push('(');
		
		int result=0;
		for(int i=0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			
			if(ch>='0' && ch<='9')
			{
				String temp = ch+"";
				while(i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9')
				{
					temp = temp+str.charAt(i+1);
					i++;
				}
				int data = Integer.parseInt(temp);
				dataStack.push(data);
				continue;
			}
			if(ch=='(')
			{
				opStack.push(ch);
				continue;
			}
			if(ch==')')
			{
				while(opStack.peek()!='(')
				{
					char op = opStack.pop();
					int val1 = dataStack.pop();
					int val2 = dataStack.pop();
					
					dataStack.push(evaluate(op,val1,val2));
				}
				opStack.pop();
				continue;
			}
			
			char topValue = opStack.peek();
			
			if(topValue=='(')
			{
				opStack.push(ch);
				continue;
			}
			
			while(topValue!='(' && priorityCompare(ch,topValue)<=0)
			{
				char op = opStack.pop();
				int val1 = dataStack.pop();
				int val2 = dataStack.pop();
				
				dataStack.push(evaluate(op,val1,val2));
				topValue = opStack.peek();
			}
			
			opStack.push(ch);	
		}
		
		char ch = ')';
		if(ch==')')
		{
			while(opStack.peek()!='(')
			{
				char op = opStack.pop();
				int val1 = dataStack.pop();
				int val2 = dataStack.pop();
				
				dataStack.push(evaluate(op,val1,val2));
			}
			opStack.pop();
		}
		
		result = dataStack.peek();
		return result;
		
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int infixResult = evaluateInfix(str);
		System.out.println(infixResult);
	}
}
