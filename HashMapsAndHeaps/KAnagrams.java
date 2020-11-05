package HashMapsAndHeaps;

/*
1.Given two strings of lower case alphabets and a value K.
2.Your task is to complete the given function areKAnagrams() which tells if two strings are K-anagrams of each other or not.
Two strings are called K-anagrams if both of the below conditions are true.

a. Both have same number of characters.
b. Two strings can become anagram by changing at most K characters in a string.
*/

/*
Sample Input
fodr gork
2

Sample Output
true

First draw the hash map for the first string 
f -> 1
o -> 1
d -> 1
r -> 1

Now traverse the other string and reduce the frequency of the variables in Hash map
f -> 1
o -> 0
d -> 1
r -> 0

This means that f and d are extra in string S
Also we know that g and k are extra in string P

So we can replace f with g and d with k to make the strings anagram
So replaces required to make the string anagram are 2
If k given to us is greater than or equal to 2 then we return true
Else we return false

We just have to see the sum of positive values in S because that gives us the characters which are extra in S


 */

import java.util.*;

public class KAnagrams {
	
	public static boolean isKAnagram(String S, String P, int k)
	{
		HashMap<Character, Integer> H = new HashMap<>();
		
		for(int i=0 ; i<S.length() ; i++)
		{
			char ch = S.charAt(i);
			
			if(!H.containsKey(ch))
			{
				H.put(ch,1);
			}
			else
			{
				H.put(ch,H.get(ch)+1);
			}
		}
		
		for(int i=0 ; i<P.length() ; i++)
		{
			char ch = P.charAt(i);
			
			if(H.containsKey(ch))
			{
				H.put(ch,H.get(ch)-1);
			}
		}
		
		int replace = 0;
		
		for(char i : H.keySet())
		{
			int freq = H.get(i);
			
			if(freq>0)
			{
				replace += freq;
			}
		}
		
		if(replace>k)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		String A = s.next();
		String B = s.next();
		int k = s.nextInt();
		
		System.out.println(isKAnagram(A,B,k));
		
	}
}
