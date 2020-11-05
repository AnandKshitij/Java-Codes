package HashMapsAndHeaps;

/*
1. You will be given a String
2. You need to rearrange the characters in given string such that adjacent characters are distinct. 
4. Input and output is handled for you
5. It is a functional problem ,please do not modify main()
*/

/*
First we will make a hash map for the string

For a string of size 6 maximum allowable frequency of any element will be 3
abacad

For a string of size 5 maximum allowable frequency will be 3
abaca

So maximum allowable frequency for any string will be (k+1)/2

If any frequency is greater than this value then rearrangement is not possible and we give empty string
Else we print the string with the help of priority queue
 */



import java.util.*;

public class RearrangeString {

	 static class pair
	 {
		 char element;
		 int freq;
	 }
	 
	 static class freqComparator implements Comparator<pair>
	 {
		 public int compare(pair P1, pair P2)
		 {
			 if(P1.freq!=P2.freq)
			 {
				 return P2.freq-P1.freq; 
			 }
			 else
			 {
				 return P1.element-P2.element;
			 }
		 }
	 }
	
	 public static String reorganizeString(String S) 
	 {
		 HashMap<Character,Integer> H = new HashMap<>();
		 
		 int maxFreq = 0;
		 
		 for(int i=0; i<S.length(); i++)
		 {
			 char ch = S.charAt(i);
			 
			 if(!H.containsKey(ch))
			 {
				H.put(ch,1);
				if(maxFreq<1)
				{
					maxFreq = 1;
				}
			 }
			 else
			 {
				 H.put(ch,H.get(ch)+1);
				 if(H.get(ch)>maxFreq)
				 {
					 maxFreq = H.get(ch);
				 }
			 }
		 }
		 
		 int maxAllowed = (S.length()+1)/2;
		 
		 if(maxFreq>maxAllowed)
		 {
			 String result = "";
			 return result;
		 }
		 
		 PriorityQueue<pair> P = new PriorityQueue<>(new freqComparator());
		 
		 for(char ch : H.keySet())
		 {
			int freq = H.get(ch);
			pair temp = new pair();
			temp.element = ch;
			temp.freq = freq;
			P.add(temp);
		 }
		 
		 String result = "";
		 
		 while(!P.isEmpty())
		 {
			 pair temp1 = P.remove();
			 int freq1 = temp1.freq;
			 char ch1 = temp1.element;
			 
			 result = result + ch1;
			 
			 temp1.freq = temp1.freq-1;
			 
			 if(!P.isEmpty())
			 {
				 pair temp2 = P.remove();
				 int freq2 = temp2.freq;
				 char ch2 = temp2.element;
				 
				 result = result + ch2;
				 
				 temp2.freq = temp2.freq-1;
			
				 if(temp1.freq!=0)
				 {
					 P.add(temp1);
				 }
				 if(temp2.freq!=0)
				 {
					 P.add(temp2);
				 }
			 }
			 else
			 {
				 if(temp1.freq!=0)
				 {
					 P.add(temp1);
				 }
			 }
			 
		 }
		 
		 return result;
		 
	 }


	 public static void main(String[] args) 
	 {
	 	 Scanner sc = new Scanner(System.in);
	 	 String s = sc.next();
	 	 System.out.println(reorganizeString(s));
	 }
}
