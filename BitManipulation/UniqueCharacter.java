package BitManipulation;

/*
1. You are given a Strings S and T.
2. T is formed by random shuffling of characters of S and adding one more character at random position in the string.
3. You have to find the character that was added to T.
4. main takes input Strings S and T from the users.
5. This is a functional problem. 
6. You have to complete the findTheDifference function. It takes as input the String S and String T. It should return the character 
that is added to T.
7. Don't change the code of main.
 */

import java.util.*;

public class UniqueCharacter {
	
    public static char findTheDifference(String s, String t) {
        
    	int result = 0;
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		result = result^s.charAt(i);
    	}
    	
    	for(int i=0; i<t.length(); i++)
    	{
    		result = result^t.charAt(i);
    	}
    	
    	char ch = (char)result;
    	return ch;
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(findTheDifference(s, t));

    }

}