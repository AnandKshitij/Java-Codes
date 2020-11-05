package Strings;


import java.util.*;

public class RemoveComments {
	
	public static ArrayList<String> getCompressedString(String[] src) {
		
		ArrayList<String> result = new ArrayList<>();
		boolean isComment = false;
		String temp = "";
		
		for(int k=0; k<src.length; k++) {
			
			String S = src[k];
			
			for(int i=0; i<S.length(); i++) {
				char ch = S.charAt(i);
				
				if(isComment) {
					if(ch=='*') {
						if(S.charAt(i+1)=='/') {
							isComment = false;
							i++;
						}
					}
					
					continue;
				}
				else {
					if(ch=='/') {
						if(S.charAt(i+1)=='/') {
							i++;
							break ;
						}
						else if(S.charAt(i+1)=='*') {
							i++;
							isComment = true;
						}
					}
					
					else {
						temp += ch;	
					}
				}
			}
			if(!isComment) {
				if(temp.length()!=0)
				result.add(temp);
				String t1 = "";
				temp = t1;
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		//this is because after using s.nextInt() we press enter
		//this enter is not read by nextInt()
		//it goes as input to our for loop where we are using nextLine()
		//so our src[0] always remains empty
		//we do not encounter this problem with s.next()
		s.nextLine();
		
		String src[] = new String[n];
		
		for(int i=0; i<n; i++) {
			src[i] = s.nextLine();
		}
		
		
		ArrayList<String> result = getCompressedString(src);
		
		System.out.println(result);	
	
	}

}
