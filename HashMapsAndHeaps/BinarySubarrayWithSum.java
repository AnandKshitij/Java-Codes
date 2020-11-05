package HashMapsAndHeaps;

/*
1. You are given a binary array A i.e. array element is either 0 or 1.
2. You are also given a sum S.
3. You have to write a function that returns the count of all the non-empty subarrays of A that have sum S.
For example:
Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 sub arrays are with sum S are:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]
4. printArray is a utility function which displays an array, feel free to use it for debugging purposes.
5. main takes input from the users and creates the array. You can use printArray to know its contents.
6. This is a functional problem. 
7. You have to complete the numSubarraysWithSum function. It takes as input a binary array and a sum S. It should return 
the count of sub arrays with sum S.
8. Don't change the code of main and printArray.
 */

import java.util.Scanner;
import java.util.HashMap;

public class BinarySubarrayWithSum {
	
	public static int findSubarrays(int input[], int sum)
	{
		HashMap<Integer,Integer> H = new HashMap<>();
		
		H.put(0,1);
		
		int ones = 0;
		
		for(int i=0 ; i<input.length ; i++)
		{
			int val = input[i];
			
			if(input[i]==1)
			{
				ones++;
				H.put(ones,1);
			}
			else
			{
				H.put(ones,H.get(ones)+1);
			}
		}
		
		
		int result = 0;
		
		for(int i : H.keySet())
		{
			if(H.containsKey(i-sum))
			{
				/*
				for cases like
				2 
				0 0 
				0
				*/
				if(i!=i-sum)
				result += H.get(i)*H.get(i-sum);
				else
				result += H.get(i);
			}
		}
		
		return result;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int input[] = new int [n];
		
		for(int i=0 ; i<n ; i++)
		{
			input[i] = s.nextInt();
		}
		
		int sum = s.nextInt();
		int result = findSubarrays(input,sum);
		System.out.println(result);
	}
}
