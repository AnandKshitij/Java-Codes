package HashMapsAndHeaps;

/*
1.Given an array of N integers.
2.Your have to check whether an arithmetic progression can be formed using all the elements. 
3.Your task is to complete the function checkAP() that should return true if they form an AP and false if they don't.
4.Any sequence is said to be in AP if there exists a common difference between all the consecutive elements.
5.For example a,b,c are said to be in AP if b-a=c-b.
*/

/*
First we will find the minimum and the maximum values in the array
maximum = minimum + (n-1)*d
d = (maximum-minimum)/(n-1)

Now we will start with minimum and with the help of hash set we will check if all the elements with difference d 
till maximum exist or not

We don't need hash map
This is because we have calculated n according to max, min and n
If any element is repeated then d will change
 */


import java.util.*;

public class IsAP {

	 public static boolean checkAP(int[] arr) {
	 	 
		 HashSet<Integer> H = new HashSet<>();
		 
		 int max = Integer.MIN_VALUE;
		 int min = Integer.MAX_VALUE;
		 
		 for(int i=0 ; i<arr.length ; i++)
		 {
			 int val = arr[i];
			 
			 if(val<min)
			 {
				 min = val;
			 }
			 if(val>max)
			 {
				 max = val;
			 }
			 
			 if(!H.contains(val))
			 {
				 H.add(val);
			 }
		 }
		 
		 int d = (max-min)/(arr.length-1);
		 
		 while(min<max)
		 {
			 if(!H.contains(min))
			 {
				 return false;
			 }
			 min = min+d;
		 }
		 
		 return true;
	 }


	 //Don't make any changes here
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int[] num = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 num[i] = scn.nextInt();
	 	 	 }
	 	 	 boolean x = checkAP(num);
	 	 	 System.out.println(x);
	 }
}