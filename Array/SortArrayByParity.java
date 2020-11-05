package Array;

/*
1. You are given an integer array of non-negative integers of length N.
2. You have to modify the array such that all the even elements of the array are before all the odd elements of the array.
3. For example, 
Input: [3,1,2,4]
Output: [2,4,1,3]
The outputs [4,2,3,1], [2,4,3,1], and [4,2,1,3] would also be accepted.
*/

//this question is similar to the question of sorting 0s and 1s
//we will consider even elements as 0 and odd elements as 1



import java.util.*;

public class SortArrayByParity {

	 public static int[] sortArrayByParity(int[] a) {
		 
		 int oddPos = -1;
		 
		 for(int i=0; i<a.length; i++) {
			 if(a[i]%2!=0) {
				 oddPos = i;
				 break ; 
			 }
		 }
		 
		 if(oddPos==-1) {
			 return a;
		 }
		 
		 int i = oddPos;
		 int j= oddPos+1;
		 
		 while(j<a.length) {
			 int val = a[j];
			 
			 if(val%2==0) {
				a[j] = a[i];
				a[i] = val;
				i++;
			 }
			 j++;
		 }
		 
		 return a;
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 // Input for length of array.
	 	 int length = sc.nextInt();

	 	 int[] arr = new int[length];

	 	 // Input for elements of array.
	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 arr[i] = sc.nextInt();
	 	 }

	 	 int[] result = sortArrayByParity(arr);
	 	 int[] sortedResult = sortResultEvenOdd(result);
	 	 display(sortedResult);

	 }
	 
	 private static int[] sortResultEvenOdd(int[] arr) {
	 	 int i = 0;

	 	 while (i < arr.length) {
	 	 	 if (arr[i] % 2 != 0) {
	 	 	 	 Arrays.sort(arr, 0, i);
	 	 	 	 Arrays.sort(arr, i, arr.length);
	 	 	 	 return arr;
	 	 	 }
	 	 	 i++;
	 	 }

	 	 Arrays.sort(arr);
	 	 return arr;

	 }

	 public static void display(int[] arr) {

	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 System.out.print(arr[i] + " ");
	 	 }

	 	 System.out.println();
	 }

}
