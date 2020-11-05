package HashMapsAndHeaps;

/*
1. Given an array A of integers. .
2. The task is to count the number of sub array that have a sum divisible by K.
3. Input and output is handled for you
4. It is a functional problem ,please do not modify main()
*/


/*
We will be doing this problem with the same prefixSum method
The difference is here we will be storing the prefixSum%k
When the prefixSum repeats
Then this means the previous no. was of the form mk+c and this no. is of the form nk+c
So the sum of the elements of the sub array between them is divisible by k
*/

import java.util.*;

public class SubArraySumDivisibleByK {
	
	public static int getCount(int input[], int k)
	{
		int count = 0;
		int prefixSum = 0;
		
		HashMap<Integer,Integer> H = new HashMap<>();
		H.put(0,1);
		
		for (int i = 0; i < input.length; i++) 
		{
			int val = input[i];
			prefixSum += val;
			prefixSum = prefixSum%k;
			if(prefixSum<0)
			{
				prefixSum += k;
			}
			
			if(!H.containsKey(prefixSum))
			{
				H.put(prefixSum,1);
			}
			else
			{
				count += H.get(prefixSum);
				H.put(prefixSum,H.get(prefixSum)+1);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K = s.nextInt();
		
		int input[] = new int [N];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = s.nextInt();
		}
		
		int result = getCount(input,K);
		System.out.println(result);
	}

}
