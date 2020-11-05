package HashMapsAndHeaps;

/*
1. You will be given an Array of words
2. You need to find if any of the words can be generated using just one row of an American keyboard
3. Return such words in an array

Sample Input
4
Row
topper
tweet
Pepcoding
Sample Output
Row topper tweet
*/

import java.util.*;
public class KeyboardRow {
	
	public static void findWords(String[] words) {
		
		//stores the rows of the keys
		//a is in row 1
		//b is in row 2
		//c is in row 2
		//d is in row 1
		//e is in row 0
		//and so on
        int pos[] = {1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        
        for (int i = 0; i <words.length; i++) {
			String str = words[i];
			
			char ch1 = str.charAt(0);
			int row = 0;
			
			if(ch1>='a' && ch1<='z')
			{
				int val = ch1-'a';
				row = pos[val];
			}
			else if(ch1>='A' && ch1<='Z')
			{
				int val = ch1-'A';
				row = pos[val];
			}
			
			boolean print = true;
			
			for(int j=1; j<str.length(); j++)
			{
				char ch = str.charAt(j);
				
				int temp = 0;
				
				if(ch>='a' && ch<='z')
				{
					int val = ch-'a';
					temp = pos[val];
				}
				else if(ch>='A' && ch<='Z')
				{
					int val = ch-'A';
					temp = pos[val];
				}
				
				if(temp!=row)
				{
					print = false;
					break ;
				}
			}
			
			if(print)
			{
				System.out.print(str + " ");
			}
		}
        
   
	}
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        String[] words= new String[n];
        for(int i=0;i<n;i++)
            words[i]=scn.next();
       findWords(words);
        
    }
}