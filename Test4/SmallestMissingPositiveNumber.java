package Test4;

import java.util.*;

public class SmallestMissingPositiveNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int [n];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = s.nextInt();
		}

		int i=0;
		
		for(; i<input.length; i++) {
			if(input[i]<0) {
				break;
			}
		}
		
		if(i!=input.length) {
			int j=i+1;
			while(j<input.length) {
				if(input[j]<=0) {
					j++;
				}
				else {
					int temp = input[j];
					input[j] = input[i];
					input[i] = temp;
					j++;
					i++;
				}
			}
		}
		
		n = i;
		
		for(i=0; i<n; i++) {
			int temp = input[i];
			
			if(temp<0) {
				temp = -1*temp;
			}
			
			int index = temp-1;
			if(index>=0 && index<input.length)
			input[index] = -1*input[index];
		}
		
		int ans = n+1;
		
		for(i=0; i<n; i++) {
			if(input[i]>0) {
				ans = i+1;
				break;
			}
		}
	
		System.out.println(ans);
		
	}
}
