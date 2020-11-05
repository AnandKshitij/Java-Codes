package Strings;

/*
1. You will be given a string str and an array of strings dict
2. You need to encapsulate all such substrings in str that appear in array dict within a bold tag, substring
3. If two substrings overlap, you need to wrap them together by only one pair of closed bold tag, that is if 'ab' is in 
dict and 'bc' is also in dict, encapsulate 'abc' in string not 'ab' and 'bc' separately. 
4. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them. 

Sample Input
delhi110092
3
delhi 92 hi
Sample Output
delhi110092
*/

/*
For searching a string of length m in a string of length n the best algorithm is KMP algorithm
This algorithm has time complexity O(m+n)

In java there is an inbuilt function called indexOf to do this work
 */

import java.util.*;

public class AddBoldTag {

	 public static String addBoldTag(String s, String[] dict) {
		 	
		 boolean isBold[] = new boolean [s.length()];
		 
		 for(int i=0; i<dict.length; i++) {
			
			 String str = dict[i];
			 
			 int fromIndex = 0;
		 
			 while(fromIndex>-1) {
				 int startIndex = s.indexOf(str, fromIndex);
				 
				 if(startIndex!=-1) {
					 for(int j=startIndex; j<startIndex+dict[i].length(); j++) {
						 isBold[j] = true;
					 }
				 }
				 else {
					 break;
				 }
				 
				 fromIndex = startIndex + 1;
			 }
			 
		 }
		 
		 String result = "";
		 
		 int i=0;
		 
		 while(i<s.length()){
			 if(!isBold[i]) {
				 result = result + s.charAt(i);
				 i++;
			 }
			 else {
				 String temp = "";
				 while(i<s.length() && isBold[i]) {
					 temp += s.charAt(i);
					 i++;
				 }
				 
				 result += "<b>" + temp + "</b>";
			 }
		 }
		 
		 return result;
	 }
	
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s = scn.next();
	 	 int n = scn.nextInt();
	 	 String[] dict = new String[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 dict[i] = scn.next();
	 	 }
	 	 System.out.println(addBoldTag(s, dict));
	 }
}
