package HashMapsAndHeaps;

/*
1. Given an array with positive number the task to find the largest subsequence from array that contain elements 
which are Fibonacci numbers.

Sample Input
7
1 4 3 9 10 13 7
Sample Output
1 3 13
*/


import java.lang.*;
import java.io.*;
import java.util.*;

public class LongestFibonacciSubsequence {

    public static void solve(int[] arr) {
        
    	int max = Integer.MIN_VALUE;
    	
    	for(int i=0; i<arr.length; i++)
    	{
    		if(arr[i]>max)
    		{
    			max = arr[i];
    		}
    	}
    	
    	//contains all fibonacci no.'s till maximum value
    	HashSet<Integer> H = new HashSet<>();
    	
    	H.add(0);
    	H.add(1);
    	
    	int n1 = 0;
    	int n2 = 1;
    	
    	while((n1+n2)<=max)
    	{
    		int temp = n1+n2;
    		n1 = n2;
    		n2 = temp;
    		H.add(n2);
    	}
    	
    	for(int i=0; i<arr.length; i++)
    	{
    		if(H.contains(arr[i]))
    		{
    			System.out.print(arr[i]+" ");
    		}
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        solve(num);
    }

}