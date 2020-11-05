package HashMapsAndHeaps;

/*
1. You will be given two strings s and t
2. You need to check if they are isomorphic.
3. Two strings are isomorphic if we can map the characters of string 1 to characters of string 2.
4. Return true or false.
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main()

Sample Input
paper
title
Sample Output
true
*/


import java.util.*;

public class IsomorphicStrings
{
	public static boolean isIsomorphic(String s, String t) 
	{
		HashMap<Character,Character> StoT = new HashMap<>();
		HashMap<Character,Character> TtoS = new HashMap<>();
		
		if(s.length()!=t.length())
		{
			return false;
		}
		
		for(int i=0; i<s.length(); i++)
		{
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			
			if(!StoT.containsKey(ch1))
			{
				StoT.put(ch1,ch2);
			}
			else
			{
				char temp = StoT.get(ch1);
				if(temp!=ch2)
				{
					return false;
				}
			}
			
			if(!TtoS.containsKey(ch2))
			{
				StoT.put(ch2,ch1);
			}
			else
			{
				char temp = TtoS.get(ch2);
				if(temp!=ch1)
				{
					return false;
				}
			}
			
			
		}
		
		return true;
 	}
	 
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String A= scn.next();
        String B= scn.next();
        System.out.print(isIsomorphic(A, B));
    }
    
}