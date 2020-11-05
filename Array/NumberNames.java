package Array;


import java.util.*;

public class NumberNames {
	
	static String[] got={"","Thousand ","Million ","Billion ","Trillion "};
	static String[] teens={"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ",
			 				"Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Ninteen "};
	static String[] tens={"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	
	public static String getName(int n, int index){
		if(n==0){
			return "";
		}
		
		int num = n/1000;
		
		int val = n%1000;
		String ourVal = small(val);
		String suffix = got[index];
		ourVal = ourVal + suffix;
		
		String temp = getName(num,index+1);
		
		String result = temp + ourVal;
		return result;
		
	}
	
	public static String small(int n){
	
		if(n==0)
		{
			return "";
		}
		
		if(n>=100)
		{
			String temp = teens[n/100] + "Hundred ";
			temp = temp + small(n%100);
			return temp;
		}
		else
		{
			if(n<20)
			{
				String temp = teens[n];
				return temp;
			}
			else
			{
				String temp = tens[n/10];
				temp = temp + teens[n%10];
				return temp;
			}
			
		}
	}

	public static void getString(int n)
	{
		if(n==0)
		{
			System.out.println("Zero");
			return ;
		}
		String str = getName(n,0);
		System.out.println(str);
	}
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		getString(n);
	}

}
