package Stacks;

import java.util.Scanner;

public class Mustang{

	 public static int mustangTour(int[] petrol,int[] dist){
	 // Write your code here
		 int i=0;
		 int j=0;
		 
		 int N = petrol.length;
		 
		 int spare = 0;
		 int result = 0;
		 
		 boolean flag = false;
		 
		 while(!((i<=j&&spare<0) || (i==j&&flag)))
		 {
			 if(i==j)
			 {
				 flag = true;
			 }
			 int pt = petrol[j];
			 int dt = dist[j];
			 
			 spare += pt-dt;
			 

			 j++;
			 j = j%N;
			 
			 if(spare<0)
			 {
				 if(j<=i && flag)
				 {
					 result = -1;
					 break;
				 }
				 i=j;
				 flag = false;
				 spare=0;
			 }
			 else
			 {
				 if(i==j)
				 {
					 result = i;
					 break;
				 }
				 else
				 {
					 continue;
				 }
			 }
		 }
		 
		 return result;
		 
	 }
	 
	 public static void main(String[] args) 
	 {
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int[] petrol=new int[n];int[] dist=new int[n];
	 	 for(int i=0;i<n;i++)petrol[i]=sc.nextInt();
	 	 for(int i=0;i<n;i++)dist[i]=sc.nextInt();
	 	 System.out.println(mustangTour(petrol,dist));
	 }
	 
}
