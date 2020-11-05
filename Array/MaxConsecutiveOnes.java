package Array;

/*
1. You are given an array of N elements.
2. The array is a binary array, i.e. it contains either 0 or 1.
3. You have to find the maximum number of consecutive 1s in this array if you can flip at most one 0.
4. Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 
1s is 4.
*/


import java.util.*;

public class MaxConsecutiveOnes {
	
	 public static int findMaxConsecutiveOnes(int[] nums) {
	 	 // write your code here.
		 
		 if(nums.length==0) {
			 return 0;
		 }
		 
		 int start = 0;
		 int end = 1;
		 
		 int numZero = 0;
		 
		 if(nums[0]==0){
			 numZero = 1;
		 }
		 
		 int maxLength = 1;
		 
		 boolean isValid = true;
		 
		 while(end<=nums.length){
			 
			 if(isValid) {
				 
				 if(end==nums.length) {
					 break;
				 }
				 
				 int val =  nums[end];
				 end++;
				 
				 if(val==0) {
					 numZero++;
				 }
				 
				 if(numZero<2) {
					 int length = end-start;
					 if(length>maxLength) {
						 maxLength = length;
					 }
				 }
				 else {
					 isValid = false;
				 }
			 }
			 else {
				 int val = nums[start];
				 start++;
				 
				 if(val==0) {
					 numZero--;
				 }
				 
				 if(numZero<2) {
					 int length = end-start;
					 if(length>maxLength) {
						 maxLength = length;
					 }
					 isValid = true;
				 }
			 }
		 }
		 
		 return maxLength;

	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 // Input for length of first array.
	 	 int N = sc.nextInt();

	 	 int[] arr1 = new int[N];

	 	 // Input for array1 elements.
	 	 for (int i = 0; i < arr1.length; i++) {
	 	 	 arr1[i] = sc.nextInt();
	 	 }

	 	 int result = findMaxConsecutiveOnes(arr1);

	 	 System.out.println(result);

	 }

	 // Function to display an array.
	 public static void display(int[] arr) {

	 	 for (int i = 0; i < arr.length; i++) {
	 	 	 System.out.print(arr[i] + " ");
	 	 }

	 	 System.out.println();
	 }

}

