package PriorityQueue;

/*
1. You will be given an array of prime numbers and a number k.
2. You have to find the kth smallest fraction n/d such that n and d both belong to the array of prime numbers
3. Return your answer as an array of ints, where answer[0] = n and answer[1] = d.
4. output will be a string ,"a/b". (Handles for you)
5. It is a functional problem ,please do not modify main()
*/

/*
Sample Input
3
4
1 2 3 5
Sample Output
2/5
*/


import java.util.*;

public class KthSmallestPrimeFraction {
	
	static class Triplet
	{
		int num;
		int den;
		int numIndex;
		int denIndex;
		
		public Triplet(int num, int den, int numI, int denI)
		{
			this.num = num;
			this.den = den;
			this.numIndex = numI;
			this.denIndex = denI;
		}
	}
	
	static class valueComparator implements Comparator<Triplet>
	{
		public int compare(Triplet T1, Triplet T2)
		{
			int num1  = T1.num;
			int den1 = T1.den;
			
			int num2  = T2.num;
			int den2 = T2.den;
			
			num1 = num1*den2;
			num2 = num2*den1;
			
			return (num1-num2);
		}
	}

	 public static int[] kthSmallestPrimeFraction(int[] A, int K) {
		 
		 PriorityQueue<Triplet> P = new PriorityQueue<>(new valueComparator());
		 
		 for(int i=0 ; i<A.length-1 ; i++)
		 {
			 int num = i;
			 int den = A.length-1;
			 
			 Triplet T = new Triplet(A[num],A[den],num,den);
			 P.add(T);
		 }
		 
		 int i=1;
		 
		 while(!P.isEmpty() && i<K)
		 {
			 Triplet T = P.remove();
			 int num = T.numIndex;
			 int den = T.denIndex;
			 
			 den--;
			 
			 if(den!=num)
			 {
				 Triplet temp = new Triplet(A[num],A[den],num,den);
				 P.add(temp);
			 }
			 
			 i++;
		 }
		 
		 if(P.isEmpty())
		 {
			 int result[] = new int [2];
			 result[0] = -1;
			 result[1] = 1;
			 return result;
		 }
		 
		 int result[] = new int [2];
		 Triplet T = P.remove();
		 result[0] = A[T.numIndex];
		 result[1] = A[T.denIndex];
		 return result;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 int k = sc.nextInt();
	 	 int n = sc.nextInt();
	 	 

	 	 int[] arr = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr[i] = sc.nextInt();
	 	 }

	 	 int[] ans = kthSmallestPrimeFraction(arr, k);

	 	 System.out.println(ans[0] + "/" + ans[1]);

	 }

}