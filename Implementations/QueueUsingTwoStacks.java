package Implementations;

/*
We want to implement a queue using stacks
We can either make it enqueue efficient or dequeue efficient

In this class we will make it enqueue efficient
 */

/*
Enqueue(6) Enqueue(8) Enqueue(9) Dequeue Dequeue

For enqueue we push the element in the first stack
Stack1 - 6
Stack2 - Empty

For enqueue we push the element in the first stack
Stack1 - 8 6
Stack2 - Empty

For enqueue we push the element in the first stack
Stack1 - 9 8 6
Stack2 - Empty

For dequeue  we have to remove the 1 element in the queue 
This is the last element in our stack
So we move all the elements in stack1 to stack2 except the last element
Then we again move all the elements from stack2 to stack1

 */

import java.util.*;

public class QueueUsingTwoStacks {

    static class queUsingStack {

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        queUsingStack() {

        }

        public void push(int x) {
        	s1.push(x);
        }
        

        public int pop() {
        	
        	int popped = -1;
        	while(s1.size()>1)
        	{
        		s2.push(s1.pop());
        	}
        	if(!s1.empty())
        	{
        		popped = s1.pop();
        	}
        	while(!s2.empty())
        	{
        		s1.push(s2.pop());
        	}
        	
        	return popped;
        }

        public int peek() {
        	
        	int top = -1;
        	while(s1.size()>1)
        	{
        		s2.push(s1.pop());
        	}
        	if(!s1.empty())
        	{
        		top = s1.peek();
        	}
        	while(!s2.empty())
        	{
        		s1.push(s2.pop());
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