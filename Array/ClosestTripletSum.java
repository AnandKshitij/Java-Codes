package Array;

/*
1. You will be given an array
2. You will also get an integer target
3. You need to find a triplet in the array whose sum is the closest to the target value
4. Return this closest possible sum

Sample Input
8
-4 -4 -1 3 -5 4 -2 1 
9
Sample Output
8
*/

import java.util.*;

public class ClosestTripletSum {
    
	public static int threeSumClosest(int[] nums, int target) {
   	 
		Arrays.sort(nums);
		
		int bestAns = 0;
		int bestDiff = Integer.MAX_VALUE;
		
		for(int i=0; i<nums.length-1; i++) {
			
			int tempTarget = target-nums[i];
			
			int start = i+1;
			int end = nums.length-1;
			
			while(start<end) {
				int pairSum = nums[start]+nums[end];
				if(pairSum==tempTarget) {
					return target;
				}
				else if(pairSum<tempTarget) {
					int diff = tempTarget-pairSum;
					if(diff<bestDiff) {
						bestDiff = diff;
						bestAns = target-bestDiff;
					}
					start++;
				}
				else {
					int diff = pairSum-tempTarget;
					if(diff<bestDiff) {
						bestDiff = diff;
						bestAns = target+bestDiff;
					}
					end--;
				}
			}
		}
		
		return bestAns;
	}
	
	public static void main(String[] args){ 
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        System.out.print(threeSumClosest(nums,k));
	 }
}