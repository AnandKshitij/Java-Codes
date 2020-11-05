package Stacks;

/*
You have to implement stack operations push(), pop() and getMin().
push() function simply adds the element to the stack.
pop() function returns the most recent element pushed into the stack, return -1 if the stack is empty.
getMin() function returns the minimum element among the present elements in the stack.
 */

/*
We will implement this using one stack only
With that we will use just one variable to store minimum value

Suppose our stack is 8 6 9 7 5 10 getMin pop top pop getMin pop getMin pop getMin

When we get 8
We push 8 to our stack as stack is empty and update min as 8
Stack=8  	min=8

When we get 6(We see 6 is smaller than variable min)
So we update min as 6
And we push to stack min+min-prevMin
Which will be less than min bcoz prevMin is greater than min now
We push (6+6-8) to stack
Stack = 4 8 	min=6

When we get 9
We push 9 to our stack as 9 is greater than min
Stack = 9 4 8  	min=6

When we get 7
We push 7 to our stack as 7 is greater than min
Stack = 7 9 4 8  	min=6

When we get 5(We see 5 is smaller than variable min)
So we update min as 5
And we push to stack min+min-prevMin
Which will be less than min bcoz prevMin is greater than min now
We push (5+5-6) to stack
Stack = 4 7 9 4 8 	min=5

When we get 10
We push 10 to our stack as 10 is greater than min
Stack = 10 4 7 9 4 8  	min=5

Now getMin function is called 
So we give the value of min

Now pop function is called
We see whether the element on top of stack(10) is greater than min(5) or not
If yes then we pop stack top
Stack = 4 7 9 4 8 	min=5

Now top function is called 
We see whether the top value(4) is less than min(5) or not 
If yes then this means that true value of the variable is present in min(5)

Now pop function is called
We see whether the element on top of stack(4) is greater than min(5) or not
If no then we know that this element was our min element we have to give min the value of prevMin now
Also the element which is popped according to user is actually stored in min
stack top has value min+min-prevMin
So we change min to 2*min-stack top
Stack = 4 7 9 4 8 	min=5

 */

import java.util.*;
import java.util.Scanner;

public class ImplementStackWithGetMin
{    
    static int minEle=Integer.MAX_VALUE;
    static Stack<Integer> s=new Stack<>();
    
    //Complete the below 3 functions only
    static int getMin()
    {
    	if(s.empty())
    	{
    		return -1;
    	}
    	return minEle;
    }
    static int pop()
    {
    	if(s.empty())
    	{
    		return -1;
    	}
    	int topValue = s.peek();
    	
    	if(topValue>minEle)
    	{
    		return (s.pop());
    	}
    	
    	int Ans = minEle;
    	minEle = 2*minEle-topValue;
    	s.pop();
    	return Ans;
    }
    static void push(int x)
    {
    	if(s.empty())
    	{
    		s.push(x);
    		minEle = x;
    		return ;
    	}
    	
    	if(x>minEle)
    	{
    		s.push(x);
    		return ;
    	}
    	
    	s.push(x+x-minEle);
    	minEle = x;
    }	 

 
	 public static void main(String[] args) {
	 	 // TODO Auto-generated method stub
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int[] query=new int[n];
	 	 for(int i=0;i<n;i++){
	 	 	 query[i]=sc.nextInt();
	 	 }
	 	 int i=0;
	 	 while(i<n){
	 	 	 if(query[i]==1){
	 	 	 	 i++;
	 	 	 	 push(query[i]);
	 	 	 }
	 	 	 else if(query[i]==2){
	 	 	 	 System.out.println(pop());
	 	 	 }
	 	 	 else if(query[i]==3){
	 	 	 	 System.out.println(getMin());
	 	 	 }
	 	 	 i++;
	 	 }
	 }

}