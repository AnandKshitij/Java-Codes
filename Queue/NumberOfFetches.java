package Queue;

import java.util.*;

/*
Write a class RecentFetch to count recent fetches.
It has only one method: ping(int t), where t represents present time in milliseconds.
Return the number of pings that have been made from 3000 milliseconds ago until now.
Any ping with time in [t - 3000, t] will count, including the current ping.

Example
inputs = 1 100 3001 3002
Output: 1 2 3 3


We will do this question with the help of virtual queue
Using i and j pointers
Initially both i and j are at 0
Ans = j-i+1 =1
Then j++;

Now value at j index = 100(jVal)
and value at i index = 1(iVal)

i>=jVal-3000
So Ans = j-i+1 = 2
j++

Now value at j index = 3001(jVal)
and value at i index = 1(iVal)

i>=jVal-3000
So Ans = j-i+1 = 3
j++

Now value at j index = 3002(jVal)
and value at i index = 1(iVal)

i>=jVal-3000(false)
So i++

Now value at j index = 3002(jVal)
and value at i index = 100(iVal)

i>=jVal-3000
So Ans = j-i+1 = 3
j++

Now j goes out of bound
 */

public class NumberOfFetches
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		int input[] = new int [N];
		
		for(int i=0 ; i<N ; i++)
		{
			input[i] = s.nextInt();
		}
		
		int result[] = new int [N];
		
		for(int i=0,j=0 ; j<N ; )
		{
			int iVal = input[i];
			int jVal = input[j];
			
			
			if(iVal>=jVal-3000)
			{
				result[j] = j-i+1;
				j++;
			}
			else
			{
				i++;
			}
		}
		
		for(int i=0 ; i<N ; i++)
		{
			System.out.print(result[i]+" ");
		}
		
		
	}
}