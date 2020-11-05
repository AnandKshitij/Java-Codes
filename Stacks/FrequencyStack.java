package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
1. Given a custom data structure named "FreqStack".
2. FreqStack has two functions:
* push(int x), which pushes an integer x onto the stack.
* pop(), which removes and returns the most frequent element in the stack.
3. If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned. 
4. Function signatures are given, you just need to complete these functions.
5. Your FreqStack object will be instantiated and then the inputs will be:
* For push(val) --> 1 val;
Example push(1) --> 1 1
* For pop() --> 2;
 */

/*
For solving this question we need two hash maps
One hash map will be integer vs its frequency
Second hash map will be frequency vs stack of integers who are having or had that frequency
 */

public class FrequencyStack
{
	
	private static class FreqStack {
		
		static HashMap<Integer,Integer> charFreq;
		static HashMap<Integer,Stack<Integer>> freqStack;
		static int highestFreq = 0;
		
		public FreqStack() {
			charFreq = new HashMap<>();
			freqStack = new HashMap<>();
		}
		

		public static void push(int x) {
			
			if(!charFreq.containsKey(x))
			{
				charFreq.put(x,1);
				if(highestFreq<1)
				{
					highestFreq = 1;
				}
				if(!freqStack.containsKey(1))
				{
					Stack<Integer> S = new Stack<>();
					S.push(x);
					freqStack.put(1,S);
				}
				else
				{
					Stack<Integer> S = freqStack.get(1);
					S.push(x);
					freqStack.put(1,S);
				}
			}
			else
			{
				int freq = charFreq.get(x);
				int newFreq = freq+1;
				charFreq.put(x,newFreq);
				if(newFreq>highestFreq)
				{
					highestFreq = newFreq; 
				}
				
				if(!freqStack.containsKey(newFreq))
				{
					Stack<Integer> S = new Stack<>();
					S.push(x);
					freqStack.put(newFreq,S);
				}
				else
				{
					Stack<Integer> S = freqStack.get(newFreq);
					S.push(x);
					freqStack.put(x,S);
				}
			}
		}

		public static int pop() {
			
			int ourFreq = highestFreq;
			int result = -1;
			
			if(freqStack.containsKey(ourFreq))
			{
				Stack<Integer> S = freqStack.get(ourFreq);
				result = S.pop();
				
				int freq = charFreq.get(result);
				int newFreq = freq-1;
				
				charFreq.put(result,newFreq);
				
				if(S.empty())
				{
					charFreq.remove(highestFreq);
					highestFreq -= 1;
				}
			}
			
			return result;
		}
}
     
	  public static void main(String[] args)
	  {
    	   FreqStack fq=new FreqStack();
    	   Scanner sc=new Scanner(System.in);
    	   int n=sc.nextInt();
    	   int i=0;
    	   while(i!=n)
    	   {
    	  	   int q=sc.nextInt();
    	  	   if(q==1)
    	  	   {
    	  		   i++;
    	  	  	   fq.push(sc.nextInt());
    	  	   }
    	  	   else if(q==2)System.out.println( fq.pop());
    	  	   i++;
    	   }
    	   
	  }
}