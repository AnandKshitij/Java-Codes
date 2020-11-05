package HashMapsAndHeaps;

/*
1. You are given two arrays of sizes M and N.
2. You have to check whether the second array is a subset of first array or not.
Note: Both the arrays can be both unsorted or sorted. It may be assumed that elements in both array are distinct.
*/


import java.util.*;

public class SubArray {

    public static boolean solve(int[] num1, int[] num2) {
       
    	HashMap<Integer, Integer> H = new HashMap<>();
    	
    	for(int i=0; i<num1.length; i++)
    	{
    		int val = num1[i];
    		
    		if(!H.containsKey(val))
    		{
    			H.put(val,1);
    		}
    		else
    		{
    			H.put(val,H.get(val)+1);
    		}
    	}
        
    	for(int i=0; i<num2.length; i++)
    	{
    		int val = num2[i];
    		
    		if(!H.containsKey(val))
    		{
    			return false;
    		}
    		else
    		{
    			if(H.get(val)<1)
    			{
    				return false;
    			}
    			else
    			{
    				H.put(val,H.get(val)-1);
    			}
    		}
    	}
    	
    	return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array1 = new int[N];

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            array1[i] = n;
        }

        int M = sc.nextInt();
        int[] array2 = new int[M];

        for (int i = 0; i < M; i++) {
            int m = sc.nextInt();
            array2[i] = m;
        }

        if (solve(array1, array2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
    
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}