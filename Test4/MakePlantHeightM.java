package Test4;

import java.util.*;

public class MakePlantHeightM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int Q = s.nextInt();
		int m = s.nextInt();
		
		int arr[] = new int [n+2];
		
		int qStart[] = new int [Q];
		int qEnd[] = new int [Q];
		
		for(int i=0; i<Q; i++) {
			
			qStart[i] = s.nextInt();
			qEnd[i] = s.nextInt();
			int start = qStart[i];
			int end = qEnd[i];
			
			arr[start]++;
			arr[end+1]--;
		}
		
		int pSum = 0;
		int prefixSum[] = new int [arr.length];
		
		for(int i=0; i<arr.length; i++) {
			pSum = pSum + arr[i];
			prefixSum[i] = pSum;
		}
		
		//sum m encountered so far
		int arr1[] = new int[prefixSum.length];
		//sum m+1 encountered so far
		int arr2[] = new int[prefixSum.length];
		
		
		int ans = 0;

		int m1 = 0;
		int m2 = 0;
		
		for(int i=0; i<prefixSum.length; i++) {
			if(prefixSum[i]==m) {
				m1++;
			}
			else if(prefixSum[i]==m+1) {
				m2++;
			}
			
			arr1[i] = m1;
			arr2[i] = m2;
		}
		
		int finalM = arr1[arr1.length-1];
		
		for(int i=0; i<Q; i++) {
			int start = qStart[i];
			int end = qEnd[i];
			
			int temp = finalM;
			
			int m1Start = arr1[start-1];
			int m1End = arr1[end];
			
			int m2Start = arr2[start-1];
			int m2End = arr2[end];
			
			temp -= m1End-m1Start;
			temp += m2End-m2Start;
			
			if(temp>ans) {
				ans = temp;
			}
		}
		
		System.out.println(ans);
	}
}
