package test1;

import java.util.Scanner;

public class Numbers_In_Lexographical_Order 
{	
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        lexcico(1, scn.nextInt());
    }
    
    public static void helperPrint(int num , int end)
    {
    	for(int i=0 ; i<10 ; i++)
    	{
    		int val = num*10+i;
    		if(val<end)
    		{
    			System.out.println(val);
    			helperPrint(val,end);
    		}
    	}
    }

    public static void lexcico(int start, int end)
    {
    	for(int i=1 ; i<10 && i<end; i++)
    	{
    		System.out.println(i);
    		helperPrint(i,end);
    	}
    }
}