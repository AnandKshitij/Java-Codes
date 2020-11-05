package Stacks;

/*
1. Given an array A of size N having distinct elements.
2. Find the next greater element for each element of the array in order of their appearance in the array.
3. If no such element exists, output -1. 
*/

//Java program to print next 
import java.util.*;
import java.io.*;

public class NextHigherValue
{ 
	 static class stack 
	 { 
	 	 int top; 
	 	 int items[] = new int[100]; 

	 	 // Stack functions to be used by printNGE 
	 	 void push(int x) 
	 	 { 
	 	 	 if (top == 99) 
	 	 	 { 
	 	 	 	 System.out.println("Stack full"); 
	 	 	 } 
	 	 	 else
	 	 	 { 
	 	 	 	 items[++top] = x; 
	 	 	 } 
	 	 } 

	 	 int pop() 
	 	 { 
	 	 	 if (top == -1) 
	 	 	 { 
	 	 	 	 System.out.println("Underflow error"); 
	 	 	 	 return -1; 
	 	 	 } 
	 	 	 else
	 	 	 { 
	 	 	 	 int element = items[top]; 
	 	 	 	 top--; 
	 	 	 	 return element; 
	 	 	 } 
	 	 } 

	 	 boolean isEmpty() 
	 	 { 
	 	 	 return (top == -1) ? true : false; 
	 	 } 
	 } 

	 /* prints element and NGE pair for 
	 all elements of arr[] of size n */
	 static void printNGE(int arr[], int n) 
	 { 
	 	int L = arr.length;
	 	
	 	int result[] = new int [L];
	 	
	 	for(int i=0 ; i<L ; i++)
	 	{
	 		result[i] = -1;
	 	}
	 	
	 	stack s = new stack();
	 	s.push(0);
	 	
	 	for(int i=1 ; i<L ; i++)
	 	{
	 		int val = arr[i];
	 		
	 		while(!s.isEmpty())
	 		{
	 			int topIndex = s.pop();
	 			s.push(topIndex);
	 			int topVal = arr[topIndex];
	 			
	 			if(val>topVal)
	 			{
	 				s.pop();
	 				result[topIndex] = val;
	 			}
	 			else
	 			{
	 				break;
	 			}
	 		}
	 		
	 		s.push(i);
	 	}
	 	
	 	for(int i=0 ; i<L ; i++)
	 	{
	 		System.out.println(result[i]);
	 	}
	 } 

	 public static void main(String[] args) 
	 { 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int arr[] = new int[n];
	 	 for(int i=0;i<n;i++)arr[i]=sc.nextInt(); 
	 	 printNGE(arr, n); 
	 } 
}