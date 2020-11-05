package HashMapsAndHeaps;

/*
1. You will be given 4 arrays of integers A1, A2, A3, A4 ,of size n.
2. You have to find all such quadruples a,b,c,d such that A1[a]+A2[b]+A3[c]+A4[d] = 0
3. Return your answer as count of all such quadruples.
4. Output contains the count of all the valid quadruples,input and output is handled for you
5. It is a functional problem ,please do not modify main()
*/

import java.util.*;

public class FourSumInFourArrays {

	 public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<A.length; i++)
		 {
			 int val1 = A[i];
			 for(int j=0; j<B.length; j++)
			 {
				 int sum = val1 + B[j];
				 
				 if(!H.containsKey(sum))
				 {
					 H.put(sum,1);
				 }
				 else
				 {
					 H.put(sum,H.get(sum)+1);
				 }
			 }
		 }
	
		 int pairs = 0;
		 
		 for(int i=0; i<C.length; i++)
		 {
			 int val1 = C[i];
			 for(int j=0; j<D.length; j++)
			 {
				 int sum = val1 + D[j];
				 sum = -1*sum;
				 
				 if(H.containsKey(sum))
				 {
					 pairs += H.get(sum);
				 }
	
			 }
		 }
		 
		 
		 return pairs;
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 int n = sc.nextInt();
	 	 
	 int []arr1=new int[n];
	 int []arr2=new int[n];
	 int []arr3=new int[n];
	 int []arr4=new int[n];
	 
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr1[i] = sc.nextInt();
	 	 }
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr2[i] = sc.nextInt();
	 	 }
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr3[i] = sc.nextInt();
	 	 }
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr4[i] = sc.nextInt();
	 	 }

	 	 System.out.println(fourSumCount(arr1, arr2, arr3, arr4));

	 }

}
