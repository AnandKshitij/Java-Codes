package Implementations;


//this one is for push efficient


/*
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
We need this to be push efficient
So push function should take O(1) time

push 1 to stack
We will simply add it to the first queue
Queue - 1

push 2 to the stack
Queue - 1	2

push 3 to the stack
Queue - 1	2	3

So we are able to do push in O(1) time 

Now we want to use pop function
Then we have to use another queue for this
We will transfer all the elements in the other queue except the last element 
And then we make this queue our main queue

For top too we follow the same process
We just enqueue the last element too
 */


import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class StackUsingTwoQueues {

	static Queue<Integer> Q1 = new LinkedList<>();
	static Queue<Integer> Q2 = new LinkedList<>();
	
	static void push(int x)
	{
		Q1.add(x);
	}
	
	static int pop()
	{
		if(Q1.size()==0)
		{
			return -1;
		}
		while(Q1.size()>1)
		{
			Q2.add(Q1.remove());
		}
		
		int popped = Q1.remove();
		Queue<Integer> Q3 = Q1;
		Q1 = Q2;
		Q2 = Q3;
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