package Stacks;

/*
1. Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the 
canonical path.
2. In a UNIX-style file system, a period "."(without quotes) refers to the current directory. 
Furthermore, a double period ".."(without quotes) moves the directory up a level. For more information.
3. Note that the returned canonical path must always begin with a slash /, and there must be 
only a single slash / between two directory names. The last directory name (if it exists) must not 
end with a trailing /. 
4. Also, the canonical path must be the shortest string representing the absolute path.

Example 1
Input: "/home//foo/"
Output: "/home/foo"
 */


/*
In general, a path is way to get to a particular file or directory in a file system, it can be 
absolute (also known as full path) or relative e.g. relative to current location. Absolute path 
defines path from root of the file system e.g. C:\\ or D:\\ in Windows and from / in UNIX based 
operating systems

Canonical path is little bit tricky, because all canonical path is absolute, but vice-versa is not true. 
It actually defines a unique absolute path to the file from root of the file system. 

If you are a programmer, writing script then you know how using absolute path can make your script 
rigid and in-flexible, in fact using absolute path, infamously known as hard-coding path in script is 
one of the bad coding practice in programmer's dictionary. 

So the main difference is that a file can have many absolute paths but it has unique canonical path

*/


/*
Dry run:
"/a//b///c/d//././/.."

We get /
Stack : /

We get a
Stack : a /

We get /
Stack : / a /

We get /
Since we already have / on top so it will not be pushed
Stack : / a /

We get b
Stack : b / a /

We get /
Stack : / b / a /

We get /
Since we already have / on top so it will not be pushed

We get /
Since we already have / on top so it will not be pushed

"/a//b///c/d//././.."

We get c
Stack : c / b / a /

We get /
Stack : / c / b / a /

We get d
Stack : d / c / b / a /

We get /
Stack : / d / c / b / a /

We get /
Since we already have / on top so it will not be pushed

We get .
So we move to current directory
Stack : / d / c / b / a /

We get /
Stack : / d / c / b / a /

We get ..
So we move to previous directory
Stack : / c / b / a /

At the end we don't want / on top
So we pop it

Then our resultant stack becomes c/b/a/
And our resultant string becomes
/a/b/c
 */

import java.util.*;

public class AbsolutePathToCanonicalPath {
	
	public static String getCanonical(String absolute)
	{
		Stack<Character> S = new Stack<>();
		
		for(int i=0 ; i<absolute.length() ; i++)
		{
			char ch = absolute.charAt(i);
			
			if(ch=='.')
			{
				if(i+1<absolute.length() && absolute.charAt(i+1)=='.')
				{
					if(!S.empty() && S.peek()=='/')
					{
						S.pop();
					}
					
					while(!S.empty() && S.peek()!='/')
					{
						S.pop();
					}
				}
			}
			else if(ch=='/')
			{
				if(S.empty())
				{
					S.push(ch);
				}
				else
				{
					if(S.peek()!='/')
					{
						S.push(ch);
					}
				}
			}
			else
			{
				S.push(ch);
			}
		}
		
		//because only slash is a valid directory
		//but a directory sholud not end with /
		//if our answer is / then we do not pop / on the top
		if(S.size()>1 && S.peek()=='/')
		{
			S.pop();
		}
		
		String result = "";
		
		while(!S.empty())
		{
			if(S.peek()=='"')
			{
				S.pop();
				continue;
			}
			result = S.pop() + result;
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String absolute = s.next();
		String canonical = getCanonical(absolute);
		System.out.println(canonical);
	}	
	
}
