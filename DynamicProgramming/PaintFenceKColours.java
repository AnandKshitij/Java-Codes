package DynamicProgramming;

/*
1. You are given a fence with n posts and each post can be painted with one of them k colours
2. You have to paint all the posts in a way such that no more than two adjacent fence posts 
have the same color
3. Return all possible ways of painting the posts
4. Input and output is handled for you
5. It is a functional problem ,please do not modify main()
*/

import java.util.*;

public class PaintFenceKColours {
	
	public static void disp(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  	");
		}
		System.out.println();
	}
	
	public static int CountWays(int n, int k) {
	 	 if(n==0 || k==0) {
	 		 return 0;
	 	 }
	 	 
	 	 if(n==1) {
	 		 return k;
	 	 }
	 	 
	 	 int same[] = new int [n+1];
	 	 int different[] = new int [n+1];
	 	 
	 	 same[0] = 0;
	 	 different[0] = 0;
	 	 
	 	 same[1] = 0;
	 	 different[1] = k;
	 	 
	 	 for(int i=2; i<n+1; i++) {
	 		 different[i]  = (same[i-1]*(k-1)) + (different[i-1]*(k-1));
	 		 same[i] = different[i-1]*1;
	 	 }
	 	 
	 	 disp(same);
	 	 disp(different);
	 	 
	 	 int result = same[n]+different[n];
	 	 return result;
	 }
	
	public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int a=scn.nextInt();
        int b=scn.nextInt();
	 	 System.out.println(CountWays(a,b));
	 	 scn.close();
	 }

}
