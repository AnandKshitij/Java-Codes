package HashMapsAndHeaps;

/*
1.A website domain like "mail.google.com" consists of various subdomains.
2.At the top level, we have "com", at the next level, we have "google.com" 
and at the lowest level, "mail.google.com".
3.When we visit a domain like "mail.google.com", we will also visit the parent domains
"google.com" and "com" implicitly.
4.Count-paired domain is a count (representing the number of visits this domain received)
followed by a space, followed by the address.
An example of a count-paired domain might be "9001 mail.google.com".
5.You are given a list cpdomains of count-paired domains. 
6.You need to return a list of count-paired domains, (in the same format as the input, and in any order)
that explicitly counts the number of visits to each subdomain.
7.You have to complete the function subdomainVisits() to return the desired list.
*/


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SubDomainVisitCount {

	 public static List<String> subdomainVisits(String[] cpdomains) 
	 {
		 HashMap<String,Integer> H = new HashMap<>();
		 
		 for(int i=0 ; i<cpdomains.length; i++)
		 {
			 String curr = cpdomains[i];
			 
			 String val = "";
			 
			 int j=0;
			 for(; j<curr.length() && curr.charAt(j)!=' ' ; j++)
			 {
				 val = val + curr.charAt(j);
			 }
			 int freq = Integer.parseInt(val);
			 
			 String str = "";
			 
			 for(int k=curr.length()-1; k>j ; k--)
			 {
				 char ch = curr.charAt(k);
				 if(ch=='.')
				 {
					 if(!H.containsKey(str))
					 {
						 H.put(str,freq);
					 }
					 else
					 {
						 H.put(str,H.get(str)+freq);
					 }
				 }
				 str = ch+str;
			 }
			 
			 if(!H.containsKey(str))
			 {
				 H.put(str,freq);
			 }
			 else
			 {
				 H.put(str,H.get(str)+freq);
			 }
			 
		 }
		 
		 List<String> result = new ArrayList<>();
		 
		 for(String str : H.keySet())
		 {
			 int freq = H.get(str);
			 String temp = freq + " " + str;
			 result.add(temp);
		 }
		 
		 return result;

	 }

	 
	 public static void main(String[] args) 
	 {
		 Scanner s = new Scanner(System.in);
	 	 int n = Integer.parseInt(s.nextLine());
	 	 String[] cpd = new String[n];
	 	 for (int i = 0; i < cpd.length; i++) 
	 	 {
	 	 	 cpd[i] = s.nextLine();
	 	 }
	 	 List<String> ans = subdomainVisits(cpd);
	 	 Collections.sort(ans);
	 	 System.out.println(ans);
	 }
}
