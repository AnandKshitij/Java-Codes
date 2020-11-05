package HashMapsAndHeaps;

/*
1. Given a string which consists of only 0, 1 or 2s, count the number of substring which have 
equal number of 0s, 1s and 2s.

In the hash map we will store 2s-1s and 1s-0s
When this pair will repeat then this means that equal no. of 0s,1s and 2s have been added 

We have to choose the start and end for each substring

If this pair repeats two times
Then we have two choices of start and end
No. of ways to choose is 2c2

If this pair repeats 3 times then we have 3c2 ways to choose and so on

1021002

Example
No. of 0s			0		0		0		1		1		1		2		3		3
No. of 1s			1		0		1		1		1		2		2		2		2
No. of 2s			2		0		0		0		1		1		1		1		2
HashMap						0/0		-1/1	-1/0	0/0		-1/1	-1/0	-1/-1	0/-1


HashMap

0/0 	-> 2
-1/1	-> 2
-1/0    -> 2
0/-1    -> 1
-1/-1   -> 1

Result = 2c2 + 2c2 + 2c2 = 3
 */



import java.util.*;

public class ZeroesOnesAndTwos {

    public static void equal_012(String line) {
    	
    	int result = 0;
    	
    	int zeroes = 0;
    	int ones = 0;
    	int twos = 0;
    	
    	HashMap<String,Integer> H = new HashMap<>();
    	
    	H.put("0/0",1);
    	
    	for(int i=0 ; i<line.length() ; i++)
    	{
    		char ch = line.charAt(i);
    		
    		if(ch=='0')
    		{
    			zeroes++;
    		}
    		else if(ch=='1')
    		{
    			ones++;
    		}
    		else if(ch=='2')
    		{
    			twos++;
    		}
    		
    		String first = (twos-ones)+"";
    		String second = (ones-zeroes)+"";
    		String check = first+"/"+second;
    		if(!H.containsKey(check))
    		{
    			H.put(check,1);
    		}
    		else
    		{
    			H.put(check,H.get(check)+1);
    		}
    	}
    	
    	for(String str : H.keySet())
    	{
    		int freq = H.get(str);
    		result += (freq*(freq-1))/2;
    	}
    	
    	System.out.println(result);
    }

    // Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        equal_012(sc.next());

    }

}