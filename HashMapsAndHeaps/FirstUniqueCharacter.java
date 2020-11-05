package HashMapsAndHeaps;

/*
1. You will be given a String s
2. You need to return the index of first unique character of this string
3. Input is handled for you
4. Output is handled for you
5. It is a functional problem ,please do not modify main()
 */

import java.util.*;

public class FirstUniqueCharacter {
	
	public static int getIndex(String str)
	{
		HashMap<Character, Integer> H = new HashMap<>();
		
		for(int i=0; i<str.length(); i++)
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
		
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			
			if(H.get(ch)==1)
			{
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(getIndex(str));
	}
}
