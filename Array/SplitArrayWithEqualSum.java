package Array;

/*
1. You will be given an array
2. you need to find if there are triplets (i, j, k) that follow these rules:
a) 0 < i, i + 1 < j, j + 1 < k < n - 1
b)Sum of sub arrays (0, i-1), (i+1,j-1), (j+1, k-1) and (k+1, n-1) should be same
3. Return true if triplet is found, else false
*/


import java.util.*;

public class SplitArrayWithEqualSum {
    
	public static ArrayList<Integer> findMid(int[] arr, int start, int end) {
		
		int ls = 0;
		int rs = 0;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1; i<arr.length; i++) {
			rs += arr[i];
		}
		
		for(int i=1; i<arr.length-1; i++) {
			ls += arr[i-1];
			rs -= arr[i];
			if(ls==rs) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	// It should return a boolean value.
    public static boolean splitArray(int[] nums) {
   	 
    	ArrayList<Integer> J = findMid(nums,0,nums.length-1);
    	
    	if(J.size()==0) {
    		return false;
    	}
    	
    	for(int i=0; i<J.size(); i++) {
    		int j = J.get(i);
    		
    		ArrayList<Integer> I = findMid(nums,0,j-1);
    		ArrayList<Integer> K = findMid(nums,j+1,nums.length-1);
    		
    		if(I.size()!=0 && K.size()!=0) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scn.nextInt();
        }
        System.out.print(splitArray(nums));
    }
}