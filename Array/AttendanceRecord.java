package Array;

/*
1. You are given a Strings S, representing an attendance record for a student.
2. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
3. A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
4. You have to find whether the student could be rewarded according to his attendance record.
5. For example, 
Input: "PPALLP"
Output: True
*/


import java.util.*;

public class AttendanceRecord {

    public static boolean checkRecord(String s) {
        
    	boolean isAbsent = false;
    	
    	for(int i=0; i<s.length(); i++) {
    		
    		char ch = s.charAt(i);
    		
    		if(ch=='A') {
    			if(!isAbsent) {
    				isAbsent = true;
    			}
    			else {
    				return false;
    			}
    		}
    		
    		else if(ch=='L') {
    			if(i+1<s.length() && s.charAt(i+1)=='L') {
    				i++;
    				if(i+1<s.length() && s.charAt(i+1)=='L') {
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        if (checkRecord(S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}