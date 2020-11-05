package HashMapsAndHeaps;

/*
1.Given an array A of strings made only from lower case letters.
2.You have to print a list of all characters that show up in all strings
within the list (including duplicates).
3.For example, if a character occurs 3 times in all strings but not 4 times,
you need to include that character three times in the final answer.
4.You have to complete commonChars() function which should print the list.
5.You can print your answer in any order.
 */


import java.util.*;

public class CommonCharacters{

	 public static ArrayList<String> commonChars(String[] A) {
	 
		 String main = A[0];
		 
		 HashMap<Character,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<main.length(); i++)
		 {
			 char ch = main.charAt(i);
			 
			 if(!H.containsKey(ch))
			 {
				 H.put(ch,1);
			 }
			 else
			 {
				 H.put(ch,H.get(ch)+1);
			 }
		 }
		 
		// System.out.println(H);
		 
		 for(int j=1; j<A.length; j++)
		 {
			 String temp = A[j];
			 HashMap<Character,Integer> curr = new HashMap<>();
			 
			 for(int i=0; i<temp.length(); i++)
			 {
				 char ch = temp.charAt(i);
				 
				 if(!curr.containsKey(ch))
				 {
					 curr.put(ch,1);
				 }
				 else
				 {
					 curr.put(ch,curr.get(ch)+1);
				 }
			 }
			 
			// System.out.println(curr);
			 
			 
			 for(char ch : H.keySet())
			 {
				 int freq = H.get(ch);
				 
				 int currFreq = 0;
				 
				 if(curr.containsKey(ch))
				 {
					 currFreq = curr.get(ch);
				 }
				 
				 if(currFreq<freq)
				 {
					 freq = currFreq;
				 }
				 
				 H.put(ch,freq);
			 }
			 
			// System.out.println(H);
			 
		 }
		 
		 ArrayList<String> result = new ArrayList<>();
		 
		 for(char ch : H.keySet())
		 {
			 int freq = H.get(ch);
			 
			 if(freq!=0)
			 {
				 for(int i=0; i<freq; i++)
				 {
					 String str = ch+"";
					 result.add(str);
				 }
			 }
		 }
		 return result;
	 }
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int n = Integer.parseInt(s.nextLine());
	 	 String[] A = new String[n];
	 	 for (int i = 0; i < A.length; i++) {
	 	 	 A[i] = s.nextLine();
	 	 }

	 	 ArrayList<String> res = commonChars(A);
	 	 Collections.sort(res);
	 	 System.out.println(res);

	 }

}