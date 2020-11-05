package HashMapsAndHeaps;

/*
1. A vendor has prepared some sweets for a festival in his neighborhood to make a good business that day
2. He/she has prepared N sweets which can be at most of 32 different types.On the festival day he/she finds K customers at 
her shop.He/she wants to sell all his/her sweets but (any) customer won't take the same type of sweet more than 2 pieces.
3. You have to find out if he/she would be able to sell all the sweets,return your answer as true or false.
4.The input consists of n ,indicating the number of sweets prepared, it is followed by series of integers ,where each integer 
i represents the ith type of sweet,next input represents K ,the number of customers
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main()

Input Format
 n:total number of sweets
input of n sweets
k:number of customers
Input is handled for you.
*/

/*
In this question we can only give a customer maximum two sweets of one kind
No. of customers are k
So no sweet should have frequency more than 2*k
 */

import java.util.*;

public class SweetsFreq {

	 public static boolean sweetandfestival(int n, int[] sweets, int k) {
		 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 int maxFreq = 0;
		 
		 for(int i=0 ; i<sweets.length ; i++)
		 {
			 int val = sweets[i];
			 
			 int freq = 0;
			 
			 if(!H.containsKey(val))
			 {
				 H.put(val,1);
				 freq = 1;
			 }
			 else
			 {
				 freq = H.get(val)+1;
				 H.put(val,freq);
			 }
			 
			 if(freq>maxFreq)
			 {
				 maxFreq = freq;
			 }
		 }
		 
		 if(maxFreq>2*k)
		 {
			 return false;
		 }
		 return true;
	 }


	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);

	 	 int n = scn.nextInt();
	 	 int[] num = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 num[i] = scn.nextInt();
	 	 }
	 	 int k = scn.nextInt();

	 	 boolean x = sweetandfestival(n, num, k);
	 	 if (x == true) {
	 	 	 System.out.println("1");
	 	 } else {
	 	 	 System.out.println("0");
	 	 }

	 }

}