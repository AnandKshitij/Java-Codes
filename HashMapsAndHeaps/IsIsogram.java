package HashMapsAndHeaps;

/*
1.Given a string S of lower case alphabets.
2.Check if it is isogram or not.
3.An Isogram is a string in which no letter occurs more than once.
4.Your task is to complete the function isIsogram() which return true if the string is Isogram and false if it is not.
*/

import java.util.*;

public class IsIsogram {
	
	public static boolean isIsogram(String str)
	{
		HashSet<Character> H = new HashSet<>();
		
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			
			if(!H.contains(ch))
			{
				H.add(ch);
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(isIsogram(str));
	}

}
