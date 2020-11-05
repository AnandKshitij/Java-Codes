package HashMapsAndHeaps;

/*
1. You are given two sorted matrices of same size N x N.
2. You are also given a number K.
3. You have to find the count of all pairs from both matrices whose sum is equal to K.
4. Note: The pair has an element from each matrix.

Sample Input
3

1 	5 	6
8 	10 	11
15 	16 	18

2 	4 	7
9 	10 	12
13 	16 	20

21

Sample Output
4
*/

import java.util.*;

public class PairSumK {
	
	public static int getPairs(int A[][], int B[][], int k)
	{
		int Pairs = 0;
		int n = A.length;
		
		HashMap<Integer, Integer> H = new HashMap<>();
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				int val = A[i][j];
				
				if(!H.containsKey(val))
				{
					H.put(val,1);
				}
				else
				{
					H.put(val,H.get(val)+1);
				}
			}
		}
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				int val = B[i][j];
				int find = k-val;
				
				if(H.containsKey(find))
				{
					Pairs += H.get(find);
				}
			}
		}
		
		return Pairs;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int A[][] = new int [n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				A[i][j] = s.nextInt();
			}
		}
		
		int B[][] = new int [n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				B[i][j] = s.nextInt();
			}
		}
		
		int k = s.nextInt();
		
		int Pairs = getPairs(A,B,k);
		
		System.out.println(Pairs);
	}
}
