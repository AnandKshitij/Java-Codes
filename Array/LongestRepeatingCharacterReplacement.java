package Array;

/*
1. You will be given a String and an integer k
2. Given that you can replace exactly k characters with any character, you need to find length of the longest 
sequence with repeating character

 Sample Input
AAABAAACCAABA
1
Sample Output
7
*/


import java.util.*;

public class LongestRepeatingCharacterReplacement {

	public static int getMaxLength(String str, int k) {
		
		int maxLength = Integer.MIN_VALUE;
		
		if(str.length()==0) {
			return 0;
		}
		
		for(int i=0; i<26; i++) {
			char ch = (char)(i+'A');
			
			int start = 0;
			
			int end = start+1;
			int currReplacements = 0;
			

			if(str.charAt(0)!=ch) {
				if(currReplacements<k)
				currReplacements++;
				else
				start++;
			}
			
			while(end<str.length()) {
				if(str.charAt(end)==ch) {
					end++;
				}
				else {
					if(currReplacements<k) {
						currReplacements++;
						end++;
					}
					else {
						if(str.charAt(start)==ch) {
							start++;
						}
						else {
							start++;
							currReplacements--;
						}
					}
				}
				int length = end-start;
				if(length>maxLength) {
					maxLength = length;
				}
				
			}
			
			
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int k = s.nextInt();
		
		System.out.println(getMaxLength(str,k));
	}
	
}
