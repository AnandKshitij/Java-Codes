package Array;

/*
1. Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
2. word1 and word2 "can not" be same and they represent two individual words in the list.

words = ["practice", "makes", "perfect", "coding", "makes"].
EXAMPLE 1
Input: word1 = "coding", word2 = "practice"
Output: 1
*/


import java.util.*;


public class ShortestWordDistance {
	
    public static int shortestWordDistance(String[] words, String word1, String word2) {
       
    	int bestLength = Integer.MAX_VALUE;
    	boolean w1 = false;
    	boolean w2 = false;
    	
    	int wPos1 = 0;
    	int wPos2 = 0;
    	
    	for(int i=0; i<words.length; i++) {
    		String curr = words[i];
    		
    		if(!curr.equals(word1) && !curr.equals(word2)) {
    			continue;
    		}
    		
    		if(curr.equals(word1)) {
    			if(!w1) {
    				w1 = true;
    				wPos1 = i;
    			}
    			else {
    				wPos1 = i;
    			}
    			if(w2) {
    				int length = wPos1-wPos2;
    				if(length<bestLength) {
    					bestLength = length;
    				}
    			}
    		}
    		
    		else if(curr.equals(word2)) {
    			if(!w2) {
    				w2 = true;
    				wPos2 = i;
    			}
    			else {
    				wPos2 = i;
    			}
    			if(w1) {
    				int length = wPos2-wPos1;
    				if(length<bestLength) {
    					bestLength = length;
    				}
    			}
    		}
    	}
    	
    	if(!w1 || !w2) {
    		return -1;
    	}
    	
    	return bestLength;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        String word1 = sc.next(), word2 = sc.next();
        System.out.println(shortestWordDistance(words, word1, word2));
    }
    
}
