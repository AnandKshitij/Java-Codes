package HashMapsAndHeaps;


/*
1.Given a string, find the length of the longest substring without repeating characters.
2.You have to complete the function lenghtofLongestSubstring which should return length of the
longest substring without repeating characters.
3.Example -For string abcabcbb the answer is 3 i.e abc

Sample Input
abcabcbb
Sample Output
3
 */

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubArrayWithUniqueCharacters
{
	 public static int lengthOfLongestSubstring(String s) 
	 {
		int maxLength = 0;
		HashSet<Character> H = new HashSet<>();
		
		int start = 0;
		int end = 1;
		boolean isValid = true;
		H.add(s.charAt(0));
		
		while(end<=s.length())
		{
			if(!isValid)
			{
				char ch = s.charAt(start);
				H.remove(ch);
				start++;
				
				if(ch==s.charAt(end))
				{
					isValid = true;
					if(end-start>maxLength)
					{
						maxLength = end-start;
					}
				}
			}
			else
			{
				if(end==s.length())
				{
					break;
				}
				char ch = s.charAt(end);
				
				if(!H.contains(ch))
				{
					H.add(ch);
					end++;
					if((end-start)>maxLength)
					{
						maxLength = end-start;
					}
				}
				else
				{
					isValid = false;
				}
			}
		}
		
		return maxLength;
		
	 }
	 
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 String str = s.next();
	 	 System.out.println(lengthOfLongestSubstring(str));

	 }

}