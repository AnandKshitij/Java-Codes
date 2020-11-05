package PriorityQueue;

/*
1.Given a non-empty array of integers.
2.You have to find the k most frequent elements.
3.You have to complete the topKFrequent() function which should return the list of k most frequent elements.
*/

import java.util.*;

public class KMostFrequentElements {

	 static class Pair
	 {
		 int freq;
		 int element;
	 }
	 
	 static class freqComparator implements Comparator<Pair>
	 {
		 public int compare(Pair P1, Pair P2)
		 {
			 return P2.freq-P1.freq;
		 }
	 }
	
	 public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
	 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			
			if(!H.containsKey(val))
			{
				H.put(val,1);
			}
			else
			{
				H.put(val,H.get(val)+1);
			}
		}
		 
		PriorityQueue<Pair> P = new PriorityQueue<>(new freqComparator());
		 
		for(int i : H.keySet())
		{
			int key = i;
			int freq = H.get(i);
			Pair temp = new Pair();
			temp.element = key;
			temp.freq = freq;
			P.add(temp);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0 ; i<k ; i++)
		{
			Pair temp = P.remove();
			result.add(temp.element);
		}
		
		return result;

	 }

	 //Don't make any changes here.
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 int[] ar = new int[n];
	 	 for (int i = 0; i < ar.length; i++) {
	 	 	 ar[i] = s.nextInt();
	 	 }
	 	 int k = s.nextInt();
	 	 ArrayList<Integer> res = topKFrequent(n, ar, k);
	 	 Collections.sort(res);
	 	 System.out.println(res);
	 }

}