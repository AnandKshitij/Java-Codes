package Stacks;

import java.util.*;

public class InfixToPostfix {
	
	public static int priorityCompare(char ch1, char ch2)
	{
		HashMap<Character,Integer> H = new HashMap<>();
		H.put('+',1);
		H.put('-',1);
		H.put('*',2);
		H.put('/',2);
		H.put('^',3);
		
		int prior1 = H.get(ch1);
		int prior2 = H.get(ch2);
		
		return prior1-prior2;
	}
	
	public static String InfixToPostfix(String infix)
	{
		Stack<Character> opStack = new Stack<>();
		Stack<String> dataStack = new Stack<>();
		opStack.push('(');
		
		for(int i=0 ; i<infix.length() ; i++)
		{
			char ch = infix.charAt(i);
			
			if(ch>='0' && ch<='9')
			{
				String temp = ch+"";
				while(i+1<infix.length() && infix.charAt(i+1)>='0' && infix.charAt(i+1)<='9')
				{
					temp = temp+infix.charAt(i+1);
					i++;
				}
				dataStack.push(temp);
				continue;
			}
			
			if(ch>='a' && ch<='z')
			{
			    dataStack.push(ch+"");
			    continue;
			}
			if(ch>='A' && ch<='Z')
			{
			    dataStack.push(ch+"");
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
					String val1 = dataStack.pop();
					String val2 = dataStack.pop();
					
					String put = val2 + val1 + op;
					dataStack.push(put);
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
				if(dataStack.empty())
				{
					return "Invalid Expression";
				}
				String val1 = dataStack.pop();
				if(dataStack.empty())
				{
					return "Invalid Expression";
				}
				String val2 = dataStack.pop();
				
				String put = val2 + val1 + op;
				dataStack.push(put);
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
				if(dataStack.empty())
				{
					return "Invalid Expression";
				}
				String val1 = dataStack.pop();
				if(dataStack.empty())
				{
					return "Invalid Expression";
				}
				String val2 = dataStack.pop();
				
				String put = val2 + val1 + op;
				dataStack.push(put);
			}
			opStack.pop();
		}
		
		return (dataStack.peek());
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i=0 ; i<T ; i++)
		{
			String infix = s.next();
			String postfix = InfixToPostfix(infix);
			System.out.println(postfix);
		}
	}
}
