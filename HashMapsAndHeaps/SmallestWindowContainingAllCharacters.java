package HashMapsAndHeaps;

/*
1. Given a string S and text R. Output the smallest window in the string S having all characters of the text R. 
2. Both the string S and text R contains lower case English alphabets.
*/

/*

Sample Input
timetopractice
toc
Sample Output
toprac

First we will make a hash map of the 2nd string

Then we will maintain a window using start and end
We will also maintain bestStart, bestEnd and matchCount

If match count becomes equal to length of 2nd string then isValid becomes true
and we increment start to find a smaller window 
Else we increment end to find a valid window

*/


import java.util.*;

public class SmallestWindowContainingAllCharacters {

	public static void getSmallestSubstring(String S, String P)
	{
		HashMap<Character,Integer> pMap = new HashMap<>();
		
		for (int i = 0; i < P.length() ; i++) 
		{
			char ch = P.charAt(i);
			
			if(!pMap.containsKey(ch))
			{
				pMap.put(ch,1);
			}
			else
			{
				pMap.put(ch,pMap.get(ch)+1);
			}
		}
		
		HashMap<Character,Integer> window = new HashMap<>();
		
		int matchCount = 0;
		
		int bestStart = 0;
		int bestEnd = 0;
		
		for(int i=0 ; i<S.length() ; i++)
		{
			char ch = S.charAt(i);
			int freq = 0;
			
			if(!window.containsKey(ch))
			{
				window.put(ch,1);
				freq = 1;
			}
			else
			{
				freq = window.get(ch)+1;
				window.put(ch,freq);
			}
			
			if(pMap.containsKey(ch))
			{
				int pFreq = pMap.get(ch);
				if(freq<=pFreq)
				{
					matchCount++;
					if(matchCount==P.length())
					{
						bestEnd = i+1;
						break ;
					}
				}
			}
		}
		
		if(matchCount!=P.length())
		{
			System.out.println(-1);
			return ;
		}
		
		int start = bestStart;
		int end = bestEnd;
		boolean isValid = true;
		
		while(end<=S.length())
		{
			if(isValid)
			{
				char ch = S.charAt(start);
				start++;
				
				int pFreq = 0;
				if(pMap.containsKey(ch))
				{
					pFreq = pMap.get(ch);
				}
				
				int freq = window.get(ch);
				
				window.put(ch,window.get(ch)-1);
				
				if(window.get(ch)==0)
				{
					window.remove(ch);
				}
				
				if(freq<=pFreq)
				{
					matchCount--;
					isValid = false;
				}
				else
				{
					if((end-start)<(bestEnd-bestStart))
					{
						bestEnd = end;
						bestStart = start;
					}
				}
			}
			
			
			else
			{
				if(end==S.length())
				{
					break ;
				}
				char ch = S.charAt(end);
				end++;
				
				int freq = 0;
				if(!window.containsKey(ch))
				{
					window.put(ch,1);
					freq = 1;
				}
				else
				{
					freq = window.get(ch)+1;
					window.put(ch,freq);
				}
				
				int pFreq = 0;
				
				if(pMap.containsKey(ch))
				{
					pFreq = pMap.get(ch);
				}
				
				if(freq<=pFreq)
				{
					matchCount++;
				}
				
				if(matchCount==P.length())
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
		
		for(int i=bestStart; i<bestEnd; i++)
		{
			System.out.print(S.charAt(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		String T = s.next();
		getSmallestSubstring(S,T);
	}
}
