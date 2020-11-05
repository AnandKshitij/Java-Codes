package HashMapsAndHeaps;

/*
1. Given an array. 
2. Return the sum of lengths of contiguous sub strings having all distinct elements.
 */

import java.util.Scanner;
import java.util.*;

public class SumOfLengthsOfSubstringWithNoDuplicacy {
	
	
	public static int getLength(String str)
	{
		int start = 0;
		int end = 1;
		 
		int length = 0;
		
		while(start<str.length() && end<=str.length())
		{
			HashSet<Character> H = new HashSet<>();
			H.add(str.charAt(start));
			
			while(end<str.length() && !H.contains(str.charAt(end)))
			{
				H.add(str.charAt(end));
				end++;
			}
			
			int n = end-start;
			length += (n*(n+1))/2;
			start++;
			end = start+1;
		}
		
		return length;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		int length = getLength(str);
		System.out.println(length);
	}

}