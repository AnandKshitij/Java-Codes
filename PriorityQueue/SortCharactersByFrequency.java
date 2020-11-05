package PriorityQueue;

/*
1. Given a string, sort it in decreasing order based on the frequency of characters.

The question has not told anything about what to do when the frequencies are equal
So for that case we leave the output on the priority queue

But to solve a special case of sorting the elements lexicographically in case of equal frequency
We have written the code in the brackets
*/

import java.util.*;

public class SortCharactersByFrequency {

	static class Pair
	{
		int freq;
		char element;
	}
	
	static class FreqComparator implements Comparator<Pair>
	{
		public int compare(Pair P1, Pair P2)
		{
			return P2.freq-P1.freq;
				
			/*
			if(P1.freq!=P2.freq)
			{
				return (P2.freq-P1.freq);
			}
			else
			{
				return (P1.element-P2.element);
			}
			*/
		}
	}
	
	public static void printFreq(String str)
	{
		HashMap<Character,Integer> H = new HashMap<>();
		
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			
			if(!H.containsKey(ch))
			{
				H.put(ch,1);
			}
			else
			{
				H.put(ch,H.get(ch)+1);
			}
		}
		
		Pair arr[] = new Pair[H.size()];
		
		int add = 0;
		for(char key : H.keySet())
		{
			int f = H.get(key);
			Pair P = new Pair();
			P.element = key;
			P.freq = f;
			arr[add] = P;
			add++;
		}
		
		PriorityQueue<Pair> P = new PriorityQueue<>(new FreqComparator());
		
		for(int i=0; i<arr.length; i++)
		{
			Pair temp = arr[i];
			P.add(temp);
		}
		
		String result = "";
		
		while(!P.isEmpty())
		{
			Pair temp = P.remove();
			char ch = temp.element;
			int freq = temp.freq;
			
			for(int i=0; i<freq; i++)
			{
				result = result + ch;
			}
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printFreq(str);
	}
}
