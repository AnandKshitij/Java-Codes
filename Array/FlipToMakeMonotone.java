package Array;

/*
1. You will be given a binary string with only 0s and 1s
2. You need to check minimum flips needed to make string monotone increasing
3. Monotone increasing: String consisting some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)

Sample Input
0110011
Sample Output
2
*/


import java.util.*;

public class FlipToMakeMonotone{
	
	public static int minFlipsMonoIncr(String S) {
		int n = S.length();
		
		if(n<2) {
			return 0;
		}
		
		int A[] = new int [n-1];
		int B[] = new int [n-1];
		
		String temp = "" + S.charAt(0) + S.charAt(1);
		
		if(temp.equals("00")) {
			A[0] = 1;
			B[0] = 0;
		}
		else if(temp.equals("01")) {
			A[0] = 0;
			B[0] = 1;
		}
		else if(temp.equals("10")) {
			A[0] = 2;
			B[0] = 1;
		}
		else if(temp.equals("11")) {
			A[0] = 1;
			B[0] = 2;
		}
		
		for(int i=2; i<n; i++) {
			char ch = S.charAt(i);
			
			if(ch=='0') {
				B[i-1] = B[i-2];
				A[i-1] = Math.min(A[i-2],B[i-2])+1;
			}
			else if(ch=='1') {
				B[i-1] = B[i-2]+1;
				A[i-1] = Math.min(A[i-2], B[i-2]);
			}
		}
		
		int result = Math.min(A[n-2], B[n-2]);
		return result;
	}
	
	public static void main(String[] args){
		Scanner scn= new Scanner(System.in);
		String s= scn.next();
		System.out.print(minFlipsMonoIncr(s));
	}
}