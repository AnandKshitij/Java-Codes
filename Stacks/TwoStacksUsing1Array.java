package Stacks;

/*
1. Your task is to implement 2 stacks in one array efficiently.
2. Input in the driver code is of 4 Types
(i) 1 1 x (input of this type means pushing 'x' into the stack 1)
(ii) 1 2 (input of this type means to pop element from stack1 and print the poped element)
(iii) 2 1 x (input of this type means pushing 'x' into the stack 2)
(iv) 2 2 (input of this type means to pop element from stack2 and print the poped element)
 */

/*
We have to implement two stacks using an array
We also have to use the space in the array properly
So that if space is left in the array and the user wants to push an 
element in any stack then he is able to do so

To do this we set the top1 as -1 and top2 as array.length initially

When we get push operation for 1st stack then we increment top1 and put the value there
When we get pop operation for 1st stack we decrement top1

When we get push operation for 2nd stack then we decrement top2 and put the value there
When we get pop operation for 2nd stack we increment top2

Before popping we check whether the stack is empty or not
Stack1 is empty when top=-1
Stack2 is empty when top=array.length

Before pushing we see whether our array is already full or not
Array is full if top2-top1==1
 
 */

import java.util.Scanner;

/* Structure of the class is
class TwoStack
{
	 int size;
	 int top1,top2;
	 int arr[] = new int[100];
	 TwoStack()
	 {
	 	 size = 100;
	 	 top1 = -1;
	 	 top2 = size;
	 }
}*/
public class TwoStacksUsing1Array
{
	static boolean isFull(TwoStack sq)
	{
		if(sq.top2-sq.top1==1)
		{
			return true;
		}
		return false;
	}
	
    // sq is the object of class TwoStack
    /* The method push to push element into the stack 2 */
    static void push1(int x, TwoStack sq)
    {
    	//stack is full
    	if(isFull(sq))
    	{
    		return ;
    	}
    	
    	sq.top1++;
    	sq.arr[sq.top1] = x;
    }
    
    /* The method push to push element into the stack 2*/
    static void push2(int x, TwoStack sq)
    {
    	//stack is full
    	if(isFull(sq))
    	{
    		return ;
    	}
    	
    	sq.top2--;
    	sq.arr[sq.top2] = x;
    }
    
    /* The method pop to pop element from the stack 1 */
    static int pop1(TwoStack sq)
    {
    	//stack is empty
    	if(sq.top1==-1)
    	{
    		return -1;
    	}
    	int popped = sq.arr[sq.top1];
    	sq.top1--;
    	return popped;
    }
    
    /* The method pop to pop element from the stack 2 */
    static int pop2(TwoStack sq)
    {
    	//stack is empty
    	if(sq.top2==sq.size)
    	{
    		return -1;
    	}
    	int popped = sq.arr[sq.top2];
    	sq.top2++;
    	return popped;
    }
    
    public static void main(String[] args){
    	 TwoStack sq=new TwoStack();
    	  Scanner sc=new Scanner(System.in);
       	  int n=sc.nextInt();
       	  int i=0;// number of operations to be performed
       	  while(i!=n){
       	 	  int q=sc.nextInt();
       	 	  if(q==1){
       	 	 	  int op=sc.nextInt();
       	 	 	  if(op==1)
       	 	 	 	  push1(sc.nextInt(), sq);
       	 	 	  else if(op==2)
       	 	 	 	  System.out.println(pop1(sq));
       	 	  }
       	 	  else if(q==2){
       	 	 	 int op=sc.nextInt();
      	 	 	 if(op==1)
      	 	 	 	 push2(sc.nextInt(), sq);
      	 	 	 else if(op==2)
      	 	 	 	 System.out.println(pop2(sq));
      	 	  }
       	 	  i++;
       	  }
      
    }
// Dont make changes here    
    static class TwoStack
    {
    	 int size;
    	 int top1,top2;
    	 int arr[] = new int[100];
    	 TwoStack()
    	 {
    	 	 size = 100;
    	 	 top1 = -1;
    	 	 top2 = size;
    	 }
    }
}