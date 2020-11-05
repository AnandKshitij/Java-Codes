package Strings;

/*
1. You will be a name, as string
2. You will also be given the way your friend typed their name, sometimes while typing they press a key for too long
3. You need to check if the typed name can be your friend's name

Sample Input
sumeet
suuummeet
Sample Output
true
*/


import java.util.*;

import javax.sound.sampled.BooleanControl.Type;

public class LongPressedName {
	
	 public static boolean isLongPressedName(String name, String typed) {
		 int nameStart = 0;
		 int typedStart = 0;
		 
		 while(nameStart<name.length() && typedStart<typed.length()){
			 char ch1 = name.charAt(nameStart);
			 char ch2 = typed.charAt(typedStart);
			 
			 if(ch1==ch2) {
				 nameStart++;
				 typedStart++;
			 }
			 else {
				 if(typedStart-1>=0 && typed.charAt(typedStart-1)==ch2) {
					 typedStart++;
				 }
				 else {
					 return false;
				 }
			 }
		 }
		 
		 if(nameStart<name.length()) {
			 return false;
		 }
		 
		 while(typedStart<typed.length()) {
			 if(typedStart-1>=0 && typed.charAt(typedStart-1)==typed.charAt(typedStart)) {
				 typedStart++;
			 }
			 else {
				 return false;
			 }
		 }
		 
		 return  true;
	 }
	
	 public static void main(String[] args) {

	 	 Scanner scn = new Scanner(System.in);
	 	 String name = scn.next();
	 	 String typed = scn.next();
	 	 System.out.println(isLongPressedName(name, typed));

	 }

}