package HashMapsAndHeaps;

/*
1.Given two arrays A and B of equal size N.
2.The task is to find if given arrays are equal or not.
3.Two arrays are said to be equal if both of them contain same set of elements,
arrangements (or permutation) of elements may be different though.
 */

import java.util.*;

public class EqualArrays {

	 public static boolean isTwoArrayEqual(long[] num1, long[] num2) {	 	 
		 
		 HashMap<Long, Integer> H1 = new HashMap<>();

		 for(int i=0; i<num1.length ; i++)
		 {
			 long val = num1[i];
			 
			 if(!H1.containsKey(val))
			 {
				 H1.put(val,1);
			 }
			 else
			 {
				 H1.put(val,H1.get(val)+1);
			 }
		 }
		 
		 for(int i=0; i<num2.length; i++)
		 {
			 long val = num2[i];
			 
			 if(!H1.containsKey(val))
			 {
				 return false;
			 }
			 else
			 {
				 H1.put(val,H1.get(val)-1);
			 }
		 }
		 
		 for(long i : H1.keySet())
		 {
			 int val = H1.get(i);
			 
			 if(val!=0)
			 {
				 return false;
			 }
		 }
		 
		 return true;
	 }

	 public static void main(String[] args) 
	 {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 long[] num = new long[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 num[i] = scn.nextLong();
	 	 }
	 	 int m = n;
	 	 long[] arr = new long[m];
	 	 for (int i = 0; i < m; i++) {
	 	 	 arr[i] = scn.nextLong();
	 	 }
	 	 boolean x = isTwoArrayEqual(num, arr);
	 	 System.out.println(x);
	 }

}