package DynamicProgramming;


/*
1. You will be given an Integer array of envelopes that consists of their widths and heights
2. You need to find maximum number of envelopes you can put inside another much like a 
russian doll
3. An envelope can only fit inside another if it's smaller than the other

Sample Input
5
2 9 
1 4 
7 1 
10 7 
8 3
Sample Output
3
*/

import java.util.*;

public class RussianDolls {
	
	static class Pair{
		int height;
		int width;
		
		public Pair(int height, int width) {
			this.height = height;
			this.width = width;
		}
	}
	
	static class heightComparator implements Comparator<Pair>{
		public int compare(Pair P1, Pair P2) {
			return P1.height-P2.height;
		}
	}
	
	public static void disp(Pair arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i].height+"      ");
		}
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i].width+"      ");
		}
		System.out.println();
	}
	
	public static int maxEnvelopes(int[][] envelopes) {
		
		int n = envelopes.length;
		
		Pair dimensions[] = new Pair[n];
		
		for(int i=0; i<envelopes.length; i++) {
			Pair P = new Pair(envelopes[i][0],envelopes[i][1]);
			dimensions[i] = P;
		}
		
		disp(dimensions);
		
		Arrays.sort(dimensions,new heightComparator());
		
		disp(dimensions);
		int lis[] = new int [n];
	
		int absMax = 0;
		
		for(int i=0; i<n; i++) {
			int max = 0;
			
			for(int j=i-1; j>=0; j--) {
				if(dimensions[i].width>dimensions[j].width && dimensions[i].height!=dimensions[j].height) {
					max = Math.max(max,lis[j]);
				}
			}
			
			lis[i] = max+1;
			
			absMax = Math.max(absMax,lis[i]);
		}
		
		return absMax;
		
		
	}
	
	public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int r=scn.nextInt();
	 	 int envelopes[][]=new int[r][2];
	 	 for(int i=0;i<r;i++){
            for(int j=0;j<2;j++){
                envelopes[i][j]=scn.nextInt();
            }
	 	 }
	 	 System.out.println(maxEnvelopes(envelopes));
	 	 scn.close();
	}

}
