package HashMapsAndHeaps;

/*
1. Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string 
at least one time.

EXAMPLE
"aabcbcdbca", then the result would be 4 as of the smallest window will be "dbca".
*/

/*
We will first make the hash set of the elements of the elements present in the string
We will put start at 0 and end at 0 initially
Till we don't get the valid string we increment end
Once we get the valid string we try to find a smaller valid string so we increment start
*/


import java.util.*;
public class SmallestDistinctWindow {
	
	public static int getMinLength(String str)
	{
		HashSet<Character> set = new HashSet<>();
		
		for (int i = 0; i <str.length(); i++) 
		{
			char ch = str.charAt(i);
			
			if(!set.contains(ch))
			{
				set.add(ch);
			}
		}
		
		int length = set.size();
		
		HashMap<Character,Integer> H = new HashMap<>();
		int bestStart = 0;
		int bestEnd = 0;
		
		for (int i = 0; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			
			if(!H.containsKey(ch))
			{
				H.put(ch,1);
				if(H.size()==length)
				{
					bestStart = 0;
					bestEnd = i+1;
					break ;
				}
			}
			else
			{
				H.put(ch,H.get(ch)+1);
			}
		}
		
		int start = 0;
		int end = bestEnd;
		
		boolean isValid = true;
		
		//we have to take the loop till str.length()
		//this is because after acquiring the last character our loop reaches str.length()
		//now after that suppose the string becomes valid 
		//now we can shorten the string by moving start
		//this will reduce the length of string
		//but if we terminate the loop then start cannot be moved
		//we also have to take care that we do not access end
		//so we enter a break statement in the condition in which end is moving
		//so when end==str.length() then only the element at start can be removed
		//element at end cannot be acquired
		
		while(end<=str.length())
		{
			if(isValid)
			{
				char ch = str.charAt(start);
				start++;
				if(H.containsKey(ch))
				{
					H.put(ch,H.get(ch)-1);
					if(H.get(ch)==0)
					{
						H.remove(ch);
					}
					if(H.size()==length)
					{
						if((end-start)<(bestEnd-bestStart))
						{
							bestEnd = end;
							bestStart = start;
						}
					}
					else
					{
						isValid = false;
					}
				}
			}
			else
			{
				if(end>=str.length())
				{
					break;
				}
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
				
				if(H.size()==length)
				{
					isValid = true;
					if((end-start)<(bestEnd-bestStart))
					{
						bestEnd = end;
						bestStart = start;
					}
				}
			}
		}
		
		int minLength = bestEnd-bestStart;
		return minLength;
	
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(getMinLength(str));
	}

}
