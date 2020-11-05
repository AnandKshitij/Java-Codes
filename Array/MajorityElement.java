package Array;

/*
1. Given an array of size n, find the majority element. 
2. The majority element is the element that appears more than n/2 times.
*/

/*
We will be using the Moore's method to find the majority element

Using Moore's method we will be able to find the majority element in O(n) time and constant space
 */

import java.util.*;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
       
    	int maj = nums[0];
    	int count = 1;
    	
    	for(int i=1; i<nums.length; i++) {
    		int val = nums[i];
    		
    		if(val==maj) {
    			count++;
    		}
    		else {
    			count--;
    			if(count==0) {
    				maj = nums[i];
    				count = 1;
    			}
    		}
    	}
    	
    	int majCount = 0;
    	
    	for(int i=0; i<nums.length; i++) {
    		if(maj==nums[i]) {
    			majCount++;
    		}
    	}
    	
    	if(majCount>nums.length/2) {
    		return maj;
    	}
    	
    	return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr));
    }
}
