package HashMapsAndHeaps;

/*
1.If the number of distinct characters in one's user name is odd,
then the user is a male, otherwise a female.
2.You are given the string that denotes the user name.
3.You have to complete function ifFakeProfile() to print whether a person is male or female.
4.Your function should print HE! if the user is male else SHE! if she is female
(Ignore the vowels).
*/


import java.util.*;
import java.io.*;

public class FakeProfile {

	 public static void findIfFake(String s) 
	 {
		 HashSet<Character> H = new HashSet<>();
		 
		 for(int i=0; i<s.length(); i++)
		 {
			 char ch  = s.charAt(i);
			 
			 if(ch=='a' || ch=='e' || ch=='i' ||ch=='o' || ch=='u')
			 {
				 continue;
			 }
			 if(!H.contains(ch))
			 {
				 H.add(ch);
			 }
		 }
		 
		 if(H.size()%2!=0)
		 {
			 System.out.println("HE!");
		 }
		 else
		 {
			 System.out.println("SHE!");
		 }
	 }
	 
	 public static void main(String[] args) throws IOException 
	 {
	 	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	 findIfFake(br.readLine());
	 }
}