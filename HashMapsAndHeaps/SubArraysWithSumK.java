package HashMapsAndHeaps;

/*
1. Given an unsorted array arr[] of N integers and a sum.
2. The task is to count the number of sub array which adds to a given number.
3. Input and output is handled for you
4. It is a functional problem ,please do not modify main()
*/

/*
We will be doing sub array sum questions by using prefix sum

Sample Input
5 -10
10 2 -2 -20 10
Sample Output
3

First we put 0-> 1 in hash map
As our prefix sum is 0 initially

Then we get 10
Prefix sum becomes 10
10-(-10)=20 
20 is not present in our hash map
Then we add 
10-> 1
in the hash map

Then we get 2
Prefix sum becomes 12
12-(-10)=22 
22 is not present in our hash map
Then we add 
0->1
10-> 1
12-> 1
in the hash map

Then we get -2
Prefix sum becomes 10
10-(-10)=20 
20 is not present in our hash map
Then we add
0-> 1 
10-> 2
12-> 1
in the hash map

Then we get -20
Prefix sum becomes -10
-10-(-10)=0 
0 is present in our hash map 1 time 
So we add 1 to our count of sub arrays
Then we add 
-10->1
0-> 1 
10-> 2
12-> 1
in the hash map

Then we get 10
Prefix sum becomes 0
0-(-10)=10 
10 is present in our hash map 2 times 
So we add 2 to our count of sub arrays
Then we add 
-10->1
0-> 2 
10-> 2
12-> 1
in the hash map

Actually we get the sum of the no.'s from one point to another using prefix sums
We have to subtract the no. from the prefixSum and find because we want to find the sub array with that sum

*/

import java.util.*;

public class SubArraysWithSumK {


	 static int subArraySum(int arr[], int n, int sum) {
	 	 
	 	 int count = 0;
	 	 int prefixSum = 0;
	 	 
	 	 HashMap<Integer,Integer> H = new HashMap<>();
	 	 
	 	 H.put(0,1);
	 	 
	 	 for(int i=0; i<n; i++)
	 	 {
	 		 int val = arr[i];
	 		 prefixSum += val;
	 		 
	 		 int target = prefixSum-sum;
	 		 
	 		 if(H.containsKey(target)){
	 			 count += H.get(target);
	 		 }
	 		 
	 		 
	 		 if(!H.containsKey(prefixSum)){
	 			 H.put(prefixSum,1);
	 		 }
	 		 else{
	 			 H.put(prefixSum,H.get(prefixSum)+1);
	 		 }
	 	 }
	 	 
	 	 return count;
	 }

	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int sum = scn.nextInt();
	 	 int[] arr = new int[n];
	 	 for (int z = 0; z < n; z++) {
	 	 	 arr[z] = scn.nextInt();
	 	 }
	 	 System.out.println(subArraySum(arr, n, sum));
	 }
}