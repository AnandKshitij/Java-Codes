package Random;

/*
There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. The counting begins at point 1 in the circle and 
proceeds around the circle in a fixed direction (clockwise). In each step, a certain number of people are skipped and the next person is 
executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only 
the last person remains, who is given freedom.

Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle. The task 
is to choose the place in the initial circle so that you are the last one remaining and so survive.

Consider if n = 5 and k = 2, then the safe position is 3.
Firstly, the person at position 2 is killed, then person at position 4 is killed, then person at position 1 is killed. Finally, the person at 
position 5 is killed. So the person at position 3 survives.

Input
3
2 1
4 2
50 10

Output
2
1
36
*/

/*
The problem can be broken into sub problems
If earlier we have n people then in next step we will have n-1 people
And the position to kill will change by k
So a[i] = a[i-1]+k
This is a circular array
So for position we have to take its mod with length 
a[i] = (a[i-1] + k) % i

*/

import java.util.*;

public class JosephusProblem {
	
	public static int getSafePos(int n, int k) {
		if(n==1) {
			return 0;
		}
		
		int dp[] = new int [n+1];
		
		for(int i=2; i<n+1; i++) {
			dp[i] = ((dp[i-1] + k) % i);
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int m=0; m<T; m++) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			int ans = getSafePos(n,k);
			System.out.println(ans+1);
		}
		s.close();
	}
}
