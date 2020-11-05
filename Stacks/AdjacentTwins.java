package Stacks;

/*
1. Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and
 equal letters, and removing them.
2. We repeatedly make duplicate removals on S until we no longer can.
3. Return the final string after all such duplicate removals have been made. 
4. It is guaranteed the answer is unique. 

Example
Input: "abbaca"
Output: "ca"
 */

import java.util.*;

public class AdjacentTwins {
	
	 public static void removeAdjTwins(String s) 
	 {
		 Stack<Character> S = new Stack<>();
		 
		 for(int i=0 ; i<s.length() ; i++)
		 {
			 char curr = s.charAt(i);
			 
			 if(S.empty())
			 {
				 S.push(curr);
				 continue;
			 }
			 
			 char topValue = S.peek();
			 
			 if(topValue==curr)
			 {
				 S.pop();
			 }
			 else
			 {
				 S.push(curr);
			 }
		 }
		 
		 String str = "";
		 
		 while(!S.empty())
		 {
			 char ch = S.pop();
			 str = ch + str;
		 }
		 
		 System.out.println(str);
	 }

	 public static void main(String[] args) {
	 	 // TODO Auto-generated method stub
	 	 Scanner sc=new Scanner(System.in);
	 	 String s = sc.next();
	 	 removeAdjTwins(s);
	 }

}