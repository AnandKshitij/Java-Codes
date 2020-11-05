package Stacks;

/*
1. Given two sequences pushed and popped with distinct values, return true if and only if this 
could have been the result of a sequence of push and pop operations on an initially empty stack. 

EXAMPLE:
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

We will be using stack
We put i=0(for pushed) && j=0(popped)

We check if the element on top of stack is equal to popped[j]

If yes then we pop element on top of stack and j moves forward
If no then we push the ith element on stack and i moves forward

In the end if j has not reached the end then we see whether the element the elements left in stack 
are left in the same order as the popped elements left. If yes then order can be followed otherwise 
it cannot be followed 
 */



import java.util.*;
class StackValidation
{
    public static boolean validateStackSequences(int[] pushed, int[] popped) 
    {
    	int i=0,j=0;
    	
    	Stack<Integer> S = new Stack<>();
    	
    	while(i<pushed.length && j<popped.length)
    	{
    		if(S.empty())
    		{
    			S.push(pushed[i]);
    			i++;
    			continue;
    		}
    		if(popped[j]==S.peek())
    		{
    			S.pop();
    			j++;
    			continue;
    		}
    		S.push(pushed[i]);
			i++;
    	}
    	
    	while(!S.empty() && j<popped.length)
    	{
    		if(popped[j]==S.peek())
    		{
    			S.pop();
    			j++;
    		}
    		else
    		{
    			return false;
    		}
    	}

    	if(j==popped.length)
    	{
    		return true;
    	}
    	
    	return false;
    	
    	
    }
    
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int[] pushed=new int[N];
        int[] popped=new int[N];
        for(int i=0;i<N;i++)pushed[i]=sc.nextInt();
        for(int i=0;i<N;i++)popped[i]=sc.nextInt();
        System.out.print(validateStackSequences(pushed, popped));
    }
}