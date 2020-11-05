package Random;

/*
1. You are given a non-negative integer N.
2. You have to find the number of prime numbers less than N.
3. main takes input N from the users.
4. This is a functional problem. 
5. You have to complete the countPrimes function. It takes as input N. It should return the count of primes less N.
6. Don't change the code of main.
*/

/*
For this problem we will be using sieve of Eratosthenes
*/

import java.util.*;

public class NoOfPrimes {
	
	public static int findPrimes(int n)
	{
		boolean Prime[] = new boolean[n];
		
		for (int i=2; i < Prime.length; i++) 
		{
			Prime[i] = true;
		}
		
		for(int i=2 ; i*i<Prime.length ; i++)
		{
			if(!Prime[i])
			{
				continue;
			}
			int j = i*i;
			for( ; j<Prime.length; j=j+i)
			{
				Prime[j] = false;
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < Prime.length; i++) {
			if(Prime[i])
			{
				count++;
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int result = findPrimes(n);
		
		System.out.println(result);
	}

}
