package DynamicProgramming;

/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this 
notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
*/

import java.util.*;

public class CopyPasteKeyBoard {	
	public static int minSteps(int n) {
		int steps = 0;
		for(int f=2; f*f<=n; f++) {
			while(n%f==0) {
				steps += f;
				n = n/f;
			}
		}
		if(n!=1) {
			steps += n;
		}
		return steps;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minSteps(n));
		s.close();
	}

}
