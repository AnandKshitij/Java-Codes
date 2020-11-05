package DynamicProgramming;

/*
1. You will be given an integer array, A 
2. You need to find the number of arithmetic slices in the array
3. Sequence with atleast 3 numbers and same difference between consecutive numbers
*/

import java.util.*;

public class ArithmeticSliceSubArray {
	
	public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] A= new int[n];
        for(int i=0;i<n;i++)
            A[i]=scn.nextInt();
	 	 System.out.println(Arithmetic_Slices(A));
	 }

	 public static int Arithmetic_Slices(int[] A) {	 
		 int n = A.length;
		 
		 if(n<3) {
			 return 0;
		 }
		 
		 //meaning of box- the no. of arithmetic slices ending at given index
		 int dp[] = new int [n];
		 
		 dp[0] = 0;
		 dp[1] = 0;
		 
		 int totalSlices = 0;
		 
		 for(int i=2; i<n; i++) {
			 int currVal = A[i];
			 int prevVal = A[i-1];
			 int prevPrevVal = A[i-2];
			 
			 if(currVal-prevVal==prevVal-prevPrevVal) {
				 dp[i] = dp[i-1]+1;
				 totalSlices += dp[i];
			 }
		 }
		 
		 return totalSlices;
	 }
}
