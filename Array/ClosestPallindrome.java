package Array;

/*
1. You will be given an integer as a string
2. You need to find a number closest(minimum difference) that is pallindrome

For no. with even no. of digits
2345
23+1=24
23-1=22
& 23

2332
2222
2442
The closest no. is 2332

For no. with odd no. of digits
36754

Only 36
7+1=8
7-1=6

36863
36663
The closest is 36663



Special Cases-

1)For no.'s like 1000
10-1=9
10+1=11

99 
We need to add a 9 in between the two 9s
So 999
Whenever the no. of digits in resultant string decrease by 2 we need to do this

So 999 is closer

2)For no.'s like 99

9+1=10
9-1=8

1001
We need to remove one zero from it
Whenever the no. of digits increase by 2 we need to remove the middle element

88

*/

import java.util.*;

public class ClosestPallindrome {
    
	public static boolean isPallindrome(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static String tillMid(String str) {
		String mid = "";
		
		for(int i=0; i<str.length()/2; i++) {
			mid += str.charAt(i);
		}
		return mid;
	}
	
	public static String reverse(String str) {
		String result = "";
		for(int i=str.length()-1; i>=0; i--) {
			result += str.charAt(i);
		}
		return result;
	}
	
	public static String nearestPalindromic(String str) { 	
		
		if(isPallindrome(str)) {
			return str;
		}
		int n = str.length();
		
		String result;
		
		if(n%2==0) {
			String mid = tillMid(str);
			
			//for no.'s like 100
			int actualV = Integer.parseInt(str);
			
			if((int)Math.pow(10,str.length()-1)==actualV) {
				int ans = actualV-1;
				result = Integer.toString(ans);
				return result;
			}
			
			int midVal = Integer.parseInt(mid);
			
			int nextVal = midVal+1;
			String nextMid = Integer.toString(nextVal);
			
			int prevVal = midVal-1;
			String prevMid = Integer.toString(prevVal);
			
			String curr = mid + reverse(mid);
			String finalNext = nextMid + reverse(nextMid);
			
			
			String finalPrev = prevMid + reverse(prevMid);
			
			int currV = Integer.parseInt(curr);
			int nextV = Integer.parseInt(finalNext);
			int prevV = Integer.parseInt(finalPrev);
			
			int diff1 = (int)Math.abs(actualV-prevV);
			int diff2 = (int)Math.abs(currV-actualV);
			int diff3 = (int)Math.abs(nextV-actualV);
			
			if(diff3<diff1 && diff3<diff2) {
				result = finalNext;
			}
			else if(diff2<diff1 && diff2<=diff3) {
				result = curr;
			}
			else {
				result = finalPrev;
			}
			
		}
		else {
			String mid = tillMid(str);
			
			//for no.'s like 100
			int actualV = Integer.parseInt(str);
			
			if((int)Math.pow(10,str.length()-1)==actualV) {
				int ans = actualV-1;
				result = Integer.toString(ans);
				return result;
			}
			
			char middle = str.charAt(str.length()/2);
			
			int midV = middle-'0';
			
			int nextDigit = midV+1;
			
			int prevDigit = 0;
			if(midV!=0)
			prevDigit = midV-1;
			
			String next = mid + nextDigit + reverse(mid);
			String prev = mid + prevDigit + reverse(mid);
			String curr = mid + midV + reverse(mid);
			
			
			int currV = Integer.parseInt(curr);
			int nextV = Integer.parseInt(next);
			int prevV = Integer.parseInt(prev);
			
			int diff1 = (int)Math.abs(actualV-prevV);
			int diff2 = (int)Math.abs(currV-actualV);
			int diff3 = (int)Math.abs(nextV-actualV);
			
			if(diff3<diff1 && diff3<diff2) {
				result = next;
			}
			else if(diff2<diff1 && diff2<=diff3) {
				result = curr;
			}
			else {
				result = prev;
			}
			
		}
		
		return result;
	 }
	
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String n= scn.next();
        System.out.println(nearestPalindromic(n));
	 }
}