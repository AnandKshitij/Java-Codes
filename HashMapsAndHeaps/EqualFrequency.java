package HashMapsAndHeaps;

/*
1.Given a string s which contains lower alphabetic characters.
2.The task is to check if its possible to remove at most one character from this 
string in such a way that frequency of each distinct character becomes same in the string.
3.You have to complete the function isFrequencyEqual() which return true or false
 */

/*
Here we will first make a hash map of the frequencies
We want the frequency of all the characters equal after at most one removal

So it can be true in three cases-
b3 c3 d4(one character has high frequency)
b3 c3 c3(all characters have equal frequency)
b3 c3 d1(one character has frequency one and all other characters have same frequency)

So to check this after we have made the key vs frequency map
We will make a hash map of frequencies vs frequencies of these frequencies
If it has more than two values then it is false
If it has two values then we need to check
If one frequency is 1
Then we need to check the frequency of frequency 1
It should be 1
Else the higher frequency should have the frequency 1
 */


import java.util.*;
import java.io.*;

public class EqualFrequency {


	 public static boolean isFrequencyEqual(String str) {
	 		
		 HashMap<Character,Integer> H = new HashMap<>();
		 
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
		 
		 HashMap<Integer,Integer> freq = new HashMap<>();
		 
		 for(char ch : H.keySet())
		 {
			 int f = H.get(ch);
			 
			 if(!freq.containsKey(f))
			 {
				 freq.put(f,1);
			 }
			 else
			 {
				 freq.put(f,freq.get(f)+1);
			 }
		 }
		 
		 if(freq.size()>2)
		 {
			 return false;
		 }
		 if(freq.size()==1)
		 {
			 return true;
		 }
		 
		 int frequencies[] = new int [2];
		 
		 int j=0;
		 for(int i : freq.keySet())
		 {
			 frequencies[j] = i;
			 j++;
		 }
		 
		 if(frequencies[0]>frequencies[1])
		 {
			 int temp = frequencies[0];
			 frequencies[0] = frequencies[1];
			 temp = frequencies[1];
		 }
		
		 if(freq.get(frequencies[0])==1)
		 {
			 return true;
		 }
		
		 if(frequencies[1]-frequencies[0]==1)
		 {
			 if(freq.get(frequencies[0])==1 || freq.get(frequencies[1])==1)
			 {
				 return true;
			 }
		 }
		 
		 return false;
	 }

	 public static void main(String[] args) throws IOException {
	 	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	 String s = br.readLine();
	 	 boolean bl = isFrequencyEqual(s);
	 	 System.out.println(bl);
	 }
}
