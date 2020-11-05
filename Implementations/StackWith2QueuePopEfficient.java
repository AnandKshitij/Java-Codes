package Implementations;

/*
Now we want to make a stack using two queues which is pop efficient

First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types
* 1 x (a query of this type means pushing 'x' into the stack)
* 2 (a query of this type means to pop element from stack and print the popped element)
The second line of each test case contains Q queries separated by space.
*/



/*
In stack both push and pop happen at the same end(top)

In queue push(enqueue) happens at the end and pop happens at the start

We need two queues to implement the stack
We need this to be pop efficient
So pop function should take O(1) time
So we need to do work in push operation
So that during pop the last inserted element is in the starting of queue

push 1 to stack
We will simply add it to the first queue
Queue 1 - 1

push 2 to the stack
We pop all elements from stack1 
Add them to stack2 
Add our element in stack2
Then transfer all elements back
Queue 1 - 2 1
Queue 2 - empty

For pop we just need to remove the element from queue1
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class StackWith2QueuePopEfficient {

	static Queue<Integer> Q1 = new LinkedList<>();
	static Queue<Integer> Q2 = new LinkedList<>();
	
	static void push(int x)
	{
		while(!Q1.isEmpty())
		{
			Q2.add(Q1.remove());
		}
		Q1.add(x);
		while(!Q2.isEmpty())
		{
			Q1.add(Q2.remove());
		}
	}
	
	static int pop()
	{
		int popped = -1;
		if(!Q1.isEmpty())
		{
			popped = Q1.remove();
		}
		return popped;
	}
	
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int q=sc.nextInt();
            if(q==1){
                int val=sc.nextInt();
                push(val);
            }
            else if(q==2){
                System.out.println(pop());
            }
        }
    }
}