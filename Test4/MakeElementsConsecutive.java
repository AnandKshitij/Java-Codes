package Test4;

import java.util.*;

public class MakeElementsConsecutive {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		
		for(int i=0; i<input.length; i++) {
			input[i] = s.nextInt();
		}
		
		Arrays.sort(input);
		
		int min = input[0];
		int max = input[input.length-1];
		
		int minRange = min+n-1;
		int maxRange = max-n+1;
		
		int minElements = 0;
		
		for(int i=0; i<n; i++) {
			if(input[i]<=minRange) {
				minElements++;
			}
		}
		
		int minSequenceSteps = n-minElements;
		
		if(minSequenceSteps==1) {
			for(int i=0; i<n; i++) {
				if(input[i]==minRange) {
					minSequenceSteps--;
					break;
				}
			}
			minSequenceSteps++;
		}
		
		
		
		int maxElements = 0;
		
		for(int i=0; i<n; i++) {
			if(input[i]>=maxRange) {
				maxElements++;
			}
		}
		
		int maxSequenceSteps = n-maxElements;
		
		if(maxSequenceSteps==1) {
			for(int i=n-1; i>=0; i--) {
				if(input[i]==maxRange) {
					maxSequenceSteps--;
					break;
				}
			}
			maxSequenceSteps++;
		}
		
		int minAns = Math.min(minSequenceSteps,maxSequenceSteps);
		int maxAns = Math.max(minSequenceSteps,maxSequenceSteps);
		
		System.out.println(minAns + " " + maxAns);
	}
}
