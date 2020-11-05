package Array;

/*
1. You will be given a sorted array and 3 integers: a,b,c
2. You need to apply quadratic function a*x^2+b*x+c on each element x of the array 
3. You need to return the given array after applying the aforementioned function in a sorted order
*/


import java.util.*;

public class SortTransformedArray {

	public static int calc(int x, int a, int b, int c) {
		int x2 = x*x;
		
		int result = a*x2 + b*x + c;
		return result;
	}
	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	 	
		int result[] = new int [nums.length];
		
		if(a==0) {
			for(int i=0; i<nums.length; i++) {
				result[i] = calc(nums[i],a,b,c);
			}
		}
		
		else if(a>0) {
			int endIndex = nums.length-1;
			int startIndex = 0;
			
			for(int i=nums.length-1; i>=0; i--) {
				
				int val1 = calc(nums[startIndex],a,b,c);
				int val2 = calc(nums[endIndex],a,b,c);
				
				if(val1>val2) {
					result[i] = val1;
					startIndex++;
				}
				else {
					result[i] = val2;
					endIndex--;
				}
			}
		}
		
		else {
			int endIndex = nums.length-1;
			int startIndex = 0;
			
			for(int i=0; i<nums.length; i++) {
				
				int val1 = calc(nums[startIndex],a,b,c);
				int val2 = calc(nums[endIndex],a,b,c);
				
				if(val1<val2) {
					result[i] = val1;
					startIndex++;
				}
				else {
					result[i] = val2;
					endIndex--;
				}
			}
			
		}
		
		return result;
	}
	
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        Arrays.sort(nums);
        int a=scn.nextInt();
        int b=scn.nextInt();
        int c=scn.nextInt();
        int[] res=sortTransformedArray(nums, a, b, c);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
	 }
}