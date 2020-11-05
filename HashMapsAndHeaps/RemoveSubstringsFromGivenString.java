package HashMapsAndHeaps;

/*
1. Given a String S.
2. Your task is to remove the given two strings(M and N) completely from the given string S. 
3. If String is completely removed then print -1.

Sample Input
abbbccab
ab bcc
Sample Output
b
*/


import java.util.*;

public class RemoveSubstringsFromGivenString {

    public static void removeString(String str, String m, String n) {
    	
    	//tells the elements which we need to print in the end
    	boolean shouldPrint[] = new boolean [str.length()];
    	
    	for(int i=0; i<shouldPrint.length; i++)
    	{
    		shouldPrint[i] = true;
    	}
    	
    	
    	//we create a substring of length of string m from our string
    	String subString = "";
    	
    	for(int i=0; i<m.length(); i++)
    	{
    		char ch = str.charAt(i);
    		subString = subString + ch;
    	}
    	
    	//we check whether the given substring is same as m or not
    	if(subString.equals(m))
    	{
    		for(int i=0; i<m.length(); i++)
    		{
    			shouldPrint[i] = false;
    		}
    	}
    	
    	
    	//now we maintain the substring size
    	//then we check whether that string is equal to m or not
    	for(int i=0; i<str.length()-m.length(); i++)
    	{
    		char ch = str.charAt(i+m.length());
    		subString = subString.substring(1);
    		subString = subString + ch;
    		
    		if(subString.equals(m))
        	{
        		for(int j=i+m.length(); j>i; j--)
        		{
        			shouldPrint[j] = false;
        		}
        	}
    	}
    	
    	
    	//now we repeat the whole process for n
    	subString = "";
    	
    	for(int i=0; i<n.length(); i++)
    	{
    		char ch = str.charAt(i);
    		subString = subString + ch;
    	}
    	
    	if(subString.equals(n))
    	{
    		for(int i=0; i<n.length(); i++)
    		{
    			shouldPrint[i] = false;
    		}
    	}
    	
    	for(int i=0; i<str.length()-n.length(); i++)
    	{
    		char ch = str.charAt(i+n.length());
    		subString = subString.substring(1);
    		subString = subString + ch;
    		
    		if(subString.equals(n))
        	{
        		for(int j=i+n.length(); j>i; j--)
        		{
        			shouldPrint[j] = false;
        		}
        	}
    	}
    	
    	
    	//we make a result string in which only those elements of str are added which are marked as true in shouldPrint array
    	String result = "";
    	
    	for(int i=0; i<str.length(); i++)
    	{
    		if(shouldPrint[i])
    		{
    			result = result + str.charAt(i);
    		}
    	}
    	
    	System.out.println(result);
    	
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String m = sc.next();
        String n = sc.next();
        removeString(str, m, n);
    }

}
