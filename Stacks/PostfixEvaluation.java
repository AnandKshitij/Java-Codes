package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation{
	
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
	
	
	public static int evaluatePostfix(String postfix)
	{
		Stack<Integer> dataStack = new Stack<>();
		
		for(int i=0 ; i<postfix.length() ; i++)
		{
			char ch = postfix.charAt(i);
			
			if(ch==' ')
			{
				continue;
			}
			if(ch>='0' && ch<='9')
			{
				String str = ch+"";
				while((i+1)<postfix.length() && postfix.charAt(i+1)>='0' && postfix.charAt(i+1)<='9')
				{
				    str = str + postfix.charAt(i+1);
				    i++;
				}
				dataStack.push(Integer.parseInt(str));
				continue;
			}
			
			if(ch=='+' || ch=='-' || ch=='*' ||  ch=='/')
			{
				if(dataStack.empty())
				{
					return -1;
				}
				int val1 = dataStack.pop();
				if(dataStack.empty())
				{
					return -1;
				}
				int val2 = dataStack.pop();
				
				int curr = evaluate(ch,val1,val2);
				dataStack.push(curr);
			}
		}
		
		return dataStack.peek();
		
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String[] S = new String[N];
		for (int i = 0; i < N; i++) 
		{
			S[i] = s.next();
		}

		String str = "";

		//Space shows that new string starts
		for(int i=0 ; i<N ; i++)
		{
			str = str + S[i] + ' ';
		}

		System.out.println(evaluatePostfix(str));

	}
}