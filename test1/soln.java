package test1;

import java.util.*;

public class soln{
	
		//Given keypad sequence respective to mobile digit number
		static String[] codes = {".", "abc", "def", "gh", "jkl", "mno", "pqrs", "tuv", "wx", "yz"};
	
		
	public static String[] printKeyPad(String str,String[] codes)
	{
		if(str.length()==0)
		{
			String[] Ans = new String[1];
			Ans[0] = ""; 
			return Ans;
		}
		
		if(str.length()==1)
		{
			int num = Character.getNumericValue(str.charAt(0));
			String[] Ans = new String[codes[num].length()];
			
			for(int i=0 ; i<codes[num].length() ; i++)
			{
				Ans[i] = "" + codes[num].charAt(i);
			}
			
			return Ans;
		}
		
		String[] smallAns = printKeyPad(str.substring(1),codes);
		
		String[] Ans = new String [smallAns.length * codes[Character.getNumericValue(str.charAt(0))].length()];
		
		String code = codes[Character.getNumericValue(str.charAt(0))];
		int pos = 0;
		
		for(int i=0 ; i<Ans.length ; )
		{
			
			for(int j=0 ; j<smallAns.length ; j++)
			{
				String newString = code.charAt(pos) + smallAns[j];
				Ans[i] = newString;
				i++;
			}
			
			pos++;
		}
		
		return Ans;
		
	}
	
	public static int keyPad(String str, String[] codes, String ans) {
	// write your code here
		int result = 1;
		
		String[] myAns = printKeyPad(str,codes);
		
		for(int i=0 ; i<myAns.length ; i++)
		{
			System.out.println(myAns[i]);
		}
		
		for(int i=0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			int val = Character.getNumericValue(ch);
			String ourCode = codes[val];
			result = result*ourCode.length();
		}
		
		return result;
	}
		
	//Driver program				
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		String s=scn.nextLine();
		System.out.println(keyPad(s, codes, ""));
	}
}
