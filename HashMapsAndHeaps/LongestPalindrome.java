package HashMapsAndHeaps;

/*

1.Given a string which consists of lowercase or uppercase letters
2.Find the length of the longest palindromes that can be built with those letters.
3.Your taks is to complete the function longestPalindrome() which should return the
the length of the longest palindromes that can be built with those letters.
4.This is case sensitive, for example "Aa" is not considered a palindrome here.
5.Example For string abccccdd the output is 7 as One longest palindrome
that can be built is "dccaccd", whose length is 7.

Sample Input
abccccdd
Sample Output
7

*/

import java.util.*;

public class LongestPalindrome
{
	 public static int longestPalindrome(String s) 
	 {
		HashMap<Character,Integer> H = new HashMap<>();
		
		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if(!H.containsKey(ch))
			{
				H.put(ch,1);
			}
			else
			{
				H.put(ch,H.get(ch)+1);
			}
		}
		
		int length = 0;
		boolean printAll = true;
		
		for(char ch : H.keySet())
		{
			int freq = H.get(ch);
			
			if(freq%2==0)
			{
				length += freq;
			}
			else
			{
				if(printAll)
				{
					length += freq;
					printAll = false;
				}
				else
				{
					length += freq-1;
				}
			}
		}
		
		return length;
	 }

	 public static void main(String[] args) 
	 {
		 Scanner s = new Scanner(System.in);
	 	 String str = s.next();
	 	 System.out.println(longestPalindrome(str));
	 }
}
