package Stacks;

/*
1. Given a stack of integers of size N, your task is to complete the function pairWiseConsecutive()
2. It checks whether numbers in the stack are pairwise consecutive or not. 
3. The pairs can be increasing or decreasing, and if the stack has an odd number of elements, the element at the top is left out of a pair. 
4. The function should retain the original stack content.
5. Only following standard operations are allowed on stack.
push(X): Enter a element X on top of stack.
pop(): Removes top element of the stack.
empty(): To check if stack is empty. 
 */

import java.util.Scanner;
import java.util.*;

//User function Template for Java
// your task is to complete the function
// function should return true/false or 1/0

public class ConsecutivePairsInStack {
	
	 public static boolean pairWiseConsecutive(Stack<Integer> st) {
	 // Write your code here
		 
		 Stack<Integer> S = new Stack<Integer>();
		 
		 int size = 0;
		 
		 while(!st.empty())
		 {
			 S.push(st.pop());
			 size++;
		 }
		 
		 //if stack has even no. of elements
		 if(size%2==0)
		 {
			 while(!S.empty())
			 {
				int top1 =  S.pop();
				int top2 = S.pop();
				
				st.push(top1);
				st.push(top2);
				
				int diff = top1-top2;
				
				if(!(diff==1 || diff==-1))
				{
					return false;
				}
			 }
		 }
		 else
		 {
			 size--;
			 while(size>0)
			 {
				 int top1 =  S.pop();
				 int top2 = S.pop();
					
				 st.push(top1);
				 st.push(top2);
					
				 int diff = top1-top2;
					
				 if(!(diff==1 || diff==-1))
				 {
					 return false;
				 }
				 
				 size -= 2;
			 }
			 st.push(S.pop());
		 }
		 
		 return true;
	 }
	 
	 public static void main(String[] args)
	 {
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 Stack<Integer>st=new Stack<>();
	 	 for(int i=0;i<n;i++){
	 	 	 st.push(sc.nextInt());
	 	 }
	 	 System.out.println(pairWiseConsecutive(st));	 	 
	 }
}