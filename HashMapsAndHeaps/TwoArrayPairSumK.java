package HashMapsAndHeaps;

/*
1.Given two unsorted arrays A of size N and B of size M of distinct elements.
2.The task is to find all pairs from both arrays whose sum is equal to X.
3.You have to complete the function print() which should print values of all the pairs u,v
where u belongs to array A and v belongs to array B, such that each pair is separated from
the other by a ',' without quotes also add a space after the ',' . If no such pair exist print -1.
*/

/*
We want the pair sum in sorted order

So we sort both the arrays initially
Then we put start on 0th index of 1st array and end at last index of 2nd array
And we move them to find all the pairs with sum k
*/


import java.util.*;

public class TwoArrayPairSumK {

	 public static void print(int[] arr1, int[] arr2, int k) {
	
		 Arrays.sort(arr1);
		 Arrays.sort(arr2);
		 
		 int start = 0;
		 int end = arr2.length-1;
		 
		 boolean printed = false;
		 
		 while(start<arr1.length && end>=0)
		 {
			 int val1 = arr1[start];
			 int val2 = arr2[end];
			 
			 if(val1+val2==k)
			 {
				 if(!printed)
				 {
					 System.out.print(val1+" "+val2);
					 printed = true;
				 }
				 else
				 {
					 System.out.print(", " + val1 + " " + val2);
				 }
				 start++;
				 end--;
			 }
			 else if(val1+val2<k)
			 {
				 start++;
			 }
			 
			 else if(val1+val2>k)
			 {
				 end--;
			 }
			 
		 }
	 
	 }

	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int m = scn.nextInt();
	 	 int k = scn.nextInt();
	 	 int[] num = new int[n];
	 	 int[] num2 = new int[m];
	 	 for (int i = 0; i < n; i++) {
	 	 	 num[i] = scn.nextInt();
	 	 }

	 	 for (int i = 0; i < m; i++) {
	 	 	 num2[i] = scn.nextInt();
	 	 }
	 	 print(num, num2, k);
	 	 System.out.println();

	 }

}