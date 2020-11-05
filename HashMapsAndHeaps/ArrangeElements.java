package HashMapsAndHeaps;

import java.util.*;

public class ArrangeElements {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int input[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			input[i] = s.nextInt();
		}
		
		HashMap<Integer,Integer> H = new HashMap<>();
		
		int max = 1;
		int maxElement = 1;
		
		for(int i=0 ; i<n ; i++)
		{
			int val = input[i];
			
			if(!H.containsKey(val-1))
			{
				H.put(val,1);
			}
			else
			{
				H.put(val,H.get(val-1)+1);
				if(H.get(val)>max)
				{
					max = H.get(val);
					maxElement = val;
				}
			}
		}
		
		int start = maxElement-max;
		
		while(start>0)
		{
			System.out.println("Insert At Beginning:" + start);
			start--;
		}
		
		maxElement += 1;
		
		while(maxElement<=input.length)
		{
			System.out.println("Insert At End" + maxElement);
			maxElement++;
		}
		
		
		int noOfOperations = input.length-max;
		
		System.out.println(noOfOperations);
		
	}
}
