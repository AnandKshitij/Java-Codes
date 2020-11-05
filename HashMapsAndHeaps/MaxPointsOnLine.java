package HashMapsAndHeaps;

/*
1. Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/*
We select one point at a time
Then from that point we calculate the slope of all the lines 
We maintain a hash map for that 
The maximum slope occurring for each point is the no. of points on the line starting with that line and the slope as given
We start from the next point from every line

At the end we return max+1
Because for every point that point itself always is on every line
*/

import java.util.*;

public class MaxPointsOnLine {

	public static int gcd(int a, int b)
	{
		if(b==0)
		{
			return a;
		}
		return gcd(b,a%b);
	}
	
    public static int maxPoints(Point[] points) {
        //Write your code here
    	
    	int max = 0;
    	
    	for(int i=0; i<points.length; i++)
    	{
    		Point P = points[i];
    		int pointX = P.x;
    		int pointY = P.y;
    		
    		HashMap<String,Integer> H = new HashMap<>();
    		
    		int currMax = 0;
    		
    		for(int j=i+1; j<points.length; j++)
    		{
    			Point P1 = points[j];
    			int nextX = P1.x;
    			int nextY = P1.y;
    			
    			int slopeX = nextX-pointX;
    			int slopeY = nextY-pointY;
    			
    			int gcd = gcd(slopeX,slopeY);
    			
    			slopeX = slopeX/gcd;
    			slopeY = slopeY/gcd;
    			
    			String str = slopeX + "/" + slopeY;
    			
    			if(!H.containsKey(str))
    			{
    				H.put(str,1);
    				if(1>currMax)
    				{
    					currMax = 1;
    				}
    			}
    			else
    			{
    				H.put(str,H.get(str)+1);
    				
    				if(H.get(str)>currMax)
    				{
    					currMax = H.get(str);
    				}
    			}
    		}
    		
    		if(currMax>max)
    		{
    			max = currMax;
    		}
    	}
    	
    	return (max+1);
    	
    }

    ///Dont make changes here
    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        System.out.println(maxPoints(points));
    }
}
