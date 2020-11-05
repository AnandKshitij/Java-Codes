package Implementations;

/*
We want to make a dequeue using two stacks
We want it to be dequeue efficient
This means the dequeue operation should be O(1)

In queue we have to dequeue the first inserted element
In stack the last inserted element is deleted
So we want the first inserted element to remain on top of stack
But we want this in O(1) time

So we have to do all the work in o(1) operation
We have to insert elements at the bottom of the stack
 */

import java.util.*;
import java.util.*;

public class QueueUsing2StacksDequeueEfficient {

    static class queUsingStack {

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        queUsingStack() {

        }

        public void push(int x) {
        	
        	while(!s1.empty())
        	{
        		s2.push(s1.pop());
        	}
        	s1.push(x);
        	while(!s2.empty())
        	{
        		s1.push(s2.pop());
        	}
        }
        

        public int pop() {
        	
        	int popped = -1;
        	if(!s1.empty())
        	{
        		popped = s1.pop();
        	}
        	return popped;
        }

        public int peek() {
        	
        	int top = -1;
        	
        	if(!s1.empty())
        	{
        		top = s1.peek();
        	}
        	return top;
        }

        public boolean empty() {
        	if(s1.empty())
        	{
        		return true;
        	}
        	return false;
        }
        

    }


// Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queUsingStack qs=new queUsingStack();
        int Q=sc.nextInt();
        for(int i=0;i<Q;i++){
            int q=sc.nextInt();
            if(q==1){
                qs.push(sc.nextInt());
            }
            else if(q==2){
                System.out.print(qs.pop()+" ");
            }
            else if(q==3){
                System.out.print(qs.peek()+" ");
            }
            else if(q==4){
                System.out.print(qs.empty()+" ");
            }
        }
    }

}