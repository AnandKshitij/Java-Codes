package Array;

/*
You will be given 2 versions, you need to return 1 if version1>version2, -1 if version1<version2 and 0 if version1=version2
*/

import java.util.*;

public class CompareNumbers {
	
	public static int compareVersion(String version1, String version2) {
	 	
		int i=0, j=0;
		
		while(i<version1.length() && j<version2.length()) {
			char ch1 = version1.charAt(i);
			char ch2 = version2.charAt(j);
			
			if(ch1=='.') {
				i++;
				continue;
			}
			if(ch2=='.') {
				j++;
				continue;
			}
			
			String s1 = "";
			while(ch1!='.') {
				s1 += ch1;
				i++;
				if(i==version1.length()) {
					break;
				}
				ch1 = version1.charAt(i);
			}
			
			String s2 = "";
			while(ch2!='.') {
				s2 += ch2;
				j++;
				if(j==version2.length()) {
					break;
				}
				ch2 = version2.charAt(j);
			}
			
			int val1 = Integer.parseInt(s1);
			int val2 = Integer.parseInt(s2);
			
			if(val1>val2) {
				return 1;
			}
			else if(val1<val2) {
				return -1;
			}
		}
		
		
		if(i<version1.length()) {
			
			while(i<version1.length()) {
				if(version1.charAt(i)=='0' || version1.charAt(i)=='.') {
					i++;
					continue;
				}
				else {
					return 1;
				}
			}
			return 0;
		}
		if(i<version2.length()) {

			while(i<version2.length()) {
				if(version2.charAt(i)=='0' || version2.charAt(i)=='.') {
					i++;
					continue;
				}
				else {
					return -1;
				}
			}
			
			return 0;
		}
		
		return 0;
	}
	
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String version1= scn.next();
        String version2=scn.next();
        System.out.print(compareVersion(version1, version2));
	 }
}
