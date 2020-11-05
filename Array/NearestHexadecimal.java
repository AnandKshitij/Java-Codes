package Array;

/*
1. Every color is given as #ABCDEF, every capital letter represents some hexadecimal digit from 0 to f.
2. The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand. For example, "#15c" is shorthand for the color "#1155cc".
3. Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
4. Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it 
can be represented as some "#XYZ")

Example 1:
Input: color = "#09f166"
Output: "#11ee66"
Explanation: 
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.
*/


import java.util.*;

public class NearestHexadecimal {
	
	public static String nearestTwoDigits(String S) {
		
		HashMap<Character,Integer> H = new HashMap<>();
		
		H.put('0',0);H.put('1',1);H.put('2',2);H.put('3',3);
		H.put('4',4);H.put('5',5);H.put('6',6);H.put('7',7);
		H.put('8',8);H.put('9',9);H.put('a',10);H.put('b',11);
		H.put('c',12);H.put('d',13);H.put('e',14);H.put('f',15);
		
		char ch1 = S.charAt(0);
		char ch2 = S.charAt(1);
		
		int diff1 = 0;
		int diff2 = 0;
		
		if(H.get(ch1)==H.get(ch2)) {
			return S;
		}
		
		String result;
		
		if(H.get(ch1)>H.get(ch2)) {
			String next = "" + ch1 + "" + ch1;
			int nextVal = Integer.parseInt(next,16);
			int val = H.get(ch1)-1;
			String prev = "";
			if(val<=9) {
				char ch = (char)(val+'0');
				prev += ch+""+ch;
			}
			else {
				char ch = (char)(val-10+'a');
				prev += ch+""+ch;
			}
			int prevVal = Integer.parseInt(prev,16);
		
			
			int currVal = Integer.parseInt(S,16);
			diff1 = nextVal-currVal;
			diff2 = currVal-prevVal;
			
			if(diff1<diff2) {
				result = next;
			}
			else {
				result = prev;
			}
		}
		
		else {
			
			String prev = "" + ch1 + "" + ch1;
			int prevVal = Integer.parseInt(prev,16);
			
			int val = H.get(ch1)+1;
			
			String next = "";
			if(val<=9) {
				char ch = (char)(val+'0');
				next += ch+""+ch;
			}
			else {
				char ch = (char)(val-10+'a');
				next += ch+""+ch;
			}
			int nextVal = Integer.parseInt(next,16);
			
			int currVal = Integer.parseInt(S,16);
			diff1 = nextVal-currVal;
			diff2 = currVal-prevVal;
			
			if(diff1<diff2) {
				result = next;
			}
			
			else {
				result = prev;
			}
			
		}
		
		return result;
		
	}

    public static String similarRGB(String color) {
    	
    	String result = "#";
    	for(int i=1; i<color.length(); i++) {
    		String temp = ""+color.charAt(i);
    		if(i+1<color.length()) {
    			temp += color.charAt(i+1);
    			result += nearestTwoDigits(temp);
    			i++;
    		}
    		else {
    			result += temp;
    		}
    	}
    	
    	return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(similarRGB(sc.next()));
    }

}