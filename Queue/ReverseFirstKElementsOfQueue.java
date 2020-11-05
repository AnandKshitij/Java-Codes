package Queue;

/*
1. Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.
2. Only following standard operations are allowed on queue.
enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
 */


import java.util.*;
public class ReverseFirstKElementsOfQueue  { 


	 // Function to reverse the first K elements 
	 // of the Queue 
	 static void reverseQueueFirstKElements(Queue<Integer>queue, int k) { 
	     
		 int size = queue.size();
		 
		 if(k>size)
		 {
			 k=size;
		 }
	     
		 Stack<Integer> S = new Stack<>();
		 
		 for(int i=0 ; i<k ; i++)
		 {
			 S.push(queue.remove());
		 }
		 
		 int remaining = queue.size();
		 
		 while(!S.empty())
		 {
			 queue.add(S.pop());
		 }
		 
		 for(int i=0 ; i<remaining ; i++)
		 {
			 queue.add(queue.remove());
		 }
		 System.out.println(queue);
	 }
	 
	 public static void main(String args[]) {
	 	 Queue<Integer> q=new LinkedList<Integer>(); 
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int k=sc.nextInt();
	 	 for(int i=0;i<n;i++)q.add(sc.nextInt());
	 	 reverseQueueFirstKElements(q, k);
	 } 
}