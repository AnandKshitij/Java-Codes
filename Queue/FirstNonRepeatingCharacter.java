package Queue;

/*
1. Given an input stream of N characters consisting only of lower case alphabets. 
2. The task is to find the first non repeating character, each time a character is inserted to the stream. 
3. If no non repeating element is found print -1.
 */


/*
We will solve this question using combination of HashMap and Queue
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNonRepeatingCharacter {

    public static void uniqueChar(char[] str){
    	
    	Queue<Character> Q = new LinkedList<>();
    	HashMap<Character,Integer> H = new HashMap<>();
    	
    	for(int i=0 ; i<str.length ; i++)
    	{
    		char ch = str[i];
    		
    		if(H.containsKey(ch))
    		{
    			H.put(ch,H.get(ch)+1);
    		}
    		else
    		{
    			H.put(ch,1);
    			Q.add(ch);
    		}
    		
    		while(!Q.isEmpty() && H.containsKey(Q.peek()) && H.get(Q.peek())>1)
    		{
    			Q.remove();
    		}
    		
    		if(Q.isEmpty())
        	{
        		System.out.print(-1+" ");
        		continue ;
        	}
        	System.out.print(Q.peek()+" ");
    	}
    	
	       
    }
    
    public static void main(String[] args) 
    {
    	
        	Scanner sc= new Scanner(System.in);
            int n=sc.nextInt();
            char ch[]=new char[n];

            for (int i=0; i<n;i++){
                ch[i]=sc.next().charAt(0);
                
            }
            uniqueChar(ch);

    }

}