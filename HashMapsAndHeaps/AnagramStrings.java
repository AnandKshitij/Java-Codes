package HashMapsAndHeaps;

/*

1. You will be given two strings s and p which contains only lower case English letters.
2. You have to find all the start indices of p's anagram in s.
3. An anagram of string is another string that contains same characters,only the order of characters 
can be different.For example,"abc" and "bac" are anagram of each other.
4. Return your answer as ArrayList of Integer. 
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main().

Example-
S = b a d c a b a c d b b c a
P = a b b c d a
 */

/*
To solve this problem we will first see the length of string P
This will be the length of our window in S

We will make to hash maps

First hash map we will have all the characters in P with their frequencies
a -> 2
b -> 2
c -> 1
d -> 1

Now we will make a hash map of the window in which we are
We will also have a variable match count
This will tell us the no. of variables that match in string P and our window
If match count will be equal to length of P then we have found our answer

We get b 
Hash Map
b -> 1

b for p hash map is 2
So we increment match count
matchCount = 1
length = 1

We get a
Hash Map
b -> 1
a -> 1

a for p hash map is 2
So we increment match count
matchCount = 2
length = 2

We get d
Hash Map
b -> 1
a -> 1
d -> 1

d for p hash map is 1
So we increment match count
matchCount = 3
length = 3

We get a
Hash Map
b -> 1
a -> 2
d -> 1
c -> 1

a for p hash map is 2
So we increment match count
matchCount = 5
length = 5

We get b
Hash Map
b -> 2
a -> 2
d -> 1
c -> 1

a for p hash map is 2
So we increment match count
matchCount = 6
length = 6

Since matchCount = pLength
So we store the start in result arrayList

Also the length of the list has now reached pLength
So now we have to add a variable and side by side remove a variable

We get a
And we remove b
b -> 1
a -> 3
d -> 1
c -> 1

When we get a its frequency becomes higher than that of a in p
So it will not increment matchCount

When we remove b its frequency becomes less than that of b in p
So it will decrement matchCount
matchCount = 5
length = 6

And so on

 */

import java.util.*;

public class AnagramStrings
{
	  public static ArrayList<Integer> findAnagrams(String s, String p) {
	  	  
		  int sLength = s.length();
		  int pLength = p.length();
		  
		  if(sLength<pLength)
		  {
			  ArrayList<Integer> arr = new ArrayList<>();
			  return arr;
		  }
		  
		  ArrayList<Integer> result = new ArrayList<>();
		  
		  HashMap<Character,Integer> P = new HashMap<>();
		  HashMap<Character,Integer> H = new HashMap<>();
		  
		  for(int i=0 ; i<pLength ; i++)
		  {
			  char ch = p.charAt(i);
			  
			  if(!P.containsKey(ch))
			  {
				  P.put(ch,1);
			  }
			  else
			  {
				  P.put(ch,P.get(ch)+1);
			  }
		  }
		  
		  int start = 0;
		  int end = 0;
		  int matchCount = 0;
		  
		  for(int i=0 ; i<pLength ; i++)
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
			  
			  if(P.containsKey(ch))
			  {
				  int pCount = P.get(ch);
				  int hCount = H.get(ch);
				  
				  if(pCount>=hCount)
				  {
					  matchCount++;
				  }
			  }
			  
			  end = i;
		  }
		  
		  if(pLength==matchCount)
		  {
			  result.add(start);
		  }
		  
		  while(end+1<sLength)
		  {
			  char ch = s.charAt(start);
			  
			  int hFreqStart = H.get(ch)-1;
			  H.put(ch,hFreqStart);
			  
			  if(H.get(ch)==0)
			  {
				  H.remove(ch);
			  }
			  
			  int pFreqStart = 0;
			  
			  if(P.containsKey(ch))
			  {
				  pFreqStart = P.get(ch);
			  }
			  
			  if(hFreqStart<pFreqStart)
			  {
				  matchCount--;
			  }
			  
			  ch = s.charAt(end+1);
			  
			  int hFreqEnd = 0;
			  
			  if(H.containsKey(ch))
			  {
				  hFreqEnd = H.get(ch);
			  }
			  
			  hFreqEnd++;
			  
			  H.put(ch,hFreqEnd);
			  
			  int pFreqEnd = 0;
			  
			  if(P.containsKey(ch))
			  {
				  pFreqEnd = P.get(ch);
			  }
			  
			  if(hFreqEnd<=pFreqEnd)
			  {
				  matchCount++;
			  }
			  
			  start++;
			  end++;
			  
			  if(matchCount==pLength)
			  {
				result.add(start); 
			  }
		  }
		  
		  return result;
	  	  
	  }

	  public static void main(String[] args) {
	  	  Scanner scn = new Scanner(System.in);
	  	  String s = scn.next();
	  	  String p = scn.next();
	  	  System.out.println(findAnagrams(s, p));
	  }
}