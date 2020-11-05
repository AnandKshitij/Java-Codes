package HashMapsAndHeaps;

/*
Question
1.Given a string s
2.Find out the count of all contiguous substrings whose starting and ending are same character.
3.Note: string contains lower case English alphabets only.
4.You have to complete the function count() which should return the count of all such substrings.
 */

/*
Sample Input
abcab
Sample Output
7

Strings are-
a
abca
b 
bcab
c
a
b

So every character itself starts and ends with same character
So we will calculate no. of strings with more than one character starting and ending with the same character and we will add
length of the string to it
 */


import java.util.Scanner;
import java.util.HashMap;

public class SubstringsWithSameFirstAndLastCharacter {

	 public static int count(String str) {
		 
		 int count = str.length();
		 
		 HashMap<Character,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<str.length(); i++)
		 {
			 char ch = str.charAt(i);
			 
			 if(!H.containsKey(ch))
			 {
				 H.put(ch,1);
			 }
			 else
			 {
				 count += H.get(ch);
				 H.put(ch,H.get(ch)+1);
			 }
		 }
		 
		 return count;

	 }

	 //Don't write your code here
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String str = scn.next();
	 	 int ans = count(str);
	 	 System.out.println(ans);
	 }

}