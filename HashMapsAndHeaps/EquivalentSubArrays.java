package HashMapsAndHeaps;

/*
1. You will be given an array
2. You need to find count of sub arrays that have the same number of distinct elements as the main array
4. Return this count

Sample Input
8
4 4 2 2 2 3 4 1

Sample Output
5
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EquivalentSubArrays {
	
	 public static int val(int[] arr) {
		 
		 int count = 0;
		 
		 HashSet<Integer> temp = new HashSet<>();
		 
		 for(int i=0; i<arr.length; i++) {
			 temp.add(arr[i]);
		 }
		 
		 int distinct = temp.size();
		 
		 int start = 0;
		 int end = 1;
		 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 H.put(arr[0],1);
		 boolean isValid = false;
		 
		 while(end<=arr.length)
		 {
			 if(!isValid){
				 
				 if(end==arr.length){
					 break ;
				 }
				 int val = arr[end];
				 end++;
				 
				 if(!H.containsKey(val)){
					 H.put(val,1);
				 }
				 else {
					 H.put(val,H.get(val)+1);
				 }
				 
				 if(H.size()==distinct){
					 count += arr.length-end+1;
					 isValid = true;
				 }
				 
			 }
			 
			 else {
				 int val = arr[start];
				 start++;
				 
				 H.put(val,H.get(val)-1);
				 
				 if(H.get(val)==0){
					 H.remove(val);
				 }
				 
				 if(H.size()<distinct){
					 isValid = false;
				 }
				 else {
					 count += arr.length-end+1;
				 }
				 
			 }
			 
		 }
		 
		 return count;
		 
	 }

	 public static void main(String[] args) {
		 
	 	 	Scanner scn=new Scanner(System.in);
	 	 	 int n=scn.nextInt();
	 	 	 int []arr=new int[n];
	 	 	 for(int  i=0;i<n;i++){
	 	 	 	 arr[i]=scn.nextInt();
	 	 	 }
	 	 	 System.out.println(val(arr));
	 }
	 
}
