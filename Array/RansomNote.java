package Array;

/*
1.Given an arbitrary ransom note string and another string containing letters from all the magazines
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

2.Each letter in the magazine string can only be used once in your ransom note.

3.Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/


import java.util.Scanner;
import java.util.*;

public class RansomNote {
	
	 public static boolean canConstruct(String rans, String magazine) {
	
		 HashMap<Character,Integer> H = new HashMap<>();
		 
		 for (int i = 0; i <magazine.length(); i++) {
			char ch = magazine.charAt(i);
			
			if(!H.containsKey(ch)) {
				H.put(ch,1);
			}
			else {
				H.put(ch,H.get(ch)+1);
			}
		}
		 
		for(int i=0; i<rans.length(); i++) {
			char ch = rans.charAt(i);
			
			if(!H.containsKey(ch)) {
				return false;
			}
			else {
				H.put(ch,H.get(ch)-1);
				if(H.get(ch)==0) {
					H.remove(ch);
				}
			}
		}
		
		return true;
		 
	 }
	 
	 
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s = scn.next();
	 	 String t = scn.next();
	 	 System.out.print(canConstruct(s, t));

	 }

}