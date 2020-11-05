package hashMapStoringFirstOccuerence;

/*
1.Given an array containing N integers and an integer K.
2.Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
3.You have to complete the function print() which should print the length of the longest Sub-Array with sum of the 
elements equal to the given value K.

Sample Input
6 15
10 5 2 7 1 9
Sample Output
4
*/


import java.util.*;
import java.io.*;

public class LongestSubArrayWithSumK
{
	 
	 public static void print(int n, int[] arr, int k) 
	 {
		 int prefixSum = 0;
		 
		 //stores prefixSum vs index
		 HashMap<Integer,Integer> H = new HashMap<>();
		 H.put(0,-1);
		 
		 int maxLength = 0;
		 
		 for(int i=0; i<arr.length; i++) 
		 {
			 prefixSum += arr[i];
			 
			 int find = prefixSum-k;
			 
			 if(H.containsKey(find))
			 {
				 int length = i-H.get(find);
				 if(length>maxLength)
				 {
					 maxLength = length;
				 }
			 }
			 
			 if(!H.containsKey(prefixSum))
			 {
				 H.put(prefixSum,i);
			 }
		 }
		 
		 System.out.println(maxLength);
	 }

	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 int k = s.nextInt();
	 	 int[] num = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 num[i] = s.nextInt();
	 	 }
	 	 print(n, num, k);
	 }


}