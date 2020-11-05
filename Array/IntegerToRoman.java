package Array;

/*
1.Given an integer, convert it to a roman numeral. 
2.Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. 
The number twenty seven is written as XXVII, which is XX + V + II.
*/


import java.util.Scanner;

public class IntegerToRoman {
	
	public static String intToRoman(int num) {
		 
		int values[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String roman[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		
		int index = values.length-1;
		String result = "";
		
		while(num>0) {
			int val = values[index];
			int n = num/val;
			if(num/val!=0) {
				String temp = roman[index];
				for(int i=0; i<n; i++) {
					result += temp;
				}
				num = num%val;
			}
			index--;
		}
		
		return result;

	 }


	 //Don't make any changes here
	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 int num = s.nextInt();
	 	 System.out.println(intToRoman(num));

	 }

}