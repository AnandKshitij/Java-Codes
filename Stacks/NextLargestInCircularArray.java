package Stacks;

/*
1. Given a circular array (the next element of the last element is the first element of the array), 
find the Next Greater Number for every element and return the array. 
2. The Next Greater Number of a number x is the first greater number in its traversing-order next to it. 
3. You can search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example
Input: [1,2,1]
Output: [2,-1,2]
 */

/*
So the only difference in this question is that we have to assume the array
a b c d 	as
a b c d a b c d

For example given to us if we see the array as
1  2  1  1  2  1
Then our answer for 1st 3 elements would be 
2 -1  2

We don't have to build this array we just have to move circular
So loop will move 2*n-1 times instead of n times

 */

import java.util.*;
public class NextLargestInCircularArray {

    public static int[] nextGreaterCircularInManner(int[] nums) {
    	
    	int result[] = new int [nums.length];
    	
    	for(int i=0 ; i<result.length ; i++)
    	{
    		result[i] = -1;
    	}
    	Stack<Integer> S = new Stack<>();
    	
    	for(int i=0 ; i<2*nums.length-1 ; i++)
    	{
    		//because we want the index to remain within the range
    		int index = i%nums.length;
    		int val = nums[index];
    		
    		if(S.empty())
    		{
    			S.push(index);
    			continue;
    		}
    		
    		while(!S.empty() && val>nums[S.peek()])
    		{
    			result[S.pop()] = val;
    		}
    		
    		S.push(index);
    	}
    	
    	//the remaining elements in the stack do not have next larger element 
    	//we already have value -1 stored against them in result array
    	
    	return result;
    
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int[] res=nextGreaterCircularInManner(nums);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
}