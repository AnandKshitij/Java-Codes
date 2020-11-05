package Array;

/*
1. In LOL world, there is a hero called Dr. X and his attacking can make his enemy Dormamu be in poisoned condition. 
2. You are given Dr. X's attacking ascending time series towards Dormamu and the poisoning time duration per Dr X's attacking.
3. Return the total time that Dormamu is in poisoned condition.
4. You may assume that Dr. X attacks at the very beginning of a specific time point, and makes Dormamu be in poisoned condition immediately.

Input: [1,2], 2
Output: 3
Explanation: At time point 1, attack starts. 
This poisoned status will last 2 seconds until the end of time point 2. 
However, at the beginning of time point 2, Dormamu is attacked again who is already in poisoned status. 
Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will 
stop at the end of time point 3. 
So you finally need to output 3.
 */


import java.util.*;

public class Attack {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        
    	int poisonTime = 0;
    	
    	int start1 = timeSeries[0];
    	int end1 = timeSeries[0]+duration;
    	
    	for(int i=1; i<timeSeries.length; i++) {
    		
    		int val = timeSeries[i];
    		
    		if(val<=end1) {
    			end1 = val+duration;
    		}
    		else {
    			poisonTime += end1-start1;
    			start1 = val;
    			end1 = start1+duration;
    		}
    	}
    	
    	poisonTime += end1-start1;
    	return poisonTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] timeseries = new int[n];
        for (int i = 0; i < n; i++) {
            timeseries[i] = sc.nextInt();
        }
        System.out.println(findPoisonedDuration(timeseries, k));
    }
    
}