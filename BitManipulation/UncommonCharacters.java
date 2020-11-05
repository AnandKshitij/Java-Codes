package BitManipulation;

/*
1.Find and print the uncommon characters of the two given strings S1 and S2.
2.Here uncommon character means that either the character is present in one string
or it is present in other string but not in both.
3.The strings contains only lower case characters and can contain duplicates.
4.You have to complete the function uncommon() which should print the uncommon characters of the two given strings S1 and S2.
5.Print the uncommon characters in sorted order.
 */


import java.util.*;

public class UncommonCharacters
{
	 public static void uncommon(String str1, String str2) {
	
		 int num1 = 0;
		 int num2 = 0;
		 
		 for(int i=0 ; i<str1.length(); i++)
		 {
			 char ch = str1.charAt(i);
			 int val = ch-'a';
			 
			 num1 = (num1 | (1<<val));
		 }
		 
		 for(int i=0 ; i<str2.length(); i++)
		 {
			 char ch = str2.charAt(i);
			 int val = ch-'a';
			 
			 num2 = (num2 | (1<<val));
		 }
		 
		 int num3 = num1^num2;
		 
		 int x = 0;
		 
		 while((1<<x)<=num3)
		 {
			 if(((1<<x)&num3)!=0)
			 {
				int pos = x;
				pos = pos + 'a';
				char ch = (char)(pos);
				System.out.print(ch);
			 }
			 x++;
		 }
		 
		 
	 }
	 
	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
	 	 String str1 = sc.next();

	 	 String str2 = sc.next();

	 	 uncommon(str1, str2);

	 }
}
