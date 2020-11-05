package HashMapsAndHeaps;

/*

1.Given two lists A and B, and B is an anagram of A.
2.B is an anagram of A means B is made by randomizing the order of the elements in A.
3.We want to find an index mapping P, from A to B.
4.A mapping P[i] = j means the ith element in A appears in B at index j.
5.You have to complete anagramMappings() which should return the array P.

Sample Input
5
A = 12 28 46 32 50
B = 50 12 32 46 28

Sample Output
1 4 3 2 0

For repeated elements the first element will have the 1st index of that element

Sample Input
6
A = 12 28 46 32 12 50 
B = 50 12 32 12 46 28

Sample Output
1 5 4 2 3 0
*/


import java.util.*;

public class AnagramMapping {

	 public static int[] anagramMappings(int[] A, int[] B) 
	 {
		 HashMap<Integer, Queue<Integer>> H = new HashMap<>();
		 
		 for(int i=0; i<B.length; i++)
		 {
			 int num = B[i];
			 
			 if(!H.containsKey(num))
			 {
				 Queue<Integer> Q = new LinkedList<>();
				 Q.add(i);
				 H.put(num,Q);
			 }
			 else
			 {
				 Queue<Integer> Q = H.get(num);
				 Q.add(i);
				 H.put(num,Q);
			 }
		 }
		 
		 
		 int result[] = new int [A.length];
		 
		 for(int i=0; i<A.length; i++)
		 {
			 int num = A[i];
			 Queue<Integer> Q = H.get(num);
			 result[i] = Q.remove();
			 H.put(num,Q);
		 }
		 
		 return result;
	 }
	 
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 int[] a = new int[n];
	 	 int[] b = new int[n];
	 	 for (int i = 0; i < a.length; i++) {
	 	 	 a[i] = s.nextInt();
	 	 }
	 	 for (int j = 0; j < b.length; j++) {
	 	 	 b[j] = s.nextInt();
	 	 }
	 	 int[] res = anagramMappings(a, b);
	 	 for (int j = 0; j < res.length; j++) {
	 	 	 System.out.print(res[j] + " ");
	 	 }

	 }

}