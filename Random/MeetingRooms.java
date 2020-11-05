package Random;

/*
1. You are given a 2D array containing the start and end times of various meetings [[s1, e1], [s2, e2] , ....].
2. Obviously si < ei , i.e start time is less than end time for every meeting.
3. You have to find minimum number of rooms required to hold these meetings.
4. For example:
Input: [[7,10],[2,4]]
Output: 1

Sample Input
2
7 10
2 4
Sample Output
1
 */


import java.util.*;

public class MeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
       
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=0; i<intervals.length; i++)
    	{
    		int start = intervals[i][0];
    		int end = intervals[i][1];
    		
    		if(start<min)
    		{
    			min = start;
    		}
    		if(end>max)
    		{
    			max = end;
    		}
    	}
    	
    	int arr[] = new int [max-min+1];
    	
    	for(int i=0; i<intervals.length; i++)
    	{
    		int start = intervals[i][0]-min;
    		int end = intervals[i][1]-min;
    		
    		arr[start] += 1;
    		arr[end] -= 1;
    	}
    	
    	int prefixSum = 0;
    	
    	int result = 0;
    	
    	for(int i=0; i<arr.length; i++)
    	{
    		prefixSum += arr[i];
    		if(prefixSum>result)
    		{
    			result = prefixSum;
    		}
    	}
    	
    	return result;
    	
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for number of meetings.
        int N = sc.nextInt();

        int[][] intervals = new int[N][2];

        int start, end;
        // Input for intervals.
        for (int i = 0; i < intervals.length; i++) {

            start = sc.nextInt();
            end = sc.nextInt();

            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        int result = minMeetingRooms(intervals);

        System.out.println(result);

    }

    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        
    }

}