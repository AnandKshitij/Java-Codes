package Stacks;

/*
1. Given array A[] of integers, the task is to find the maximum absolute difference 
between nearest left and right smaller element of every element in array.
2. If the element is the leftmost element, nearest smaller element on left side is considered as 0. 
3. Similarly if the element is the rightmost elements, smaller element on right side is considered as 0. 
4. Return the max absolute difference found.
 */

import java.util.*;
public class NextSmallerOnLeftRight
{
    public static int findMaxDiff(int A[], int N)
    { 
    	Stack<Integer> S = new Stack<>();
    	
    	int result = Integer.MIN_VALUE;
    	
    	for(int i=0 ; i<A.length ; i++)
    	{
    		int val = A[i];
    		
    		if(S.empty())
    		{
    			S.push(val);
    			continue;
    		}
    		
    		int topVal = S.peek();
    		
    		if(val==topVal)
    		{
    			continue;
    		}
    		
    		if(val>topVal)
    		{
    			S.push(val);
    			continue;
    		}
    		
    		while(!S.empty() && val<topVal)
    		{
    			S.pop();
    			int leftVal = 0;
    			if(!S.empty())
    			{
    				leftVal = S.peek();
    			}
    			int rightVal = val;
    			int ans = rightVal-leftVal;

    			if(ans<0)
    			{
    				ans = -1*ans;
    			}
    			if(ans>result)
    			{
    				result = ans;
    			}
    			topVal = leftVal;
    		}
    		if(!S.empty() && val==S.peek())
    		{
    			continue;
    		}
    		S.push(val);
    	}
    	
    	
    	while(!S.empty())
    	{
    		S.pop();
    		int rightVal = 0;
    		int leftVal = 0;
    		if(!S.empty())
			{
				leftVal = S.peek();
			}
    		
			int ans = rightVal-leftVal;
			if(ans<0)
			{
				ans = -1*ans;
			}
			if(ans>result)
			{

				System.out.println(ans);
				result = ans;
			}
    		
    	}
    	
    	return result;
    }
    

    public static void main(String[] args)
    {
    	 Scanner sc=new Scanner(System.in);
    	 int N=sc.nextInt();
    	 int[] A=new int[N];
    	 for(int i=0;i<N;i++)A[i]=sc.nextInt();
    	 System.out.println(findMaxDiff(A, N));
    }
}