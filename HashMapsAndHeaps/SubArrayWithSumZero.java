package HashMapsAndHeaps;

/*
1. You will be given an array of integers
2. You need to find the count of subarrays, such that their sum amounts to 0.
4. Input is handled for you
5. It is a functional problem ,please do not modify main()
*/

import java.util.*;

public class SubArrayWithSumZero {

	 static void zerosumarr(long[] arr) {
		 
		 int count = 0;
		 long prefixSum = 0l;
		 
		 HashMap<Long,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<arr.length; i++)
		 {
			 long val = arr[i];
			 prefixSum += val;
			 
			 if(H.containsKey(prefixSum))
			 {
				 count += H.get(prefixSum);
				 H.put(prefixSum,H.get(prefixSum)+1);
			 }
			 else
			 {
				 H.put(prefixSum,1);
			 }
		 }
		 
		 System.out.println(count);
	 }
	
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);

	 	 int size = scn.nextInt();

	 	 long[] arr = new long[size];

	 	 for (int j = 0; j < size; j++) {
	 	 	 arr[j] = scn.nextLong();
	 	 }

	 	 zerosumarr(arr);

	 }
	
}