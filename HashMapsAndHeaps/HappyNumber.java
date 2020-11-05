package HashMapsAndHeaps;

/*
1. You are given a number N.
2. You have to find whether N is "happy" or not.
3. A happy number is a number defined by the following process: Starting with any positive integer, replace the number 
by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops 
endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

For Example: 
Input: 19
Output: Happy

Explanation: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

4. main takes input N from the users.
5. This is a functional problem. 
6. You have to complete the isHappy function. It takes as input the number N. It should return true if N is happy,
else should return false.
 */

import java.util.*;

public class HappyNumber {
	
	public static int squareSum(int n)
	{
		int sum = 0;
		
		while(n>0)
		{
			int digit = n%10;
			sum += digit*digit;
			n = n/10;
		}
		
		return sum;
	}
	
    public static boolean isHappy(int n) {
       
    	HashSet<Integer> H = new HashSet<>();
    	
    	H.add(n);
    	
    	int SquareSum = squareSum(n);
    	
    	while(SquareSum!=1)
    	{
    		if(H.contains(SquareSum))
    		{
    			return false;
    		}
    		H.add(SquareSum);
    		SquareSum = squareSum(SquareSum);
    	}
    	
    	return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (isHappy(N)) {
            System.out.println("Happy");
        } else {
            System.out.println("Not Happy");
        }
    }

}