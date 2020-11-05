package linkedListTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PairSum {

	 public static class Node {
	 	 int data;
	 	 Node next;

	 	 Node(int key) {
	 	 	 data = key;
	 	 	 next = null;
	 	 }
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 int n1 = sc.nextInt();
	 	 Integer arr1[] = new Integer[n1];

	 	 for (int i = 0; i < n1; i++)
	 	 	 arr1[i] = sc.nextInt();

	 	 int n2 = sc.nextInt();
	 	 Integer arr2[] = new Integer[n2];

	 	 for (int i = 0; i < n2; i++)
	 	 	 arr2[i] = sc.nextInt();

	 	 LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
	 	 LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
	 	
	 	 int x = sc.nextInt();

	 	 System.out.println(countpair(head1, head2, x));

	 }
  //you just need to complete this function
	 public static int countpair(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) 
	 {
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 Iterator<Integer> c1 = head1.iterator();
		 
		 while(c1.hasNext()) 
		 {
		 	int data = (Integer)c1.next();
		 	
		 	if(!H.containsKey(data))
		 	{
		 		H.put(data,1);
		 	}
		 	else
		 	{
		 		int freq = H.get(data);
		 		H.put(data,freq+1);
		 	}	
		 }
		 
		 Iterator<Integer> c2 = head2.iterator();
		 
		 int count = 0;
		 
		 while(c2.hasNext())
		 {
			 int num = (Integer)c2.next();
			 int find = x-num;
			 
			 if(H.containsKey(find))
			 {
				 count += H.get(find);
			 }
		 }
		 
		 return count;
	}
}