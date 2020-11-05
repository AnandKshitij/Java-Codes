package PriorityQueue;

/*
1. You will be given an array with N elements
2. You will also be given an integer value k
3. You need to print K smallest element in the given array, while maintaining the order in which they were given

4. Input and output is handled for you
5. It is a functional problem, please do not modify main()
*/

/*
To find the k-smallest elements in the array 
We will be using maximum priority queue

We will also maintain the largest element in the queue

We will add the first k elements as it is 

After that for every element we check whether that element is greater than the largest element in the priority queue or not
If it is larger then we move on
If it is smaller then the largest element then remove the largest add this no. and update the largest in the queue
At the end we are left with the k smallest elements in the array

Since we want to print them in order
We again traverse through our array
If an element is smaller than the largest in priority queue then we print it
If it is larger then we move
If it is equal then we print it 
Remove the largest 
And update the largest
This has to be done because it is possible that there are copies of this element and those copies don't have to be printed

For eg,
3 4 5 6 2 1 4
Print 4 smallest elements
Here only one 4 out of the two has to be printed
3 4 5 6 2 1 4
Print 5 smallest elements
Here both the 4s have to be printed
*/


import java.util.*;

public class KSmallestElementsInOrder {
	
	 public static void print_k_smallest_elements_in_their_original_order(int n,int k, int[] arr){
		 
		 //because we need maximum priority queue
		 PriorityQueue<Integer> P = new PriorityQueue<>(Collections.reverseOrder());
		 
		 int max = Integer.MIN_VALUE;
		 
		 for(int i=0 ; i<k && i<arr.length ; i++)
		 {
			 if(arr[i]>max)
			 {
				 max = arr[i];
			 }
			 P.add(arr[i]);
		 }
		 
		 for(int i=k ; i<arr.length ; i++)
		 {
			 int val = arr[i];
			 
			 if(val<max)
			 {
				 P.remove();
				 P.add(val);
				 max = P.peek();
			 }
		 }
		 
		 for(int i=0 ; i<arr.length ; i++)
		 {
			 if(arr[i]<max)
			 {
				 System.out.print(arr[i]+" ");
			 }
			 else if(arr[i]==max)
			 {
				 System.out.print(arr[i]+" ");
				 P.remove();
				 if(!P.isEmpty())
				 max = P.peek();
				 else
				 max = Integer.MIN_VALUE;
			 }
		 }
	 }


	 public static void main(String[] args) {

	 	 Scanner scn = new Scanner(System.in);

	 	 	 int n = scn.nextInt();
	 	 	 int k = scn.nextInt();

	 	 	 int[] arr = new int[n];
	 	 	 
	 	 	 for (int i = 0; i < n; i++) {
	 	 	 	 arr[i] = scn.nextInt();
	 	 	 }
            print_k_smallest_elements_in_their_original_order(n,k,arr);
	 }
}