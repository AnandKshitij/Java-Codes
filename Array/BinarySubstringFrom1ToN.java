package Array;

/*
1.Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N
return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

2.You have to complete the function queryString() which should return true or false.
*/


import java.util.*;

public class BinarySubstringFrom1ToN 
{
	 public static boolean queryString(String S, int N) {
		 
		 int currSum = 0;
		 int start = 0;
		 int end = 1;
		 
		 if(S.charAt(0)=='1') {
			 currSum += 1;
		 }
		 
		 HashSet<Integer> H = new HashSet<>();
		 
		 for(int i=N/2; i<=N; i++) {
			 H.add(i);
		 }
		 
		 if(H.contains(currSum)) {
			 H.remove(currSum);
		 }
		 
		 boolean isValid = true;
		 
		 if(N<=1) {
			 isValid = false;
		 }
		 
		 while(end<=S.length()) {
			 
			 if(!isValid) {
				 char ch = S.charAt(start);
				 int val = ch-'0';
				 if(val==1) {
					 int diff = end-start-1;
					 currSum -= (int)Math.pow(2,diff);
					 if(currSum<=N) {
						 isValid = true;
						 if(H.contains(currSum)) {
							 H.remove(currSum);
						 }
						 if(H.isEmpty()) {
							 return true;
						 }
					 }
				 }
				 start++;
			 }
			 	
			 else if(isValid) {
				 
				 if(end==S.length()) {
					 break;
				 }
				 char ch = S.charAt(end);
				 int val = ch-'0';
				 int temp = 0;
				 if(val==1) {
					 temp = 2*currSum+1;
				 }
				 else if(val==0) {
					 temp = 2*currSum;
				 }
				 if(temp<=N) {
					 if(H.contains(temp)) {
						 H.remove(temp);
						 if(H.isEmpty()) {
							 return true;
						 }
					 }
					 currSum = temp;
					 end++;
				 }
				 else {
					 isValid = false;
				 }
				 
			 }
		 }
		 
		 while(start<S.length()) {
			 char ch = S.charAt(start);
			 int val = ch-'0';
			 if(val==1) {
				 int diff = end-start-1;
				 currSum -= (int)Math.pow(2,diff);

				 if(currSum<=N) {
					 isValid = true;
					 if(H.contains(currSum)) {
						 H.remove(currSum);
					 }
					 if(H.isEmpty()) {
						 return true;
					 }
				 }
			 }
			 start++; 
		 }
		 if(H.isEmpty()) {
			 return true;
		 }
		 return false;
	 
	 }

	 //Don't make any changes here.
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 String str = s.next();
	 	 System.out.println(queryString(str, n));

	 }

}