package Array;

/*
1. You will be given coordinates as an array wherein, x,y is written as i,a[i]
2. So two end points of vertical line i is at (i, a[i]) and (i, 0)
3. You need to find two lines, which together along with x-axis forms a container, such that the container contains the most water

NOTE: a) a[i] value need not be distinct
b) You can't slant a line

Sample Input
8
2 10 6 5 8 7 1 3
Sample Output
28
*/


import java.util.*;

public class WaterContainer {
	
    public static void main(String[] args){
        
    	Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] height= new int[n];
        for(int i=0;i<n;i++){
            height[i]=scn.nextInt();
        }
        System.out.print(maxArea(height)); 
    }  

	 public static int maxArea(int[] height) {
		 
		 int maxArea = Integer.MIN_VALUE;
		 
		 int start = 0;
		 int end = height.length-1;
		 
		 while(start<end) {
			 int width = end-start;
			 int h = 0;
			 
			 if(height[start]<=height[end]) {
				 h = height[start];
				 start++;
			 }
			 else {
				 h = height[end];
				 end--;
			 }
			 
			 int area = h*width;
			 
			 if(area>maxArea) {
				 maxArea = area;
			 }
		 }
		 
		 return maxArea;
	 }
}