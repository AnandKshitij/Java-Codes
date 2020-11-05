package Array;

/*
1. You are given an array of N elements, where each element of the array represents the height of the terrain at that index.
2. The width of the terrain at each index is 1.
3. You are also given two numbers V and K which represent that V droplets of water fall at index K.
4. You have to find the height of each index when all droplets of water have fallen and settled.
5. A droplet first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according 
to the following rules:
a) If the droplet would eventually move to a lower level by moving left, then it moves left.
b) Otherwise, if the droplet would eventually move to a lower level by moving right, then it moves right.
c) Otherwise, it stays at its current position.
By level, we mean the total height of the terrain plus any water in that column. Assume there are infinite height terrains 
at boundaries.

6. For example:
Input: heights = [2,1,1,2,1,2,2], V = 4, K = 3
Output: [2,2,2,3,2,2,2]
*/


import java.util.*;

public class PourWater {

    public static int[] pourWater(int[] heights, int v, int k) {
    	
    	for(int i=0; i<v; i++) {
    		
    		boolean isPlaced = false;
    		
    		if(k-1>=0 && heights[k-1]<=heights[k]) {
    			int index = k-1;
    			
    			while(index>0) {
    				if(heights[index-1]<=heights[index]) {
    					index--;
    				}
    				else {
    					break;
    				}
    			}
    			
    			while(index<k && heights[index+1]==heights[index]) {
    				index++;
    			}
    			
    			if(index!=k) {
    				heights[index]++;
        			isPlaced = true;
    			}
    		}
    		
    		if(!isPlaced && k+1<heights.length && heights[k+1]<=heights[k]) {
    			
    			int index = k+1;
    			
    			while(index<heights.length-1) {
    				if(heights[index+1]<=heights[index]) {
    					index++;
    				}
    				else {
    					break;
    				}
    			}
    			
    			while(index>k && heights[index-1]==heights[index]) {
    				index--;
    			}
    			
    			if(index!=k) {
    				heights[index]++;
    				isPlaced = true;
    			}
    		}
    		
    		if(!isPlaced) {
    			heights[k]++;
    		}
    	}
    	
    	return heights;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int V = sc.nextInt();
        int K = sc.nextInt();

        int[] result = pourWater(arr1, V, K);
        display(result);

    }

    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}