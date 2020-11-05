package Array;

/*
1. You will be given two strings, you need to sort string 2 on basis of position of characters in string 1
2. If there exist characters in string 2 that are not present in string 1 and them at the end of custom sorted string2 
and sort them lexicographically 
3. You need to return this custom sorted string 2
*/

/*
Add all the elements of string2 in the hash map
Then traverse on string1

If the character is present in the hash map then print it
Else move ahead
In the end print the remaining characters of the hash map lexicographically
 */


import java.util.*;

public class SortStr1AccToStr2 {
    
	public static String customSortString(String S, String T) {
		String result = "";
		
		HashMap<Character,Integer> H = new HashMap<>();
		
		for(int i=0; i<T.length(); i++) {
			if(!H.containsKey(T.charAt(i))) {
				H.put(T.charAt(i),1);
			}
			else {
				H.put(T.charAt(i),H.get(T.charAt(i))+1);
			}
		}
		
		for(int i=0; i<S.length(); i++) {
			if(H.containsKey(S.charAt(i))) {
				int freq = H.get(S.charAt(i));
				for(int j=0; j<freq; j++) {
					result += S.charAt(i);
				}
				H.remove(S.charAt(i));
			}
		}
		
		char arr[] = new char [H.size()];
		
		int i=0;
		for(char ch: H.keySet()) {
			arr[i] = ch;
			i++;
		}
		
		Arrays.sort(arr);
		
		for(i=0; i<arr.length; i++) {
			char ch = arr[i];
			int freq = H.get(ch);
			for(int j=0; j<freq; j++) {
				result += ch;
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        String S= scn.next();
        String T=scn.next();
        System.out.print(customSortString(S, T));
	 }
}
