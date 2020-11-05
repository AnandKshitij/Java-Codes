package HashMapsAndHeaps;

/*

1. In a forest, each rat has some color. Some subset of rats (possibly all of them) tell you how 
many other rats have the same color as them. 
2. Those answers are placed in an array.
3. Return the minimum number of rats that could be in the forest.

Input: answers = [1, 1, 2]
Output: 5

We will draw a hash map

Reported(c)   No. of Reporters(r)
   1           2
   2           1
   
So 2 rats have reported that there is 1 more rat
So minimum no. rats = 2

1 rat has reported that there are 2 more rats 
So minimum no. of rats = 3

So total = 2+3 = 5

Input: answers = [2,3,4,2,3,2,2,5]

We will draw a hash map

Reported(c)   No. of Reporters(r)
   2           4
   3           2
   4		   1
   5		   1
   
So 4 rats have reported that there are 2 more rats
So minimum no. rats = 2+1  = 3
But we have 4 reporters. So this means that are two groups of 3 rats
So no. of rats = 6

2 rats have reported that there are 3 more rats 
So minimum no. of rats = 3+1 = 4

1 rat has reported that there are 4 more rats 
So minimum no. of rats = 4+1 = 5

1 rat has reported that there are 5 more rats 
So minimum no. of rats = 5+1 = 6

So total = 6+4+5+6 = 21



So we can deduce the general formula from here 

No. of rats in group = c+1
No. of groups = ceil[r/(c+1)]
 */


import java.util.*;

public class RatInAJungle {

    public static int numRats(int[] answers) {
    	HashMap<Integer,Integer> H = new HashMap<>();
    	
    	for(int i=0 ; i<answers.length ; i++)
    	{
    		if(!H.containsKey(answers[i]))
    		{
    			H.put(answers[i],1);
    		}
    		else
    		{
    			H.put(answers[i],H.get(answers[i])+1);
    		}
    	}
    	
    	
    	int result = 0;
    	
    	for(int i : H.keySet())
    	{
    		int c = i+1;
    		int r = H.get(i);
    		
    		int groups = 0;
    		
    		if(r%c==0)
    		{
    			groups = r/c;
    		}
    		else
    		{
    			groups = (r/c)+1;
    		}
    		
    		result += c*groups;
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[sc.nextInt()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = sc.nextInt();
        }
        System.out.println(numRats(answers));
    }

}