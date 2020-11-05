package Array;

import java.util.Scanner;

public class TinyBigTiny {
	
	//left element is smallest
	//middle element is largest
	//right element is intermediate
	//we have to find whether such a sequence exists or not
	 public static boolean find132pattern(int[] num) {
  	 // Write your code here
		 
		 for(int i=0 ; i<num.length-1 ; i++)
		 {
			 int val1 = num[i];
			 int val2 = num[i+1];
			 
			 if(val1<val2)
			 {
				 if(i+2<num.length)
				 {
					 int val3 = num[i+2];
					 if(val3<val2 && val3>val1)
					 {
						 return true;
					 }
				 }
			 }
		 }
		 
		 return false;
	 }


	 //Dont make changes here
	 public static void main(String[] args) {
	 
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int[] A=new int[n];
	 	 for(int i=0;i<n;i++)A[i]=sc.nextInt();
	 	 System.out.println(find132pattern(A));
	 }

}

