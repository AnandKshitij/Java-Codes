package HashMapsAndHeaps;

/*
1.Pepman has his exam on the way. Pepman is trying really hard to clear the examinations this time. 
So, he is practicing quite often. One day while practicing he faces a problem. The problem is as follows: 
Given a string S of lower case characters, find out whether the summation of 'X' and 'Y' is even or odd, 
where X is the count of characters which occupy even positions in English alphabets and have even frequency 
in string S, and Y is the count of characters which occupy odd positions in English alphabets and have odd 
frequency in string S. Help pepman to solve this problem.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HelpPepman {
	
	 public static void helpPepman(String str)
	 {
		 HashMap<Character, Integer> H = new HashMap<>();
		 
		 for(int i=0 ; i<str.length() ; i++)
		 {
			 char ch = str.charAt(i);
			 
			 if(!H.containsKey(ch))
			 {
				 H.put(ch,1);
			 }
			 else
			 {
				 H.put(ch,H.get(ch)+1);
			 }
		 }
		 
		 int X = 0;
		 int Y = 0;
		 
		 for(char ch : H.keySet())
		 {
			 int pos = ch-'a'+1;
			 if(pos%2==0)
			 {
				 if(H.get(ch)%2==0)
				 {
					 X++;
				 }
			 }
			 else
			 {
				 if(H.get(ch)%2!=0)
				 {
					 Y++;
				 }
			 }
		 }
		 
		 if((X+Y)%2==0)
		 {
			 System.out.println("EVEN");
		 }
		 else
		 {
			 System.out.println("ODD");
		 }
	 }

	 public static void main(String[] args) {
	 	 
		 Scanner s = new Scanner(System.in);
		 String str = s.next();
		 helpPepman(str);
	 }
}