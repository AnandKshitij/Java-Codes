package Array;

/*
1. Given a positive integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n 
and is greater in value than n. 
2. If no such positive integer exists, you need to return -1.
*/

/*
The no. will be the greatest when MSB is greatest and LSB is the smallest(LSB to MSB in increasing order)
In that case we cannot generate a bigger no.
So we need to move right to left
Till the no.'s are increasing we cannot do anything
We will change the letter as soon as we observe the first dip 
*/


import java.util.*;

public class NextGreaterWithSameDigits {

    public static int nextGreaterElement(int n) {
    	
    	String str = Integer.toString(n);
    	boolean isIncreasing = true;
    	int prev = Integer.MIN_VALUE;
    	int dipIndex = -1;
    	
    	for(int i=str.length()-1; i>=0; i--) {
    		char ch = str.charAt(i);
    		int digit = ch-'0';
    		
    		if(digit<prev) {
    			isIncreasing = false;
    			dipIndex = i;
    			break;
    		}
    		prev = digit;
    	}
    	
    	//next greater no. cannot be made
    	//as the no. is already the greatest no. that can be formed using these digits
    	if(isIncreasing) {
    		return -1;
    	}
    	
    	int justLarger = Integer.MAX_VALUE;
    	int index = -1;
    	int dipValue = str.charAt(dipIndex)-'0';
    	
    	for(int i=dipIndex+1; i<str.length(); i++) {
    		int val = str.charAt(i)-'0';
    		if(val<=dipValue) {
    			continue;
    		}
    		if(val<justLarger) {
    			justLarger = val;
    			index = i;
    		}
    	}
    	
    	String newStr = "";
    	
    	char ch1 = str.charAt(dipIndex);
    	char ch2 = str.charAt(index);
    	
    	for(int i=0; i<str.length(); i++) {
    		
    		if(i==dipIndex) {
    			newStr += ch2;
    		}
    		else if(i==index) {
    			newStr += ch1;
    		}
    		else {
    			newStr += str.charAt(i);
    		}
    	}
    	
    	String result = "";
    	
    	for(int i=0; i<=dipIndex; i++) {
    		result += newStr.charAt(i);
    	}
    	
    	String temp = "";
    	for(int i=dipIndex+1; i<str.length(); i++) {
    		temp += newStr.charAt(i);
    	}
    	
    	char[] t = temp.toCharArray();
    	
    	Arrays.sort(t);
    	
    	for(int i=0; i<t.length; i++) {
    		result += t[i];
    	}
    	
    	return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(nextGreaterElement(sc.nextInt()));
    }

}
