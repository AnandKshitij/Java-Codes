package Array;

/*
1. You are given an array A of size N containing a permutation of the elements in the set {0, 1, ... , N-1}.
2. There is a global inversion when: i < j and A[i] > A[j] where 0 <= i < j < N.
3. There is a local inversion when: A[i] > A[i+1] where 0 <= i < N.
4. You have to find whether the number of global inversions are equal to the number of local inversions in the array or not.
5. For example,
Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
6. main takes input from the users.
 */


import java.util.*;

public class LocalAndGlobalInversions {
	
    public static boolean isIdealPermutation(int[] A) {
       
    	/*
    	Method1-
    	Do all the local inversions then check if the array is now sorted in increasing order or not
    	If the array is now sorted then the no. of local inversions is equal to the no, of global inversions
    	
    	int j=0;
    	while(j<A.length){
    		int val1 = A[j];
    		int index1 = j;
    		j++;
    		if(j<A.length) {
    			int val2 = A[j];
    			int index2 = j;
    			j++;
    			if(val1>val2) {
    				A[index1] = val2;
    				A[index2] = val1;
    			}
    		}
    	}
    	
    	for(int i=1; i<A.length; i++) {
    		
    		if(A[i]<A[i-1]) {
    			return false;
    		}
    	}
    	
    	return true;
        */
    	
    	/*
    	method2
    	We find max on right and min on left 
    	*/
    	
    	int n = A.length;
    	
    	int max[] = new int [n];
    	int min[] = new int [n];
    	
    	int maxIndex = -1;
    	int maxValue = Integer.MIN_VALUE;
    	
    	for(int i=0; i<n; i++) {
    		int val = A[i];
    		
    		if(val>maxValue) {
    			maxValue = val;
    			maxIndex = i;
    		}
    		
    		max[i] = maxIndex;
    		
    		if((int)Math.abs(maxIndex-i)>1) {
    			return false;
    		}
    		
    	}
    	
    	int minIndex = n;
    	int minValue = Integer.MAX_VALUE;
    	
    	for(int i=n-1; i>=0; i--) {
    		int val = A[i];
    		
    		if(val<minValue) {
    			minValue = val;
    			minIndex = i;
    		}
    		
    		min[i] = minIndex;
    		
    		if((int)Math.abs(minIndex-i)>1) {
    			return false;
    		}
    	}
    	
    	return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        if (isIdealPermutation(arr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
    
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}