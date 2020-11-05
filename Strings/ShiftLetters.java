package Strings;

/*
1. You are given a Strings S.
2. You are also given an integer array 'shifts'.
3. For each shifts[i] = x, you have to shift the first i+1 letters of S, x times and find the final string after all shifts.
4. For example, 
Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
*/



import java.util.*;

public class ShiftLetters {

    public static String shiftingLetters(String S, int[] shifts) {
        
    	int suffixSum = 0;
    	
    	//for calculating suffix sum and storing it in shifts array
    	for(int i=shifts.length-1; i>=0; i--){
    		suffixSum += shifts[i]%26;
    		shifts[i] = suffixSum%26;
    	}
    	
    	String result = "";
    	
    	for(int i=0; i<S.length(); i++) {
    		char ch = S.charAt(i);
    		
    		
    		if(ch>='a' && ch<='z'){
    			int val = ch-'a';
        		int toAdd = shifts[i];
        		val = val+toAdd;
        		val = val%26;
        		val = val + 'a';
        		result = result + (char)val;
    		}
    		
    		else if(ch>='A' && ch<='Z') {
    			int val = ch-'A';
        		int toAdd = shifts[i];
        		val = val+toAdd;
        		val = val%26;
        		val = val + 'A';
        		result = result + (char)val;
    		}
    	}
    	
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int N = sc.nextInt();

        int[] shifts = new int[N];

        for (int i = 0; i < N; i++) {
            shifts[i] = sc.nextInt();
        }

        System.out.println(shiftingLetters(S, shifts));
    }
}