package HashMapsAndHeaps;

/*
1. You will be given an array of integers and a target
2. You have to find all such quadruples a,b,c,d such that a+b+c+d = target
3. Return your answer as ArrayList> or Vector> where each ArrayList/vector represents a quadruple.
4. Output contains all the valid quadruples ,input and output is handled for you
5. It is a functional problem ,please do not modify main()

Input Format
target
n: number of the elements
array of integers of n elements

Input is handled for you.
output Format
all the valid quadruples
Output is handled for you.
Constraints
The solution set must not contain duplicate quadruples.
 */

import java.util.*;

public class FourSum {


	    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

	    	Arrays.sort(nums);
	    	int n = nums.length;
	    	
	    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    	
	    	for(int i=0; i<n; i++)
	    	{
	    		int val1 = nums[i];
	    		
	    		for(int j=i+1; j<n; j++)
	    		{
	    			int val2 = nums[j];
	    			int find = target-val1-val2;
	    			
	    			int start = j+1;
	    			int end = n-1;
	    			
	    			while(start<end)
	    			{
	    				int val3 = nums[start];
	    				int val4 = nums[end];
	    				
	    				if((val3+val4)==find)
	    				{
	    					ArrayList<Integer> arr = new ArrayList<>();
	    					arr.add(val1);
	    					arr.add(val2);
	    					arr.add(val3);
	    					arr.add(val4);
	    					result.add(arr);
	    					
	    					while(start<n && nums[start]==val3)
	    					{
	    						start++;
	    					}
	    					while(end>=0 && nums[end]==val4)
	    					{
	    						end--;
	    					}
	    				}
	    				
	    				else if((val3+val4)<find)
	    				{
	    					while(start<n && nums[start]==val3)
	    					{
	    						start++;
	    					}
	    				}
	    				
	    				else
	    				{
	    					while(end>=0 && nums[end]==val4)
	    					{
	    						end--;
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    	}
	    	
	    	return result;
	    }

	    public static void main(String[] args) {
	    	    Scanner sc = new Scanner(System.in);
	    	    
	    	    int target = sc.nextInt();
	    	    int n = sc.nextInt();
	    	    int[] arr = new int[n];
	    	    for (int i = 0; i < n; i++) {
	    	    	    arr[i] = sc.nextInt();
	    	    }
	    	    

	    	    ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);
	    	    
	    	    for (ArrayList<Integer> a : ans) 
	    	    {
	    	    		Collections.sort(a);
	    	    	    for (int element : a) {
	    	    	    	    System.out.print(element + " ");
	    	    	    }
	    	    	    System.out.println();
	    	    }

	    }

}