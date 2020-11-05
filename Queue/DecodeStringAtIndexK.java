package Queue;

/*
You are given an encoded string and an index K.
The given string is read character-wise and is being written on a tape.
If the character is a letter then it is written as it is.
If the character is a digit(say d) then the whole tape upto its current form is written again (d-1) number of times.
You have to return the Kth character of the decoded string.
Example
If the encoded string is : a3bc3xy and K is 14
The decoded string is formed in the manner : a-->aaa-->aaabc-->aaabcaaabcaaabc-->aaabcaaabcaaabcxy
14th character of the decoded string is 'c'
 */

/*
In this question we don't need to expand the string 
As the answer must be a character in the given string itself
As the final characters in the final string are only repetition of these characters

First we will find the length of the final string
Initially l=0

a3bc3xy

We get a
l++. So l=1

We get 3
l=l*3. So l=3

We get b
l++. So l=4

We get c
l++. So l=5

We get 3
l=l*3. So l=15

We get x
l++. So l=16

We get y
l++. So l=17

Now we will move backwards in the string and decide whether the character is our ans or not
For this example k=14

a3bc3xy

l=17

for y
we check whether k+1%l==0(15%17==0)
false. So l--. l=16
This means y cannot be our answer

for x
we check whether k+1%l==0(15%16==0)
false. So l-- . l=15
This means x cannot be our answer

for 3
l = l/3 . l=5
Since l<k we do k=k%l(14%5)=4
Because it is not logical to find element at index 14 in length 5
Although this step is not necessary as we are checking k+1%l==0 instead of k+1/l==1

for c
we check whether k+1%l==0(5%5==0)
true. So c is our answer

 */


import java.util.*;
import java.io.*;

public class DecodeStringAtIndexK
{
	   public static String decodeIndex(String S, int K) {
	  
		   int length = 0;
		   
		   for(int i=0 ; i<S.length() ; i++)
		   {
			   char ch = S.charAt(i);
			   
			   if(ch>='a' && ch<='z')
			   {
				   length++;
			   }
			   if(ch>='0' && ch<='9')
			   {
				   String val = ""+ch;
				   
				   while(i+1<S.length() && S.charAt(i+1)>='0' && S.charAt(i+1)<='9')
				   {
					   val = val+S.charAt(i+1);
					   i++;
				   }
				   
				   length = length*Integer.parseInt(val);
			   }
		   }
		   
		   String result = "";
		   for(int i=S.length()-1 ; i>=0 ; i--)
		   {
			   char ch = S.charAt(i);
			   
			   if(ch>='a' && ch<='z')
			   {
				   if((K+1)%length==0)
				   {
					   result += ch;
					   break ;
				   }
				   else
				   {
					   length--;
				   }
			   }
			   
			   if(ch>='0' && ch<='9')
			   {
				   String val = ""+ch;
				   
				   while(i-1>=0 && S.charAt(i-1)>='0' && S.charAt(i-1)<='9')
				   {
					   val = S.charAt(i-1)+val;
					   i--;
				   }
				   length = length/Integer.parseInt(val);
			   }
			   
			   if(K>length)
			   {
				   K = K%length;
			   }
		   }
		   
		   return result;
		   
	  }



	  

	  // Dont make changes here
	  public static void main(String[] args) {
	  	  Scanner sc=new Scanner(System.in);
	  	  String s=sc.next();
	  	  int k=sc.nextInt();
	  	  System.out.println(decodeIndex(s,k));
	  }

}
