package Stacks;

/*
1. Given a stack, the task is to sort it such that the top of the stack has the greatest element.
2. Return the sorted stack.

Sample Input
5
11 2 32 3 41
Sample Output
41 32 11 3 2

We will need another stack to sort the stack

We get 11
Stack - 11
Auxiliary Stack - empty

We get 2
We see the top of stack
Since top is greater than 2 we move it to the auxiliary stack
Then stack is empty
So we push 2 
Now we move 11 from auxiliary stack to main stack
Stack - 2 11
Auxiliary Stack - empty

We get 32
We see the top of stack
Since top is less than 32 
So we push 32
Stack - 2 11 32
Auxiliary Stack - empty

We get 3
We see the top of stack
Since top is greater than 3 we move it to the auxiliary stack
Then we again see the top it is also greater than 3. So we move it to auxiliary stack
Then we again see the top it is less than 3. So we push 3 to the main stack
Now we move 11 & 32 from auxiliary stack to main stack
Stack - 2 3 11 32
Auxiliary Stack - empty

We get 45
We see the top of stack
Since top is less than 45 
So we push 45
Stack - 2 3 11 32 45
Auxiliary Stack - empty

 */


import java.util.*; 

public class SortStack 
{ 
	 public static Stack<Integer> sortstack(Stack<Integer> input) 
	 { 
		 Stack<Integer> S = new Stack<>();
		 
		 while(!input.empty())
		 {
			 int val = input.pop();
			 
			 if(S.empty())
			 {
				 S.push(val);
				 continue;
			 }
			 
			 if(val>=S.peek())
			 {
				 S.push(val);
				 continue;
			 }
			 
			 while(!S.empty() && val<S.peek())
			 {
				 input.push(S.pop());
			 }
			 S.push(val);
		 }
		 
		 return S;
	 } 
	 
	 public static void main(String args[]) 
	 { 
	 	 Stack<Integer> input = new Stack<Integer>(); 
	 	 Scanner sc=new Scanner(System.in); 
                int n=sc.nextInt();
	 	 for(int i=0;i<n;i++)input.push(sc.nextInt());
                
                Stack<Integer> res=sortstack(input); 
	 	 
	 	 while (!res.empty()) 
	 	 { 
	 	 	 System.out.print(res.pop()+" "); 
	 	 } 
	 } 
}
