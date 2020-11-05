package DynamicProgramming;

/*
1. You will be given an integer array, A 
2. You need to find the number of arithmetic subsequence slices in the array
3. Sequence with atleast 3 numbers and same difference between consecutive numbers is 
arithmetic sequence

Sample Input
8
2 4 6 10 8 6 12 6
Sample Output
10
*/

import java.util.*;

public class ArithmeticSliceSubsequence {

	public static int Arithmetic_Subsequence(int[] A) {
		
		int n = A.length;
		
		ArrayList<HashMap<Integer,Integer>> dp = new ArrayList<>();
		
		if(n<2) {
			return 0;
		}
		
		HashMap<Integer,Integer> t = new HashMap<>();
		dp.add(t);
		
		int totalSlices = 0; 
		
		for(int i=1; i<n; i++) {
			int val1 = A[i];
			HashMap<Integer,Integer> curr = new HashMap<>();
			
			for(int j=0; j<i; j++) {
				HashMap<Integer,Integer> prev = dp.get(j);
				
				int val2 = A[j];
				int diff = val1-val2;
				
				if(prev.containsKey(diff)) {
					int temp = prev.get(diff);
					totalSlices += temp;
					if(curr.containsKey(diff)) {
						curr.put(diff,curr.get(diff)+temp+1);
					}
					else {
						curr.put(diff,temp+1);
					}
				}
				else {
					if(curr.containsKey(diff)) {
						curr.put(diff,curr.get(diff)+1);
					}
					else {
						curr.put(diff,1);
					}
				}
			}

			dp.add(curr);
		}
		
		return totalSlices;
	}
	
	public static void main(String[] args) {
	 	Scanner scn= new Scanner(System.in);
	 	int n=scn.nextInt();
	 	int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i]=scn.nextInt();
	 	System.out.print(Arithmetic_Subsequence(A));
	 	scn.close();
	 }
}
