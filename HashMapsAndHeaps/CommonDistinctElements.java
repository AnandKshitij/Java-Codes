package HashMapsAndHeaps;

/*
1.Given a N x N matrix.
2.You have to find count of all the distinct elements common to all rows of the matrix.
3.Your task is to complete the function count() which should return the count of all distinct
elements common to all rows of the matrix.
*/


import java.util.*;
import java.io.*;

public class CommonDistinctElements {

	 public static int count(int[][] a) 
	 {
		 int arr[] = a[0];
	 	 
		 HashMap<Integer,Integer> main = new HashMap<>();
		 
		 for(int i=0 ; i<arr.length; i++)
		 {
			 int num = arr[i];
			 
			 if(!main.containsKey(num))
			 {
				 main.put(num,1);
			 }
			 else
			 {
				 main.put(num,main.get(num)+1);
			 }
		 }
		 
		 for(int j=1; j<a.length ; j++)
		 {
			 int temp[] = a[j];
			 
			 HashMap<Integer,Integer> curr = new HashMap<>();
			 
			 for(int i=0 ; i<temp.length; i++)
			 {
				 int num = temp[i];
				 
				 if(!curr.containsKey(num))
				 {
					 curr.put(num,1);
				 }
				 else
				 {
					 curr.put(num,curr.get(num)+1);
				 }
			 }
			 
			 for(int key : main.keySet())
			 {
				 int mainFreq = main.get(key);
				 
				 int currFreq = 0;
				 
				 if(curr.containsKey(key))
				 {
					 currFreq = curr.get(key);
				 }
				 
				 if(currFreq<mainFreq)
				 {
					 main.put(key,currFreq);
				 }
			 }
		 }
		 
		 int result = 0;
		 
		 for(int i : main.keySet())
		 {
			 result += main.get(i);
		 }
		 
		 return result;
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner in = new Scanner(System.in);
	 	 int n = in.nextInt();
	 	 int a[][] = new int[n][n];
	 	 int i = 0, j = 0;
	 	 for (i = 0; i < n; i++) {
	 	 	 for (j = 0; j < n; j++) {
	 	 	 	 a[i][j] = in.nextInt();
	 	 	 }
	 	 }
	 	 System.out.println(count(a));
	 }
}