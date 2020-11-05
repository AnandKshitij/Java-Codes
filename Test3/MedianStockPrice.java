package Test3;

import java.util.*;

public class MedianStockPrice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int arr[] = new int [n];
	
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++)
		{
			arr[i] = s.nextInt();
			
			int val = arr[i];
			
			if(min.isEmpty() || val<min.peek())
			{
				max.add(val);
			}
			
			else
			{
				max.add(min.remove());
				min.add(val);
			}
			
			while(max.size()-min.size()>1)
			{
				min.add(max.remove());
			}
			
			if(i%2!=0)
			{
				double ans = (min.peek()+max.peek())/2.0;
				System.out.println(ans);
			}
			else
			{
				double ans = max.peek();
				System.out.println(ans);
			}
		}
	}
}
