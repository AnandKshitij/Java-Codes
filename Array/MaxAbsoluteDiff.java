package Array;

/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) 
for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, 
where |x| denotes absolute value of x.
*/

/*
There are 4 possible ways to evaluate |A[i]-A[j]| + |i-j|

Case I : i>=j && A[i]>=A[j]
A[i]-A[j] + i-j 
= (A[i]+i) - (A[j]+j)

Case II : i>=j && A[i]<A[j]
-A[i]+A[j] + i-j
= -(A[i]-i) + (A[j]-j)

Case III : i<j && A[i]>=A[j]
A[i]-A[j] - i + j 
= (A[i]-i) - (A[j]-j)

Case IV : i<j && A[i]<A[j]
-A[i]+A[j] - i + j
= -(A[i]+i) + (A[j]+j)

Case II and III are same with i & j intercahnged
Similarly, Case I and IV are same with i & j intercahnged

So, we have only 2 cases
 */

import java.util.*;

public class MaxAbsoluteDiff {
	
	public static int maxDiff(ArrayList<Integer> A) {
		int n = A.size();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			int val = A.get(i);
			max = Math.max(val, max);
			min = Math.min(val, min);
		}
		
		return (max-min);
	}
	
	public static int maxArr(ArrayList<Integer> A) {
		int n = A.size();
		
		if(n==0 || n==1) {
			return 0;
		}
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int val = A.get(i)+i;
			arr1.add(val);
		}
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int val = A.get(i)-i;
			arr2.add(val);
		}
		
		int smallAns1 = maxDiff(arr1);
		int smallAns2 = maxDiff(arr2);
		
		return Math.max(smallAns1, smallAns2);
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = s.nextInt();
			arr.add(a);
		}
		int res = maxArr(arr);
		System.out.println(res);
	}
}
