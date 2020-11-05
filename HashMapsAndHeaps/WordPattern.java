package HashMapsAndHeaps;

/*
1. You will be given a pattern string and a words string 
2. You need to check if the words follow the exact order as given in pattern string
3. Return true if words follow the order, else false
*/


import java.util.*;

public class WordPattern {

	 public static void main(String[] args) {
	 	 Scanner scn= new Scanner(System.in);
	 	 String pattern= scn.nextLine();
	 	 String str= scn.nextLine();
	 	 System.out.println(wordPattern(pattern,str));
	 }
   	 
	 static Boolean wordPattern(String pattern, String str) {    
	 
		 String[] arr = str.split(" ");
		 
		 HashMap<Character,String> H1 = new HashMap<>();
		 HashMap<String,Character> H2 = new HashMap<>();
		 
		 if(pattern.length()!=arr.length)
		 {
			 return false;
		 }
		 
		 for(int i=0; i<pattern.length(); i++)
		 {
			 char ch = pattern.charAt(i);
			 String S = arr[i];
			 
			 if(H1.containsKey(ch)){
				 if(!(H1.get(ch)).equals(S))
				 {
					 return false;
				 }
			 }
			 else {
				 H1.put(ch,S);
			 }
			 
			 if(H2.containsKey(S)){
				 if(H2.get(S)!=ch)
				 {
					 return false;
				 }
			 }
			 else {
				 H2.put(S,ch);
			 }
			 
			 
		 }
		 return true;
	 }
	 
}
