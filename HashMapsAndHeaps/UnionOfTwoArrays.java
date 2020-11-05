package HashMapsAndHeaps;

/*
1. You are given two arrays with N and M distinct elements.
2. You have to find the union between these two arrays.
3. Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there 
are repetitions, then only one occurrence of an element should be present in the union.

Sample Input
6
1 3 5 7 9 11
4
1 2 3 4
Sample Output
1 2 3 4 5 7 9 11
*/

import java.util.*;

public class UnionOfTwoArrays{
	
    public static int[] union(int[] arr1, int[] arr2) {
    	
    	HashSet<Integer> H = new HashSet<>();
    	
    	for (int i = 0; i < arr1.length; i++) {
			H.add(arr1[i]);
		}
    	
    	for (int i = 0; i < arr2.length; i++) {
			H.add(arr2[i]);
		}
    	
    	int arr[] = new int [H.size()];
    	
    	int j = 0;
    	for(int i : H)
    	{
    		arr[j++] = i;
    	}
    	
    	Arrays.sort(arr);
    	
    	return arr;
        
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

        // Input for length of second array.
        int M = sc.nextInt();

        int[] arr2 = new int[M];

        // Input for array2 elements.
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result = union(arr1, arr2);

        Arrays.sort(result);
        display(result);

    }

    // Function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}