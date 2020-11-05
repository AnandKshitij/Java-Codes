package TreeMap;

//greatest smaller value is the floor value
//the tree map has inbuilt functions to return floor and ceil values
//the floor function will give smaller or equal value
//we can also use lower
//lower will give us strictly lower value
//it will not return  equal value
//the functions return null if such value is not found
//so we need to check that in if condition

import java.util.*;

public class GreatestSmaller {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int input[] = new int [n];
		
		for(int i=0; i<n; i++)
		{
			input[i] =s.nextInt();
		}
		
		TreeSet<Integer> T = new TreeSet<>();
		
		int result[] = new int [n];
		
		for(int i=0; i<n; i++)
		{
			int floor = -1;
			// lower is used to get strictly lower value
			if(T.lower(input[i])!=null)
			{
				floor = T.lower(input[i]);
				result[i] = floor;
			}
			T.add(input[i]);
			result[i] = floor;
		}
		
		// to get floor value
		System.out.println(T.floor(2));
		
		System.out.println(T.contains(6));
		
		TreeMap<Integer, Integer> H = new TreeMap<>();
		H.put(1, 2);
		System.out.println(H.containsKey(2));
		// stricty less value
		System.out.println(H.lowerKey(2));
		// less or equal value
		System.out.println(H.floorKey(1));
		
		for(int i=0; i<n; i++)
		{
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

}
