package HashMapsAndHeaps;

import java.util.*;

public class CompletingTask{

	 public static void completeTask(int n, int m, int[] compl) {
	 	 
	 	 HashSet<Integer> H = new HashSet<>();
	 	 
	 	 for(int i=1 ; i<=n ; i++)
	 	 {
	 	     H.add(i);
	 	 }
	 	 
	 	 for(int i=0 ; i<compl.length ; i++)
	 	 {
	 		 int val = compl[i];
	 		 H.remove(val);
	 	 }
	 	 
	 	 
	 	 boolean tanya = true;
	 	 
	 	 ArrayList<Integer> T = new ArrayList<>();
	 	 ArrayList<Integer> M = new ArrayList<>();
	 	 
	 	 for(int i=1 ; i<=n ; i++)
	 	 {
	 		 if(H.contains(i))
	 		 {
	 			 if(tanya)
	 			 {
	 				 T.add(i);
	 			 }
	 			 else
	 			 {
	 				 M.add(i);
	 			 }
	 			 tanya = !tanya;
	 		 }
	 	 }
	 	 
	 	 for(int i=0 ; i<T.size() ; i++)
	 	 {
	 		 System.out.print(T.get(i)+" ");	 
	 	 }
	 	 System.out.println();
	 	 
	 	for(int i=0 ; i<M.size() ; i++)
	 	 {
	 		 System.out.print(M.get(i)+" ");	 
	 	 }
	 	 System.out.println();
	 	 
	 }
	 //Don't make changes here
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 int n = scn.nextInt();
	 	 int m = scn.nextInt();
	 	 int[] num = new int[m];
	 	 for (int i = 0; i < m; i++) {
	 	 	 num[i] = scn.nextInt();
	 	 }
	 	 completeTask(n, m, num);
	 }
}