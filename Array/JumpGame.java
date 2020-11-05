package Array;

/*
1.Given an array of non-negative integers, you are initially positioned at the first index of the array.

2.Each element in the array represents your maximum jump length at that position.

3.Your goal is to reach the last index in the minimum number of jumps.

Sample Input
5
2 3 1 1 4
Sample Output
2
*/

/*
By using greedy approach the time complexity becomes O(n). So we will be using greedy approach instead of DP.
 */

import java.util.Scanner;

public class JumpGame{
	
	 public static int jump(int[] nums) {
		 
		 int n = nums.length;
		 
		 int range[] = new int [n];
		 
		 for(int i=0; i<n; i++) {
			 range[i] = i+nums[i];
		 }
		 
		 int jumps = 1;
		 
		 int initial = 0;
		 int initialRange = range[0];
		 
		 while(initialRange<nums.length-1) {
			 
			 int newRange = initialRange;
			 for(int i=initial+1; i<=initialRange; i++) {
				 if(range[i]>newRange) {
					 newRange = range[i];
					 initial = i;
				 }
			 }
			 if(newRange==initialRange) {
				 return -1;
			 }
			 jumps++;
			 initialRange = newRange;
		 }
		 
		 return jumps;
	 }

	 public static void main(String[] args) {
	 	 Scanner s = new Scanner(System.in);
	 	 int n = s.nextInt();
	 	 int[] num = new int[n];
	 	 for (int i = 0; i < num.length; i++) {
	 	 	 num[i] = s.nextInt();
	 	 }
	 	 System.out.println(jump(num));
	 }

}