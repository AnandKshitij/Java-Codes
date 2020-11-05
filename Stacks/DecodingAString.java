package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class DecodingAString {
	 
	 public static String decode(String s) {
	 //Write your code here
		 
		 Stack<String> S = new Stack<>();
		 
		 int length = s.length()-1;
		 
		 while(length>=0)
		 {
			 char ch = s.charAt(length);
			 
			 if(ch=='[')
			 {
				 String str = "";
				 while(!(S.empty() || S.peek().equals("]")))
				 {
					 str = str + S.pop();
				 }
				 if(S.peek().equals("]"))
				 {
					 S.pop();
				 }
				 S.push(str);
			 }
			 
			 else if(ch>='0' && ch<='9')
			 {

				 String value = ch+"";
				 
				 while(length>0 && s.charAt(length-1)>='0' && s.charAt(length-1)<='9')
				 {
					 value = s.charAt(length-1)+value;
					 length--;
				 }
				 
				 int val = Integer.parseInt(value);
				 System.out.println(val);
				 
				 String str = S.pop();
				 String add = "";
				 
				 for(int j=0 ; j<str.length() ; j++)
				 {
					 add += str.charAt(j);
				 }
				 
				 for(int i=1 ; i<val ; i++)
				 {
					 str += add;
				 }
				 
				 S.push(str);
			 }
			 
			 else
			 {
				 S.push(ch+"");
			 }
			 length--;
		 }
		 
		 String result = "";
		 
		 while(!S.empty())
		 {
			 String temp = S.pop();
			 result += temp;
		 }
		 return result;
	 }
	 
	 public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
		 String s=sc.next();
		 System.out.println(decode(s));
		 
	 }
}
