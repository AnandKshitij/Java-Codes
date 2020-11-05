package HashMapsAndHeaps;

/*
1.Given an array of n integers(duplicates allowed).
2.You have to check whether it is the set of contiguous integers or not.
3.Your task is to complete the function isContiguous() which return true or false.
4.Example-The elements of array{5,2,3,6,4,4,6,6} form a contiguous set of integers which is {2,3,4,5,6} so the output is true
*/

/*
We will find the minimum and maximum in our array

So no. of contiguous elements will be maximum-minimum+1
We will also make a hash set of the no.'s in the array

If size of hash set is equal to maximum-minimum+1 then return true else return false
 */


import java.util.*;

public class ContiguousArrayDuplicacy {
	
	public static boolean isContinuous(int input[])
	{
		HashSet<Integer> H = new HashSet<>();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<input.length; i++)
		{
			int val = input[i];
			
			if(!H.contains(val))
			{
				H.add(val);
			}
			
			if(val>max)
			{
				max = val;
			}
			if(val<min)
			{
				min = val;
			}
		}
		
		int elementsRequired = max-min+1;
		int elements = H.size();
		
		if(elementsRequired == elements)
		{
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int input[] = new int [n];
		
		for(int i=0; i<n; i++)
		{
			input[i] = s.nextInt();
		}
		
		System.out.println(isContinuous(input));
	}
}
