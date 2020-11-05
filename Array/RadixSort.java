package Array;

import java.util.*;

public class RadixSort {
	public static int[] countSort(int[] A, int div) {
		int res[] = new int [A.length];
		int count[] = new int [10];
		
		for(int i=0; i<A.length; i++) {
			int digit = (A[i]/div)%10;
			count[digit]++;
		}
		
		//now to get position of every digit no. in array
		for(int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		
		//to convert position into index
		for(int i=0; i<10; i++) {
			count[i]--;
		}
		
		// we have the last index available for every digit
		// for sort to be stable we will fill the array in reverse
		for(int i=A.length-1; i>=0; i--) {
			int digit = (A[i]/div)%10;
			int index = count[digit];
			count[digit]--;
			res[index] = A[i];
		}
		
		return res;
	}
	public static int[] radixSort(int[] A) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			max = Math.max(max, A[i]);
		}
		
		for(int div=1; max/div>0; div=div*10) {
			A = countSort(A, div);
		}
		return A;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int [n];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = s.nextInt();
		}
		A = radixSort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
