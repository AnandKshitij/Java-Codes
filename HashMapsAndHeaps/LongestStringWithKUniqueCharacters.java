package HashMapsAndHeaps;

/*
1.Given a string you need to print the size of the longest possible substring that has exactly k unique characters.
2.If there is no possible substring print -1.
3.Example
For the string aabacbebebe and k = 3 the substring will be cbebebe with length 7.
4.You have to complete the function print() which should print the size of the longest substring
having 'k' unique characters.
 */


import java.util.*;

public class LongestStringWithKUniqueCharacters {
	
	public static int getLongestLength(String str , int k)
	{
		HashMap<Character,Integer> H = new HashMap<>();
		int maxLength = 0;
		
		int start = -1;
		int end = 0;
	
		while(end<str.length() && H.size()<k+1)
		{
			char ch = str.charAt(end);
			
			if(!H.containsKey(ch))
			{
				H.put(ch,1);
			}
			else
			{
				H.put(ch,H.get(ch)+1);
			}
			end++;
		}
		
		if(H.size()<=k)
		{
			if(H.size()<k)
			{
				return 0;
			}
			else if(H.size()==k)
			{
				return str.length();
			}
		}
		
		boolean isValid = false;
		
		int length = end-start-2;
		if(length>maxLength)
		{
			maxLength = length;
		}
		
		while(start<str.length() && end<str.length())
		{
			if(!isValid)
			{
				char ch = str.charAt(start+1);
				H.put(ch,H.get(ch)-1);
				if(H.get(ch)==0)
				{
					H.remove(ch);
				}
				if(H.size()==k)
				{
					isValid = true;
				}
				start++;
				int l = end-start-1;
				if(l>maxLength)
				{
					maxLength = l;
				}
			}
			
			if(isValid)
			{
				char ch = str.charAt(end);
				end++;
				
				if(!H.containsKey(ch))
				{
					H.put(ch,1);
				}
				else
				{
					H.put(ch,H.get(ch)+1);
				}
				
				if(H.size()>k)
				{
					isValid = false;
				}
				else
				{
					int l = end-start-1;
					if(l>maxLength)
					{
						maxLength = l;
					}
				}
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		String Str = s.next();
		int k = s.nextInt();
		
		System.out.println(getLongestLength(Str,k));
	}

}
