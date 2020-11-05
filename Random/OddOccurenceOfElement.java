package Random;

/*
1. You are given an array of positive integers where all numbers occur even number of times except one number which occurs odd 
number of times.
2. You have to find the number occurring odd number of times.
3. main takes input from the users.
4. This is a functional problem. 
5. You have to complete the solve function. It takes as input an array of integers. It should return the number occurring odd 
number of times.
6. Don't change the code of main.
*/

/*
This question can be done with hash map or hash sets but that will require O(n) space
We can also solve with question with O(1) space complexity and O(n) time complexity
We will be using XOR for that

Properties of XOR:
a^b = b^a
a^0 = a
a^a = 0

So if we will take the XOR of all the elements in the array then only the element having odd frequency will be left
 */

import java.util.*;

public class OddOccurenceOfElement {

	public static int solve(int[] arr) {
     
		int result = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			result = result^arr[i];
		}
		
		return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr));

    }
}
